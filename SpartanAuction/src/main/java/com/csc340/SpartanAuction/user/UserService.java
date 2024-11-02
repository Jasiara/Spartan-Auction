package com.csc340.SpartanAuction.user;

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


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
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

        //Technically the 4 lines above are not necessary because the save method merges by default.
        userRepository.save(existing);
    }


    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}