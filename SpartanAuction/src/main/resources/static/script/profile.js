
console.log("Can you see me 1");

let auctionsTab;
let currentBidsTab;
let pastBidsTab;
let customerReviewsTab;

console.log("Can you see me 2");

auctionsTab = document.getElementById("my-auctions-tab");
currentBidsTab = document.getElementById("current-bids-tab");
pastBidsTab = document.getElementById("past-bids-tab");
customerReviewsTab = document.getElementById("customer-reviews-tab");

console.log("Can you see me 3");


console.log(auctionsTab);
console.log(currentBidsTab);
console.log(pastBidsTab);
console.log(customerReviewsTab);

auctionsTab.addEventListener("click", function () {
    console.log("Auction");
    let classArray = document.getElementsByClassName("user-nav-highlight");
    let whiteTab = classArray[0];
    whiteTab.classList.add("user-nav-non-highlight");
    whiteTab.classList.remove("user-nav-highlight");

    auctionsTab.classList.add("user-nav-highlight");
    auctionsTab.classList.remove("user-nav-non-highlight");

    let blockArray = document.getElementsByClassName("show");
    let shownBlock = blockArray[0];
    console.log(shownBlock);

    shownBlock.classList.add("hide");
    shownBlock.classList.remove("show");

    let auctionBlock = document.getElementById("auction-block");
    auctionBlock.classList.add("show");
    auctionBlock.classList.remove("remove");
});

currentBidsTab.addEventListener("click", function () {
    console.log("Current");
    let classArray = document.getElementsByClassName("user-nav-highlight");
    let whiteTab = classArray[0];
    whiteTab.classList.add("user-nav-non-highlight");
    whiteTab.classList.remove("user-nav-highlight");

    currentBidsTab.classList.add("user-nav-highlight");
    currentBidsTab.classList.remove("user-nav-non-highlight");

    let blockArray = document.getElementsByClassName("show");
    let shownBlock = blockArray[0];
    console.log(shownBlock);

    shownBlock.classList.add("hide");
    shownBlock.classList.remove("show");

    let currentBlock = document.getElementById("current-bids-block");
    currentBlock.classList.add("show");
    currentBlock.classList.remove("remove");
});

pastBidsTab.addEventListener("click", function () {
    console.log("Past");
    let classArray = document.getElementsByClassName("user-nav-highlight");
    let whiteTab = classArray[0];
    whiteTab.classList.add("user-nav-non-highlight");
    whiteTab.classList.remove("user-nav-highlight");

    pastBidsTab.classList.add("user-nav-highlight");
    pastBidsTab.classList.remove("user-nav-non-highlight");

    let blockArray = document.getElementsByClassName("show");
    let shownBlock = blockArray[0];
    console.log(shownBlock);

    shownBlock.classList.add("hide");
    shownBlock.classList.remove("show");

    let pastBlock = document.getElementById("past-bids-block");
    pastBlock.classList.add("show");
    pastBlock.classList.remove("remove");
});

customerReviewsTab.addEventListener("click", function () {
    console.log("Review");
    let classArray = document.getElementsByClassName("user-nav-highlight");
    let whiteTab = classArray[0];
    whiteTab.classList.add("user-nav-non-highlight");
    whiteTab.classList.remove("user-nav-highlight");

    customerReviewsTab.classList.add("user-nav-highlight");
    customerReviewsTab.classList.remove("user-nav-non-highlight");
});