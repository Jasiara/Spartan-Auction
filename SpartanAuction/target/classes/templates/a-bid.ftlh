<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>A Bid Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>

<body>
    <#include "./include/header.ftlh">
    <main class="sign-up-main">
        <div class="sign-up-login-form">
            <h2>${auction.title}</h2>
            <div class="bid-confirm-form">
                <#if auction.imagePath = "imagePath">
                    <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                    <img src="/images/no-auction-photo.jpg" alt="">
                <#else>
                    <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                    <img src="/images/${auction.imagePath}" alt="">
                </#if>
                <form action="" method="post">
                    <label>Highest Bid: $ ${auction.currentPrice}</label>
                    <label for="amount">Your Bid:</label><br>
                    <input name="amount" id="amount" type="text"><br>
                    <div>
                        <div>
                            <a class="cancel sign-log-link" href="./a-bid.html">Cancel Bid</a>
                        </div>
                        <div>
                            <button class="bid">Confirm Bid</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </main>
</body>

</html>