package com.csc340.SpartanAuction.auction;

import com.csc340.SpartanAuction.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.csc340.SpartanAuction.user.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private UserRepository userRepository; // Inject UserRepository

    @GetMapping("/all")
    public List<Auction> getAllAuctions() {
        return auctionService.getAllAuctions();
    }

    @GetMapping("/{id}")
    public Auction getAuctionById(@PathVariable int id) {
        Auction auction = auctionService.getAuctionById(id);
        return auction;
    }

    // GET item by its name
    @GetMapping("/name/{name}")
    public List<Auction> getAuctionsByName(@PathVariable String name) {
        return auctionService.getAuctionsByName(name);
    }

    // GET item by its category
    @GetMapping("/category/{category}")
    public List<Auction> getAuctionsByCategory(@PathVariable String category) {
        return auctionService.getAuctionsByCategory(category);
    }

    // GET statistics for items by provider
    @GetMapping("/provider/{providerId}/statistics")
    public List<Auction> getAuctionsByProvider(@PathVariable int providerId) {
        return auctionService.getAuctionsByProvider(providerId);
    }

    @PostMapping("/new")
    public List<Auction> createAuction(@RequestBody Auction auction) {
        // Check if the seller exists
        /*User seller = userRepository.findById(sellerId).orElse(null); // Use the repository instance
        if (seller == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found");
        }
        return auctionService.createAuction(auction, sellerId);*/

        auctionService.createAuction(auction);
        return auctionService.getAllAuctions();
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