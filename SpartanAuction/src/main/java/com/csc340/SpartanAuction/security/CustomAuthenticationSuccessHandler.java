package com.csc340.SpartanAuction.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectURL = request.getContextPath();

        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("admin"))) {
            redirectURL = "/admin/home";
        } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("user"))) {
            redirectURL = "/users/profile";
        } else {
            redirectURL = "/public/api/auctions";
        }
        response.sendRedirect(redirectURL);

    }
}