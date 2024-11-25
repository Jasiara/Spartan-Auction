<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Auctions</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles/styles.css">
</head>

<body>
    <#include "/include/header.html">
    <main>
        <div class="profile-top">
          <div class="profile-img">
            <!--IMAGE SOURCE:  https://www.pinterest.com/pin/712905816020483535/-->
            <img class="profile-img" src="/images/" alt="">
          </div>
          <div class="profile-desc">
            <p class="black-writing">Name: ${profile-desc.user.name}</p>
            <p class="black-writing">Username: ${profile-desc.user.userName}</p>
            <p class="black-writing">Location: ${profile-desc.user.location}</p>
            <div class="rating">
              <p>Rating:</p>
              <div class="stars">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-half-empty"></i>
                <i class="fa fa-star-o"></i>
              </div>
            </div>
          </div>
        </div>
        <#include "/include/user_nav(my_auctions).html">
        <div class="my_auctions">
          <#list auctions as item>
          <a href="./a-bid.html" class="item-link">
            <div class="item">
              <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
              <img src="./images/${item.imagePath}" alt="">
              <p class="black-writing">Item Name: ${item.name}</p>
              <p class="black-writing">Highest Bid: $ ${item.highesBid}</p>
              <!--Not correct, need to figure it out-->
              <p class="black-writing">Time Left: ${item.dateAndTime}</p>
              <p><span class="black-writing">User: </span><a href="./profile.html">@${item.user.userName}</a></p>
            </div>
          </a>
          </#list>
          <a href="./auctioning.html" class="item-link">
            <div class="item">
              <i class="fa fa-plus"></i>
              <p><span class="black-writing"></span><a href="./auctioning.html">Register New Auction</a></p>
            </div>
          </a>
        </div>
      </main>
    </body>

</html>