<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles/styles.css">
</head>

<body>
    <#include "/include/header.html">
    <main>
        <h2 class="search-heading">${title}</h2>
        <div class="items-view">
            <#list itemList as item>
            <a href="./item/${item.id}" class="item-link">
                <div class="item">
                    <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                    <img src="./images/${item.imagePath}" alt="">
                    <p class="black-writing">Item Name: ${item.name}</p>
                    <p class="black-writing">Highest Bid: $ ${item.highesBid}</p>
                    <!--Not correct, need to figure it out-->
                    <p class="black-writing">Time Left: ${item.dateAndTime}</p>
                    <p><span class="black-writing">User: </span><a href="./other-profile.html">@${item.user.userName}</a></p>
                </div>
            </a>
            </#list>
        </div>
    </main>
</body>

</html>