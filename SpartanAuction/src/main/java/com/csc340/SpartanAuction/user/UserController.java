package com.csc340.SpartanAuction.user;

import com.csc340.SpartanAuction.auction.Auction;
import com.csc340.SpartanAuction.auction.AuctionService;
import com.csc340.SpartanAuction.bid.Bid;
import com.csc340.SpartanAuction.bid.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

/**
 * UserController.java.
 * Includes all REST API endpoint mappings for the Student object.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private BidService bidService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
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


    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("user") User user) {
        user.setUserType("user");
        user.setLocation(" ");
        user.setImagePath("imagePath");
        userService.addNewUser(user);
        return "redirect:profile/" + user.getId();
    }

    @GetMapping("/signup")
    public String showNewUserForm(Model model) {
        User user = new User();
        return "signup";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User user = new User();
        return "login";
    }

    @GetMapping("/logging")
    public String logIn(@ModelAttribute("user") User user) {
        User theUser = userService.doesUserExist(user);
        return "redirect:profile/" + theUser.getId();
    }

    @GetMapping({"/profile/{id}", "/update/profile/{id}"})
    public String showProfile(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.getUserById(id));
        List<Bid> currentBids = bidService.getCurrentBidsForUser(id);
        int currentBidsSize = currentBids.size();
        model.addAttribute("currentBids", currentBids);
        model.addAttribute("currentBidAmount", currentBidsSize);
        return "profile";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user) {

        if (user.getUserType() == null) {
            user.setUserType("user");
        }
        //userService.deleteUserById(id);
        userService.updateUser(id, user);

        return "redirect:profile/" + user.getId();
    }

    @GetMapping("/update/{id}")
    public String showUpdateUserForm(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update-user";
    }

    @DeleteMapping("/delete/{id}")
    public List<User> deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return userService.getAllUsers();
    }

}