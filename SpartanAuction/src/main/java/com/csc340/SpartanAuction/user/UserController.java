package com.csc340.SpartanAuction.user;

import com.csc340.SpartanAuction.auction.Auction;
import com.csc340.SpartanAuction.auction.AuctionService;
import com.csc340.SpartanAuction.bid.Bid;
import com.csc340.SpartanAuction.bid.BidService;
import com.csc340.SpartanAuction.reply.Reply;
import com.csc340.SpartanAuction.reply.ReplyService;
import com.csc340.SpartanAuction.review.Review;
import com.csc340.SpartanAuction.review.ReviewService;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompleted;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompletedService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UserController.java.
 * Includes all REST API endpoint mappings for the User object.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private BidService bidService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ReviewCompletedService reviewCompletedService;

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    /*@GetMapping("")
    public List<User> getUsersBy______(@RequestParam(name = "major", defaultValue = "csc") String major) {
        return userService.getUsersBy_____(major);
    }*/


    /*@GetMapping("/honors")
    public List<User> get_____Users(@RequestParam(name = "gpa", defaultValue = "3.0") double gpa) {
        return userService.get____Users(gpa);
    }*/


    @PostMapping("/signup")
    public String addNewUser(@ModelAttribute("user") User user) {
        user.setUserType("user");
        //user.setLocation(" ");
        user.setImagePath("imagePath");
        String ip = "";
        String location = "";
        //Third party APIs used to get location of user when they sign-up
        try {
            String url = "https://api.ipify.org?format=json";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            ip = root.get("ip").asText();


            //The response from the above API is a JSON Array, which we loop through.
            /*for (JsonNode rt : root) {
                //Extract relevant info from the response and use it for what you want, in this case build a Brewery object
                String quote = rt.get("quote").asText();
                String author = rt.get("author").asText();

                Quote quote1 = new Quote(quote, author);
                quoteList.add(quote1);
            }*/
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        try {
            String url = "http://ip-api.com/json/"+ip;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            location = root.get("city").asText();
            location = location + ", " +root.get("region").asText();

            //The response from the above API is a JSON Array, which we loop through.
            /*for (JsonNode rt : root) {
                //Extract relevant info from the response and use it for what you want, in this case build a Brewery object
                String quote = rt.get("quote").asText();
                String author = rt.get("author").asText();

                Quote quote1 = new Quote(quote, author);
                quoteList.add(quote1);
            }*/
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        user.setLocation(location);
        userService.addNewUser(user);
        return "redirect:/users/profile";
    }

    @GetMapping("/signup")
    public String showNewUserForm(Model model) {
        boolean currentlyLoggedIn = false;
        model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
        User user = new User();
        return "signup";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        boolean currentlyLoggedIn = false;
        model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
        User user = new User();
        return "login";
    }

    @PostMapping("/users/logging")
    public String logIn(@ModelAttribute("user") User user) {
        User theUser = userService.doesUserExist(user);

        if (theUser != null) {
            return "redirect:/users/profile";
        } else {
            return "error";
        }
    }

    @GetMapping({"/users/profile", "/users/update/profile/{id}"})
    public String showProfile(Model model /*@PathVariable int id*/) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
        int id = userService.getUserByUsername(name).getId();
        System.out.println(id);
        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("smallUser", userService.getUserById(id));
        List<Bid> currentBids = bidService.getCurrentBidsForUser(id);
        List<Auction> currentAuctions = auctionService.getAllAuctionsForUser(id);
        List<Bid> pastBids = bidService.getPastBidsForUser(id);
        int currentBidsSize = currentBids.size();
        List<Review> customerReviews = reviewService.getAllReviewsForOneUser(id);
        List<Reply> replies = replyService.getAllRepliesForOneUser(id);
        List<ReviewCompleted> reviewsCompleted = reviewCompletedService.getAllReviewsCompletedForOneUser(id);
        boolean loggedIn = true;
        model.addAttribute("currentBids", currentBids);
        model.addAttribute("currentBidAmount", currentBidsSize);
        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("auctions", currentAuctions);
        model.addAttribute("pastBids", pastBids);
        model.addAttribute("pastBidsAmount", pastBids.size());
        model.addAttribute("customerReviews", customerReviews);
        model.addAttribute("replies", replies);
        model.addAttribute("repliesAmount", replies.size());
        model.addAttribute("customerReviewsAmount", customerReviews.size());
        model.addAttribute("reviewsCompleted", reviewsCompleted);
        model.addAttribute("reviewsCompletedAmount", reviewsCompleted.size());
        return "profile";
    }

    @GetMapping("/public/users/other-profile/{id}")
    public String showOthersProfile(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.getUserById(id));
        List<Auction> currentAuctions = auctionService.getCurrentAuctionsForUser(id);
        int currentAuctionsSize = currentAuctions.size();
        boolean loggedIn = false;
        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        List<Review> customerReviews = reviewService.getAllReviewsForOneUser(id);
        List<Reply> replies = replyService.getAllRepliesForOneUser(id);
        model.addAttribute("currentAuctions", currentAuctions);
        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("currentAuctionAmount", currentAuctionsSize);
        model.addAttribute("customerReviews", customerReviews);
        model.addAttribute("customerReviewsAmount", customerReviews.size());
        model.addAttribute("replies", replies);
        model.addAttribute("repliesAmount", replies.size());
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
            return "other-profile";
        } else {
            model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
            return "other-profile";
        }
    }

    @PostMapping("/users/update/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user) {



        //userService.deleteUserById(id);
        userService.updateUser(id, user);

        return "redirect:/users/profile";
    }

    @GetMapping("/users/update/{id}")
    public String showUpdateUserForm(@PathVariable int id, Model model) {
        boolean currentlyLoggedIn = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        model.addAttribute("currentlyLoggedIn", currentlyLoggedIn);
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("smallUser", userService.getUserById(id));
        return "update-user";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/login";
    }

}