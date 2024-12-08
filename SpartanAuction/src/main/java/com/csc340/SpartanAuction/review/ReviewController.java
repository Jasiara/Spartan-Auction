package com.csc340.SpartanAuction.review;

import com.csc340.SpartanAuction.auction.AuctionService;
import com.csc340.SpartanAuction.user.User;
import com.csc340.SpartanAuction.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuctionService auctionService;

    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/user/{userId}")
    public List<Review> getAllReviewsForOneUser(@PathVariable int userId) {
        return reviewService.getAllReviewsForOneUser(userId);
    }

    @GetMapping("/{id}")
    public Review getOneReview(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }


    @PostMapping("/new/auction/{auctionId}")
    public String addNewReview(@ModelAttribute("review") Review review, @PathVariable int auctionId) {
        //System.out.println(review.toString());
        review.toString();
        reviewService.addNewReview(review, auctionId);

        return "redirect:/users/profile/" + review.getReviewUser().getId();
    }

    @GetMapping("/write-review/user/{userId}/auction/{auctionId}")
    public String writeReviewForm(Model model, @PathVariable int userId, @PathVariable int auctionId) {
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("auction", auctionService.getAuctionById(auctionId));
        return "write-review";
    }

    @PutMapping("/update/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review review) {
        reviewService.updateReview(id, review);
        return reviewService.getReviewById(id);
    }


    @DeleteMapping("/delete/{id}")
    public List<Review> deleteReviewById(@PathVariable int id) {
        reviewService.deleteReviewById(id);
        return reviewService.getAllReviews();
    }
}
