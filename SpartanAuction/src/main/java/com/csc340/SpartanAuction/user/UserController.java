package com.csc340.SpartanAuction.user;

import com.csc340.SpartanAuction.auction.Auction;
import com.csc340.SpartanAuction.auction.AuctionService;
import com.csc340.SpartanAuction.bid.Bid;
import com.csc340.SpartanAuction.bid.BidService;
import com.csc340.SpartanAuction.reply.Reply;
import com.csc340.SpartanAuction.reply.ReplyService;
import com.csc340.SpartanAuction.review.Review;
import com.csc340.SpartanAuction.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/users/signup")
    public String showNewUserForm(Model model) {
        User user = new User();
        return "signup";
    }

    @GetMapping("/users/login")
    public String showLoginForm(Model model) {
        User user = new User();
        return "login";
    }

    @GetMapping("/users/logging")
    public String logIn(@ModelAttribute("user") User user) {
        User theUser = userService.doesUserExist(user);
        return "redirect:/users/profile/" + theUser.getId();
    }

    @GetMapping({"/users/profile/{id}", "/users/update/profile/{id}"})
    public String showProfile(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.getUserById(id));
        List<Bid> currentBids = bidService.getCurrentBidsForUser(id);
        List<Auction> currentAuctions = auctionService.getCurrentAuctionsForUser(id);
        List<Bid> pastBids = bidService.getPastBidsForUser(id);
        int currentBidsSize = currentBids.size();
        List<Review> customerReviews = reviewService.getAllReviewsForOneUser(id);
        List<Reply> replies = replyService.getAllRepliesForOneUser(id);
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
        return "profile";
    }

    @GetMapping("/users/other-profile/{id}")
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

    @DeleteMapping("/users/delete/{id}")
    public List<User> deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return userService.getAllUsers();
    }

}