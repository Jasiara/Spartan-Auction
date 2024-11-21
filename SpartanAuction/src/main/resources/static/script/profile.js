"use strict";


let auctionsTab = document.getElementById("my-auctions-tab");

let currentBidsTab = document.getElementById("current-bids-tab");

let pastBidsTab = document.getElementById("past-bids-tab");

let customerReviewsTab = document.getElementById("customer-reviews-tab");

auctionsTab.addEventListener("click", function () {

    let classArray = document.getElementsByClassName("user-nav-highlight");
    let whiteTab = classArray[0];
    whiteTab.classList.add("user-nav-non-highlight");
    whiteTab.classList.remove("user-nav-highlight");
    
    auctionsTab.classList.add("user-nav-highlight");
    auctionsTab.classList.remove("user-nav-non-highlight");
});

currentBidsTab.addEventListener("click", function () {

    let classArray = document.getElementsByClassName("user-nav-highlight");
    let whiteTab = classArray[0];
    whiteTab.classList.add("user-nav-non-highlight");
    whiteTab.classList.remove("user-nav-highlight");
    
    currentBidsTab.classList.add("user-nav-highlight");
    currentBidsTab.classList.remove("user-nav-non-highlight");
});

pastBidsTab.addEventListener("click", function () {

    let classArray = document.getElementsByClassName("user-nav-highlight");
    let whiteTab = classArray[0];
    whiteTab.classList.add("user-nav-non-highlight");
    whiteTab.classList.remove("user-nav-highlight");
    
    pastBidsTab.classList.add("user-nav-highlight");
    pastBidsTab.classList.remove("user-nav-non-highlight");
});

customerReviewsTab.addEventListener("click", function () {

    let classArray = document.getElementsByClassName("user-nav-highlight");
    let whiteTab = classArray[0];
    whiteTab.classList.add("user-nav-non-highlight");
    whiteTab.classList.remove("user-nav-highlight");
    
    customerReviewsTab.classList.add("user-nav-highlight");
    customerReviewsTab.classList.remove("user-nav-non-highlight");
});