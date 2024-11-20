<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>

<body>
    <#include "./include/header.ftlh">
    <main>
        <div class="profile-top">
            <div class="profile-img">
                <!--IMAGE SOURCE:  https://www.pinterest.com/pin/712905816020483535/-->
                <img class="profile-img" src="/images/${user.imagePath}" alt="">
            </div>
            <div class="profile-desc">
                <p>Name: ${user.name}</p>
                <p>Username: ${user.username}</p>
                <p>Location: ${user.location}</p>
                <div class="rating">
                    <#if user.ratingAverage != 0>
                    <p>Rating:</p>
                    <#assign ratingTimesTen = user.ratingAverage * 10>
                    <#assign runAmount = [1,2,3,4,5]>
                    <div class="stars">
                        <#list runAmount as currentRun>
                            <#if ratingTimesTen gte 10>
                                <i class="fa fa-star"></i>
                                <#assign ratingTimesTen = ratingTimesTen - 10>
                            <#elseif ratingTimesTen gt 0 && ratingTimesTen <= 9>
                                <i class="fa fa-star-half-empty"></i>
                                <#assign ratingTimesTen = ratingTimesTen - ratingTimesTen>
                            <#else>
                                <i class="fa fa-star-o"></i>
                            </#if>
                        </#list>
                        <p class="rating-number">${user.ratingAverage}</p>
                    </div>
                    <#else>
                        <p class="no-rating">No Rating</p>
                    </#if>
                </div>
            </div>
                <a href="/users/update/${user.id}"><i class="fa fa-gear" style="font-size: 500%;"></i></a>

        </div>
        <div class="user-nav">
            <a href="./my_auctions.html" class="user-nav-non-highlight">My Auctions</a>
            <a href="./profile.html" class="user-nav-highlight">Current Bids</a>
            <a href="./past-bids.html" class="user-nav-non-highlight">Past Bids</a>
            <a href="./customer_reviews.html" class="user-nav-non-highlight">Customer Reviews</a>
        </div>
        <div class="current-and-past-bids">
            <#if currentBidAmount gt 0>
                <#list bids as bid>
                    <a href="/api/auctions/${bid.auction.id}" class="item-link">
                        <div class="item">
                            <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                            <img src="/images/${bid.auction.imagePath}" alt="">
                            <p class="black-writing">Item Name: ${bid.auction.title}</p>
                            <p class="black-writing">Highest Bid: $ ${bid.auction.currentPrice}</p>
                            <p class="black-writing" id="auction-end${index}">Time Left: </p>
                            <p><span class="black-writing">User: </span><a href="/">@${bid.auction.seller.username}</a></p>
                             <#assign index = index + 1>
                        </div>
                    </a>
                </#list>
            <#else>
                <div class="no-current-bids-container">
                    <br>
                    <p class="no-current-bids"> You are currently not bidding on any items</p>
                    <br>
                    <p class="no-current-bids">Would you like to find some <a href="/api/auctions">items?</a></p>
                    <br><br><br>
                </div>
            </#if>
        </div>
    </main>
</body>

</html>