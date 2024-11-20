<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registering For Auction</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles/styles.css">
</head>

<body>
    <#include "/include/header.html">
    <main class="auction-register-main">
        <div class="auction-register-form">
            <h2>Register Auction</h2>
            <img src="https://placehold.co/500x500" alt="">
            <br>
            <form action="" method="post">
                <label for="name">Item Name</label>
                <br>
                <input type="text" name="name" id="name">
                <br>
                <label for="item_info">Item Info</label>
                <br>
                <textarea type="text" name="item_info" id="item_info" rows="5"></textarea>
                <br>
                <label for="starting_bid">Starting Bid</label>
                <br>
                <input type="text" name="starting_bid" id="starting_bid">
                <br>
                <div>
                    <a href="./a-bid.html" class="sign-log-link">Register</a>
                    <a href="./profile.html" class="sign-log-link">Cancel</a>
                </div>
            </form>
        </div>
    </main>
    </body>

</html>