package com.csc340.SpartanAuction.auction;

import com.csc340.SpartanAuction.bid.Bid;
import com.csc340.SpartanAuction.bid.BidService;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompleted;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompletedService;
import com.csc340.SpartanAuction.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
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
        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        if (currentlyLoggedIn) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.getUserByUsername(name);
            if (user == null) {
                currentlyLoggedIn = false;
                model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
            } else {
                model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
                model.addAttribute("smallUser", user);
            }
            return "index";
        } else {
            model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
            return "index";
        }
    }

    @GetMapping("/public/api/auctions/{id}")
    public String getAuctionById(Model model, @PathVariable int id) {
        model.addAttribute("auction", auctionService.getAuctionById(id));
        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        if (currentlyLoggedIn) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.getUserByUsername(name);
            if (user == null) {
                currentlyLoggedIn = false;
                model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
            } else {
                model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
                model.addAttribute("smallUser", user);
            }
            return "an-auction";
        } else {
            model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
            return "an-auction";
        }
    }

    @GetMapping("/public/api/auctions/stats/{id}")
    public String getAuctionStats(Model model, @PathVariable int id) {
        model.addAttribute("auction", auctionService.getAuctionById(id));
        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        if (currentlyLoggedIn) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.getUserByUsername(name);
            if (user == null) {
                currentlyLoggedIn = false;
                model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
            } else {
                model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
                model.addAttribute("smallUser", user);
            }
            return "auctions-stats";
        } else {
            model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
            return "auctions-stats";
        }
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

    @GetMapping("/public/api/auctions/search")
    public String searchForAuctions(@RequestParam(name = "searchTerm")String searchTerm, Model model) {
        List<Auction> allAuctions = auctionService.getAuctionsByName(searchTerm);
        List<Auction> auctionsByCategory = auctionService.getAuctionsByCategory(searchTerm);
        for (int i = 0; i < auctionsByCategory.size(); i++) {
            if (!allAuctions.contains(auctionsByCategory.get(i))) {
                allAuctions.add(auctionsByCategory.get(i));
            }
        }
        model.addAttribute("title", searchTerm);
        model.addAttribute("auctions", allAuctions);
        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        if (currentlyLoggedIn) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.getUserByUsername(name);
            if (user == null) {
                currentlyLoggedIn = false;
                model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
            } else {
                model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
                model.addAttribute("smallUser", user);
            }
            return "search";
        } else {
            model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
            return "search";
        }

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

        return "redirect:/api/auctions/stats/" + auction.getId();
    }

    @GetMapping("/api/auctions/new-auction/{userId}")
    public String createNewAuctionForm(Model model, @PathVariable int userId) {
        model.addAttribute("user", userService.getUserById(userId));
        Auction auction = new Auction();
        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
        if (currentlyLoggedIn) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.getUserByUsername(name);
            model.addAttribute("smallUser", user);
            return "auctioning";
        } else {
            return "auctioning";
        }
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
        return "redirect:/api/auctions/stats/" + auction.getId();
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

        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
        if (currentlyLoggedIn) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.getUserByUsername(name);
            model.addAttribute("smallUser", user);
            return "edit-auction";
        } else {
            return "edit-auction";
        }
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
        return "redirect:/users/profile";
    }


}