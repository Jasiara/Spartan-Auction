<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>

<body>
    <#include "./include/header.ftlh">
    <main>
        <h2 class="search-heading">${title}</h2>
        <div class="items-view">
            <#assign index = 0>
            <#list auctions as auction>
                <a href="/public/api/auctions/${auction.id}" class="item-link">
                    <div class="item">
                        <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                            <#if auction.imagePath == "imagePath">
                                <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                                <img src="/images/no-auction-photo.jpg" alt="">
                            <#else>
                                <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                                <img src="/images/${auction.imagePath}" alt="">
                            </#if>
                        <p class="black-writing">Item Name: ${auction.title}</p>
                        <p class="black-writing">Highest Bid: $ ${auction.currentPrice}</p>
                        <p class="black-writing" id="auction-end${index}">Time Left: ${auction.dateAndTime}</p>
                        <p><span class="black-writing">User: </span><a href="/public/users/other-profile/${auction.seller.id}">@${auction.seller.username}</a></p>
                        <#assign index = index + 1>
                    </div>
                </a>
            </#list>
        </div>
    </main>
    <script type="text/javascript">
        var datesArr = [<#list auctions as auction>"${auction.dateAndTime}", </#list>];
        console.log(datesArr);

    </script>
    <script src="/script/multiple-items.js" type="text/javascript"></script>
</body>

</html>