package com.csc340.SpartanAuction.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.csc340.SpartanAuction.user.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/api/auctions")
public class AuctionController {
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private UserRepository userRepository; // Inject UserRepository

    @GetMapping("/all")
    public String getAllAuctions(Model model) {
        model.addAttribute("auctions", auctionService.getAllAuctions());
        return "";
    }

    @GetMapping("")
    public String getAllCurrentAuctions(Model model) {
        model.addAttribute("auctions", auctionService.getAllCurrentAuctions());
        return "index";
    }

    @GetMapping("/{id}")
    public String getAuctionById(Model model, @PathVariable int id) {
        model.addAttribute("auction", auctionService.getAuctionById(id));
        return "an-auction";
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