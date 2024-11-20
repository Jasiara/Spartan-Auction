package com.csc340.SpartanAuction.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {
    @Autowired
    private BidService bidService;

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
    public List<Bid> addNewBid(@RequestBody Bid bid) {
        //System.out.println(bid.toString());
        bidService.addNewBid(bid);
        return bidService.getAllBids();
    }

    /*@GetMapping("/making-bid")
    public String createBidForm(@ModelAttribute("bid") )*/

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
