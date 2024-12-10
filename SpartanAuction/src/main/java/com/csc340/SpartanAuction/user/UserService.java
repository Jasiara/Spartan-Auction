package com.csc340.SpartanAuction.user;

import com.csc340.SpartanAuction.auction.Auction;
import com.csc340.SpartanAuction.auction.AuctionService;
import com.csc340.SpartanAuction.bid.Bid;
import com.csc340.SpartanAuction.bid.BidRepository;
import com.csc340.SpartanAuction.bid.BidService;
import com.csc340.SpartanAuction.review.Review;
import com.csc340.SpartanAuction.review.ReviewRepository;
import com.csc340.SpartanAuction.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService.java
 * Centralizes data access to the User Database.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BidService bidService;

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    PasswordEncoder passwordEncoder;


    public List<User> getAllUsers() {

        List<User> users = userRepository.findAll();
        for (User user: users) {
            double ratingAverage = reviewRepository.getAverageRatingForOneUser(user.getId());
            if (ratingAverage != 0) {
                user.setRatingAverage(ratingAverage);
                userRepository.save(user);
            }
        }
        return users;
    }


    public User getUserById(int id) {

        User theUser = userRepository.findById(id).orElse(null);
        double ratingAverage = reviewRepository.getAverageRatingForOneUser(id);
        if (ratingAverage != 0 ) {
            theUser.setRatingAverage(ratingAverage);
            userRepository.save(theUser);
        }
        return theUser;
    }

    public User doesUserExist(User user) {

        User theUser = userRepository.findLoginUser(user.getUsername(), user.getPassword());

        if (theUser != null) {
            return theUser;
        }
        theUser = new User();

        return theUser;
    }

    /*
    public List<User> getUsersBy____(String major) {
        return userRepository.getUsersBy______(major);
    }*/


    /*
    public List<User> get_____Users(double gpa) {
        return userRepository.get_______Users(gpa);
    }*/


    public void addNewUser(User user) {
        user.setRatingAverage(0);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void updateUser(int id, User user) {
        User existing = getUserById(id);
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());
        existing.setEmail(user.getEmail());
        existing.setName(user.getName());
        existing.setLocation(user.getLocation());
        existing.setUserType(user.getUserType());
        existing.setRatingAverage(user.getRatingAverage());
        existing.setImagePath(user.getImagePath());
        if (!existing.getPassword().equals(user.getPassword())) {
            existing.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(existing);
    }


    public void deleteUserById(int id) {
        List<Bid> bidsForOneUser = bidService.getAllBidsForUser(id);

        while (!bidsForOneUser.isEmpty()) {
            Bid deletedBid = bidsForOneUser.get(0);
            bidsForOneUser.remove(0);
            bidService.deleteBidById(deletedBid.getId());
        }

        List<Review> reviewsForOneUser = reviewService.getAllReviewsForOneUser(id);

        while (!reviewsForOneUser.isEmpty()) {
            Review deletedReview = reviewsForOneUser.get(0);
            reviewsForOneUser.remove(0);
            reviewService.deleteReviewById(deletedReview.getId());
        }

        List<Auction> auctionsForOneUser = auctionService.getAllAuctionsForUser(id);

        while (!auctionsForOneUser.isEmpty()) {
            Auction deletedAuction = auctionsForOneUser.get(0);
            auctionsForOneUser.remove(0);
            auctionService.deleteAuction(deletedAuction.getId());
        }

        userRepository.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
}