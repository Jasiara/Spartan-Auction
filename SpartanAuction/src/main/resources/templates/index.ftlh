<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">

</head>
<body>
    <#include "./include/header.ftlh">
    <main>
        <div class="items-view">
        <#assign index = 0>
            <#list auctions as item>
            <a href="/api/auctions/${item.id}" class="item-link">
                <div class="item">
                    <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                    <img src="/images/${item.imagePath}" alt="">
                    <p class="black-writing">Item Name: ${item.title}</p>
                    <p class="black-writing">Highest Bid: $ ${item.currentPrice}</p>
                    <p class="black-writing" id="auction-end${index}">Time Left: </p>
                    <p><span class="black-writing">User: </span><a href="/users/other-profile/${item.seller.id}">@${item.seller.username}</a></p>
                    <#assign index = index + 1>
                </div>
            </a>
            </#list>
        </div>
    </main>
    <script type="text/javascript">
        var datesArr = [<#list auctions as item>"${item.dateAndTime}", </#list>];
        console.log(datesArr);

    </script>
    <script src="/script/multiple-items.js" type="text/javascript"></script>

</body>

</html>