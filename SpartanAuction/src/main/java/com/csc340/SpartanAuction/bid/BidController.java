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
    public List<Bid> addNewBid(@ModelAttribute("bid") Bid bid) {
        //System.out.println(bid.toString());
        bidService.addNewBid(bid);
        return bidService.getAllBids();
    }

    @GetMapping("/making-bid/{itemId}")
    public String createBidForm(@PathVariable int itemId, Model model) {
        model.addAttribute("auction", auctionService.getAuctionById(itemId));
        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
        if (currentlyLoggedIn) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.getUserByUsername(name);
            model.addAttribute("user", user);
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

    @DeleteMapping("/delete/{id}")
    public List<Bid> deleteBidById(@PathVariable int id) {
        bidService.deleteBidById(id);
        return bidService.getAllBids();
    }
}
