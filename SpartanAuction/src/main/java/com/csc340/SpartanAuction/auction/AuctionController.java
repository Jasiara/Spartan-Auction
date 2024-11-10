package com.csc340.SpartanAuction.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {
    @Autowired
    private AuctionService auctionService;

    @GetMapping("/all")
    public List<Auction> getAllAuctions() {
        return auctionService.getAllAuctions();
    }

    @GetMapping("/{id}")
    public Auction getAuctionById(@PathVariable int id) {
        Auction auction = auctionService.getAuctionById(id);
        return auction;
    }

    @PostMapping("/new")
    public Auction createAuction(@RequestBody Auction auction) {
        Auction createdAuction = auctionService.createAuction(auction);
        return createdAuction;
    }

    @PutMapping("/{id}")
    public Auction updateAuction(@PathVariable int id, @RequestBody Auction auctionDetails) {
        Auction updatedAuction = auctionService.updateAuction(id, auctionDetails);
        return auctionService.getAuctionById(updatedAuction.getId());
    }

    @DeleteMapping("/{id}")
    public List<Auction> deleteAuction(@PathVariable int id) {
        auctionService.deleteAuction(id);
        return auctionService.getAllAuctions();
    }
}