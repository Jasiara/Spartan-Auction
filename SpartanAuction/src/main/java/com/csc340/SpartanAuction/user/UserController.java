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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

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


    @PostMapping("/users/new")
    public String addNewUser(@ModelAttribute("user") User user) {
        user.setUserType("user");
        user.setLocation(" ");
        user.setImagePath("imagePath");
        userService.addNewUser(user);
        return "redirect:/users/profile/" + user.getId();
    }

    @GetMapping("/public/users/signup")
    public String showNewUserForm(Model model) {
        User user = new User();
        return "signup";
    }

    @GetMapping("/public/users/login")
    public String showLoginForm(Model model) {
        User user = new User();
        return "login";
    }

    @PostMapping("/users/logging")
    public String logIn(@ModelAttribute("user") User user) {
        User theUser = userService.doesUserExist(user);

        if (theUser != null) {
            return "redirect:/users/profile/";
        } else {
            return "error";
        }
    }

    @GetMapping({"/users/profile/", "/users/update/profile/{id}"})
    public String showProfile(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUsername(name).getId();
        model.addAttribute("user", userService.getUserById(id));
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
        List<Review> customerReviews = reviewService.getAllReviewsForOneUser(id);
        List<Reply> replies = replyService.getAllRepliesForOneUser(id);
        model.addAttribute("currentAuctions", currentAuctions);
        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("currentAuctionAmount", currentAuctionsSize);
        model.addAttribute("customerReviews", customerReviews);
        model.addAttribute("customerReviewsAmount", customerReviews.size());
        model.addAttribute("replies", replies);
        model.addAttribute("repliesAmount", replies.size());
        return "other-profile";
    }

    @PostMapping("/users/update/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user) {



        //userService.deleteUserById(id);
        userService.updateUser(id, user);

        return "redirect:/users/profile/" + user.getId();
    }

    @GetMapping("/users/update/{id}")
    public String showUpdateUserForm(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update-user";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/users/login";
    }

}