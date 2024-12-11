package com.csc340.SpartanAuction.admin;

import com.csc340.SpartanAuction.user.User;
import com.csc340.SpartanAuction.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import com.csc340.SpartanAuction.auction.Auction;
import com.csc340.SpartanAuction.auction.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService UserService;

    @Autowired
    private AuctionService AuctionService;


    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "admin-login";  // Make sure this points to the correct view (admin-login.html)
    }

    @PostMapping("/admin/validate")
    public String validateAdmin(@RequestParam String username, @RequestParam String password, Model model) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            return "redirect:/admin/home";  // Redirect to the admin home page
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "admin-login";  // Return to the admin login page with an error message
        }
    }

    @GetMapping("/admin/home")
    public String adminHomePage() {
        return "admin-home";  // Admin home page
    }
    // Route to manage users
    @GetMapping("/admin/users")
    public String manageUsers(Model model) {
        // Fetch all users (use UserService to interact with UserRepository)
        List<User> users = UserService.getAllUsers();
        model.addAttribute("users", users);
        return "admin-manage-users";  // Render admin-manage-users.html
    }

    // Route to manage auctions
    @GetMapping("/admin/auctions")
    public String manageAuctions(Model model) {
        // Fetch all auctions (use AuctionService to interact with AuctionRepository)
        List<Auction> auctions = AuctionService.getAllAuctions();
        model.addAttribute("auctions", auctions);
        return "admin-manage-auctions";
    }

    // Delete User
    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        UserService.deleteUserById(id);  // Deletes the user
        return "redirect:/admin/users"; // Redirects back to the user management page
    }
//IFFY
    // Edit User (Get User Info for Editing)
    @GetMapping("/admin/users/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        User user = UserService.getUserById(id);  // Fetch user by ID
        model.addAttribute("user", user);
        return "admin-edit-user";  // Render a page for editing the user
    }

    // Delete Auction
    @GetMapping("/admin/auctions/delete/{id}")
    public String deleteAuction(@PathVariable int id) {
        try {
            AuctionService.deleteAuction(id);  // Delete the auction by ID
            return "redirect:/admin/auctions";  // Redirect back to the auction management page
        } catch (Exception e) {
            e.printStackTrace();  // Log any issues
            return "error";  // Return to a fallback error view
        }
    }

    // Edit Auction (Get Auction Info for Editing)
    @GetMapping("/admin/auctions/edit/{id}")
    public String editAuction(@PathVariable int id, Model model) {
        Auction auction = AuctionService.getAuctionById(id);  // Fetch auction by ID
        model.addAttribute("auction", auction);
        return "admin-edit-auction";  // Render a page for editing the auction
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session to log the user out
        session.invalidate();
        // Redirect to the login page
        return "redirect:/users/login";
    }

    @PostMapping("/admin/users/edit/{id}")
    public String saveEditedUser(@PathVariable int id, @ModelAttribute("user") User user) {
        try {
            UserService.updateUser(id, user); // Update the user
            return "redirect:/admin/users";  // Redirect to the user management page
        } catch (Exception e) {
            e.printStackTrace(); // Log any issues
            return "error"; // Return a fallback error view
        }
    }
    // Route to save edited auction (POST)
    @PostMapping("/admin/auctions/edit/{id}")
    public String saveEditedAuction(@PathVariable int id, @ModelAttribute Auction auctionDetails) {
        try {
            Auction updatedAuction = AuctionService.updateAuction(id, auctionDetails);  // Update auction details
            return "redirect:/admin/auctions";  // Redirect to the auction management page
        } catch (Exception e) {
            e.printStackTrace();  // Log any issues
            return "error";  // Return to a fallback error view
        }
    }

}


