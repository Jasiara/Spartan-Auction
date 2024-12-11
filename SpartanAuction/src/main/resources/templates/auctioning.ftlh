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
            <h2>Register Auction</h2>
            <img src="/images/no-auction-photo.jpg" alt="">
            <br>
            <form action="/api/auctions/new/${user.id}" method="post">
                <label for="title">Auction Title</label>
                <br>
                <input type="text" name="title" id="title" required>
                <br>
                <label for="description">Description</label>
                <br>
                <textarea rows="5" cols="40" name="description" id="description" required></textarea>
                <br>
                <label for="startingPrice">Starting Price</label>
                <br>
                <input type="number" name="startingPrice" id="startingPrice" required>
                <br>
                <label for="imagePath">Image Path</label>
                <br>
                <input type="text" name="imagePath" id="imagePath" required>
                <br>
                <label for="auctionEnd">End of Auction</label>
                <br>
                <input type="datetime-local" name="auctionEnd" id="auctionEnd" required>
                <br>
                <label for="category">Category</label>
                <br>
                <input type="text" name="category" id="category">
                <div>
                    <button type="submit" class="sign-log-button">Register</button>
                    <a href="/users/profile/${user.id}" class="sign-log-link">Cancel</a>
                </div>
            </form>
        </div>
    </main>
    </body>

</html>