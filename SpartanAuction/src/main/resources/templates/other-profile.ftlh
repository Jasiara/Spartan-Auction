<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Other Profile User Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>

<body>
    <#include "/include/header.ftlh">
    <main>
        <#include "/include/profile-parts/profile-top.ftlh">
        <#include "/include/profile-parts/other-user-nav(current_auctions).ftlh">
        <div class="current-and-past-bids">
          <#list currentAuctions as item>
          <a href="./a-bid.html" class="item-link">
            <div class="item">
              <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
              <img src="/images/${item.imagePath}" alt="">
              <p class="black-writing">Item Name: ${item.title}</p>
              <p class="black-writing">Highest Bid: $ ${item.currentPrice}</p>
              <p class="black-writing">Time Left: ${item.dateAndTime}</p>
              <!--<p><span class="black-writing">User: </span><a href="/users/other-profile/${item.seller.id}">@${item.seller.username}</a></p>-->
            </div>
          </a>
          </#list>
        </div>
      </main>
        <script src="/script/profile.js" type="text/javascript"></script>
    </body>

</html>