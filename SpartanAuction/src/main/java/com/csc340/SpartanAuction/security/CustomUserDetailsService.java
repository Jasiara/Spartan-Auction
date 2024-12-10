package com.csc340.SpartanAuction.security;

import com.csc340.SpartanAuction.user.User;
import com.csc340.SpartanAuction.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);

        ArrayList<SimpleGrantedAuthority> authList = new ArrayList<>();

        authList.add(new SimpleGrantedAuthority(user.getUserType()));


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authList);
    }
}
