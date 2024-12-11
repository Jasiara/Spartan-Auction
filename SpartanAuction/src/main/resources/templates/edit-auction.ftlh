<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registering For Auction</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>

<body>
    <#include "/include/header.ftlh">
    <main class="sign-up-login">
        <div class="sign-up-login-form">
            <div>
                <h2>Edit Auction</h2>
                <a href="/api/auctions/delete/${auction.id}"><i class="fa fa-trash"></i></a>
            </div>
            <#if auction.imagePath == "imagePath">
                <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                <img src="/images/no-auction-photo.jpg" alt="">
            <#else>
                <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                <img src="/images/${auction.imagePath}" alt="">
            </#if>
            <br>
            <form action="/api/auctions/update-auction/${auction.id}" method="post" modelAttribute="${auction}">
                <label>Highest Bid: $ ${auction.currentPrice}</label>
                <label for="title">Auction Title</label>
                <br>
                <input type="text" name="title" id="title" value="${auction.title}">
                <br>
                <label for="description">Description</label>
                <br>
                <textarea rows="5" cols="40" type="text" name="description" id="description">${auction.description}</textarea>
                <br>
                <label for="imagePath">Image Path</label>
                <br>
                <input type="text" name="imagePath" id="imagePath" value="${auction.imagePath}">
                <br>
                <label for="auctionEnd">Auction End</label>
                <br>
                <input type="datetime-local" name="auctionEnd" id="auctionEnd" value="${auctionEnd}">
                <br>
                <label for="category">Category</label>
                <br>
                <input type="text" name="category" id="category" value="${auction.category}">
                <input type="text" name="seller" value=${auction.seller.id} class="hide">
                <input type="text" name="auctionStatus" value=${auction.auctionStatus} class="hide">
                <input type="text" name="currentPrice" value=${auction.currentPrice} class="hide">
                <input type="text" name="startingPrice" value=${auction.startingPrice} class="hide">
                <div>
                    <div>
                        <button type="submit" class="sign-log-button">Update Auction</button>
                    </div>
                    <div>
                        <a href="/users/profile" class="sign-log-link">Cancel</a>
                    </div>
                </div>
            </form>
        </div>
    </main>
    </body>

</html>