package com.csc340.SpartanAuction.user;

import com.csc340.SpartanAuction.rating.RatingRepository;
import com.csc340.SpartanAuction.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RatingRepository ratingRepository;

    @Autowired
    private ReviewRepository reviewRepository;


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
        
        userRepository.save(existing);
    }


    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}