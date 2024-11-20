<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>An Auction Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>

<body>
    <#include "./include/header.ftlh">
    <main>
        <div class="a-bid">
            <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
            <img src="/images/${auction.imagePath}" alt="">
            <div>
                <p>Item Name: ${auction.title}</p>
                <p id="auction-end">Time Left: ${auction.dateAndTime}</p>
                <p>Description: ${auction.description}</p>
                <p>Current Highest Bid: $ ${auction.currentPrice}</p>
                <p>Seller: <a href="./other-profile.html">@${auction.seller.username}</a></p>
                <div>
                    <a href="./bid-confirm.html" class="link-button-small">Place A Bid</a>
                </div>
            </div>
        </div>
    </main>
</body>
<script>
    'use strict';
    let targetTime = new Date("${auction.dateAndTime}").getTime();

    function updateCountdown() {
        let now = new Date();

        let timeLeft = targetTime - now;

        if (timeLeft < 0) {
            console.log(`auction-end`);
            document.getElementById(`auction-end`).innerHTML = "Auction Over!";
            return;
        }

        let days = Math.floor((timeLeft / (1000 * 60 * 60 * 24)));
        let hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        let minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
        let seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);

        document.getElementById('auction-end').innerHTML = "Time Left: " + days + ' D ' + hours + ' H '
            + minutes + " M " + seconds +' S';


    }
    setInterval(updateCountdown, 1000);
    updateCountdown();
</script>
</html>