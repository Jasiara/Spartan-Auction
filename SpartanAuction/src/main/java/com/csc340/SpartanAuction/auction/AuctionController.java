package com.csc340.SpartanAuction.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {
    @Autowired
    private AuctionService auctionService;

    @GetMapping
    public List<Auction> getAllAuctions() {
        return auctionService.getAllAuctions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auction> getAuctionById(@PathVariable int id) {
        Auction auction = auctionService.getAuctionById(id);
        return new ResponseEntity<>( auction, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) {
        Auction createdAuction = auctionService.createAuction(auction);
        return new ResponseEntity<>(createdAuction, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auction> updateAuction(@PathVariable int id, @RequestBody Auction auctionDetails) {
        Auction updatedAuction = auctionService.updateAuction(id, auctionDetails);
        return new ResponseEntity<>(updatedAuction, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuction(@PathVariable int id) {
        auctionService.deleteAuction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}