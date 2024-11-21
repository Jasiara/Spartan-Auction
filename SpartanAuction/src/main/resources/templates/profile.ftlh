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
        <#include "./include/profile-top.ftlh">
        <div class="user-nav">
            <a id="my-auctions-tab" class="user-nav-non-highlight">My Auctions</a>
            <a id="current-bids-tab" class="user-nav-highlight">Current Bids</a>
            <a id="past-bids-tab" class="user-nav-non-highlight">Past Bids</a>
            <a id="customer-reviews-tab" class="user-nav-non-highlight">Customer Reviews</a>
        </div>
        <div class="current-and-past-bids">
            <#if currentBidAmount gt 0>
                <#assign index = 0>
                <#list currentBids as bid>
                    <a href="/api/auctions/${bid.auction.id}" class="item-link">
                        <div class="item">
                            <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                            <img src="/images/${bid.auction.imagePath}" alt="">
                            <p class="black-writing">Item Name: ${bid.auction.title}</p>
                            <p class="black-writing">Highest Bid: $ ${bid.auction.currentPrice}</p>
                            <p class="black-writing">Your Highest Bid: $ ${bid.amount}</p>
                            <p class="black-writing" id="auction-end${index}">Time Left: </p>
                            <p><span class="black-writing">User: </span><a href="/">@${bid.auction.seller.username}</a></p>
                             <#assign index = index + 1>
                        </div>
                    </a>
                </#list>
                <script type="text/javascript">
                    console.log("Hi, there");
                    var datesArr = [<#list currentBids as bid>"${bid.auction.dateAndTime}", </#list>];
                    console.log(datesArr);
                </script>
                <script src="/script/multiple-items.js" type="text/javascript"></script>
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
    <script src="/script/profile.js" type="text/javascript"></script>

</body>

</html>