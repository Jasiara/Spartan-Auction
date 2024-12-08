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

    @PostMapping("/update/{id}")
    public String updateReview(@PathVariable int id, @ModelAttribute("review") Review review) {
        reviewService.updateReview(id, review);

        User user = reviewService.getReviewById(id).getReviewUser();
        return "redirect:/users/profile/" + user.getId();
    }

    @GetMapping("/update-review/{reviewId}/auction/{auctionId}")
    public String updateReviewForm(@PathVariable int reviewId, @PathVariable int auctionId, Model model) {
        Review review = reviewService.getReviewById(reviewId);

        model.addAttribute("review", review);
        model.addAttribute("auction", auctionService.getAuctionById(auctionId));
        return "edit-review";
    }


    @GetMapping("/delete/{id}")
    public String deleteReviewById(@PathVariable int id) {
        User user = reviewService.getReviewById(id).getReviewUser();

        reviewService.deleteReviewById(id);
        return "redirect:/users/profile/" + user.getId();
    }
}
