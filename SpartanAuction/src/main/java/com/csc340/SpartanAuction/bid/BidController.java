package com.csc340.SpartanAuction.bid;

import com.csc340.SpartanAuction.auction.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "a-bid";
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
