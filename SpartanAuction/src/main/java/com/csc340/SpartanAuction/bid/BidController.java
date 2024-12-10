package com.csc340.SpartanAuction.bid;

import com.csc340.SpartanAuction.auction.AuctionService;
import com.csc340.SpartanAuction.user.User;
import com.csc340.SpartanAuction.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bids")
public class BidController {
    @Autowired
    private BidService bidService;

    @Autowired
    private AuctionService auctionService;


    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @GetMapping("/item/{itemId}")
    public List<Bid> getAllBidsForOneItem(@PathVariable int itemId) {
        return bidService.getAllBidsForOneItem(itemId);
    }

    @GetMapping("/{id}")
    public Bid getOneBid(@PathVariable int id) {
        return bidService.getBidById(id);
    }

    @PostMapping("/new")
    public String addNewBid(@ModelAttribute("bid") Bid bid) {
        //System.out.println(bid.toString());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByUsername(username);
        bid.setUser(user);
        bidService.addNewBid(bid);
        return "redirect:/public/api/auctions/" + bid.getAuction().getId();
    }

    @GetMapping("/making-bid/{itemId}")
    public String createBidForm(@PathVariable int itemId, Model model) {
        model.addAttribute("auction", auctionService.getAuctionById(itemId));
        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
        if (currentlyLoggedIn) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.getUserByUsername(name);
            model.addAttribute("smallUser", user);
            return "a-bid";
        } else {
            return "a-bid";
        }
    }

    @PutMapping("/update/{id}")
    public Bid updateBid(@PathVariable int id, @RequestBody Bid bid) {
        bidService.updateBid(id, bid);
        return bidService.getBidById(id);
    }

    /*@DeleteMapping("/delete/{id}")
    public List<Bid> deleteBidById(@PathVariable int id) {
        bidService.deleteBidById(id);
        return bidService.getAllBids();
    }*/

    @GetMapping("/delete/one/{bidId}")
    public String deleteBidById(@PathVariable int bidId) {
        bidService.deleteBidById(bidId);
        return "redirect:/users/profile";
    }

    @GetMapping("/delete/all/{userId}/auction/{auctionId}")
    public String deleteAllBidsForOneUserAndAuction(@PathVariable int userId, @PathVariable int auctionId) {
        bidService.deleteAllBidsForOneUserAndAuction(userId, auctionId);
        return "redirect:/users/profile";
    }
}
