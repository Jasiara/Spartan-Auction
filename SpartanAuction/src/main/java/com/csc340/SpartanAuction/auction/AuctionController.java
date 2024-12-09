package com.csc340.SpartanAuction.auction;

import com.csc340.SpartanAuction.bid.Bid;
import com.csc340.SpartanAuction.bid.BidService;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompleted;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompletedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.csc340.SpartanAuction.user.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class AuctionController {
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private UserRepository userRepository; // Inject UserRepository

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewCompletedService reviewCompletedService;

    @Autowired
    private BidService bidService;

    @GetMapping("/api/auctions/all")
    public String getAllAuctions(Model model) {
        model.addAttribute("auctions", auctionService.getAllAuctions());
        return "";
    }

    @GetMapping("/ADMIN/all")
    public String getAuctionsForAdmins(Model model) {
        model.addAttribute("auctions", auctionService.getAllAuctions());
        return "admin-home";
    }

    @GetMapping("/public/api/auctions")
    public String getAllCurrentAuctions(Model model) {
        List<Auction> auctions = auctionService.getAllCurrentAuctions();
        model.addAttribute("auctions", auctions);
        return "index";
    }

    @GetMapping("/public/api/auctions/{id}")
    public String getAuctionById(Model model, @PathVariable int id) {
        model.addAttribute("auction", auctionService.getAuctionById(id));
        return "an-auction";
    }

    // GET item by its name
    @GetMapping("/api/auctions/name/{name}")
    public List<Auction> getAuctionsByName(@PathVariable String name) {
        return auctionService.getAuctionsByName(name);
    }

    // GET item by its category
    @GetMapping("/api/auctions/category/{category}")
    public List<Auction> getAuctionsByCategory(@PathVariable String category) {
        return auctionService.getAuctionsByCategory(category);
    }

    // GET statistics for items by provider
    @GetMapping("/api/auctions/provider/{providerId}/statistics")
    public List<Auction> getAuctionsByProvider(@PathVariable int providerId) {
        return auctionService.getAuctionsByProvider(providerId);
    }

    @PostMapping("/api/auctions/new/{sellerId}")
    public String createAuction(@ModelAttribute("auction") Auction auction, @PathVariable int sellerId,
                                @RequestParam String auctionEnd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(auctionEnd, formatter);
        Timestamp dateAndTime = Timestamp.valueOf(localDateTime);

        auction.setDateAndTime(dateAndTime);
        auction.setCurrentPrice(auction.getStartingPrice());
        User seller = userService.getUserById(sellerId);
        auction.setSeller(seller);
        auction.setAuctionStatus("active");
        auctionService.createAuction(auction);

        return "redirect:/users/profile/" + sellerId;
    }

    @GetMapping("/api/auctions/new-auction/{userId}")
    public String createNewAuctionForm(Model model, @PathVariable int userId) {
        model.addAttribute("user", userService.getUserById(userId));
        Auction auction = new Auction();
        return "auctioning";
    }


    @PostMapping("/api/auctions/update-auction/{id}")
    public String updateAuction(@PathVariable int id, @ModelAttribute("auction") Auction auction, @RequestParam String auctionEnd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(auctionEnd, formatter);
        Timestamp dateAndTime = Timestamp.valueOf(localDateTime);

        auction.setDateAndTime(dateAndTime);
        //auction.setAuctionStatus("active");
        auctionService.updateAuction(id, auction);
        User user = auctionService.getAuctionById(id).getSeller();
        return "redirect:/users/profile/" + user.getId();
    }

    @GetMapping("/api/auctions/update/{id}")
    public String showUpdateAuctionForm(@PathVariable int id, Model model) {
        Auction auction = auctionService.getAuctionById(id);

        Timestamp dateAndTime = auction.getDateAndTime();
        LocalDateTime localDateTime = dateAndTime.toLocalDateTime();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String auctionEnd = localDateTime.format(formatter);

        model.addAttribute("auction", auctionService.getAuctionById(id));
        model.addAttribute("auctionEnd", auctionEnd);
        //model.addAttribute("user", userService.getUserById(userId));
        return "edit-auction";
    }

    @DeleteMapping("/api/auctions/{id}")
    public List<Auction> deleteAuction(@PathVariable int id) {
        auctionService.deleteAuction(id);
        return auctionService.getAllAuctions();
    }

    @GetMapping("/api/auctions/delete/{id}")
    public String deleteAnAuction(@PathVariable int id) {
        User user = auctionService.getAuctionById(id).getSeller();

        auctionService.deleteAuction(id);
        return "redirect:/users/profile/" + user.getId();
    }


}