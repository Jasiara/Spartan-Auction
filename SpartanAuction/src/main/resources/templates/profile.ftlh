<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">

</head>

<body>
    <#include "./include/header.ftlh">
    <main>
        <#include "./include/profile-top.ftlh">
        <#include "./include/user-nav(my_auctions).ftlh">
        <#include "./include/my_auctions.ftlh">
        <#include "./include/current-bids.ftlh">
        <#include "./include/customer-reviews.ftlh">
        <#include "./include/past-bids.ftlh">
    </main>
    <script type="text/javascript">
        var datesArr = [<#list currentBids as bid>"${bid.auction.dateAndTime}", </#list>];
    </script>
    <script src="/script/multiple-items.js" type="text/javascript"></script>
    <script>
        console.log("Hi, me");
    </script>
    <script>
        console.log("Here");

        let idsArray = document.querySelectorAll('*[id]');

        let repliesArray = [];
        for (let index = 0; index < idsArray.length; index++) {
            if (idsArray[index].id.startsWith("review-button")) {
                repliesArray.push(idsArray[index]);
            }
        }


        console.log("Here Now 1");
        console.log(repliesArray);
        for (let index = 0; index < repliesArray.length; index++) {
            repliesArray[index].addEventListener('click', () => {
                let replyForm = document.getElementById("reply-form-" + index );
                replyForm.classList.add("show");
                replyForm.classList.remove("hide");
            });
        }

        console.log("Here Now 2");
        </script>
    <script src="/script/profile.js" type="text/javascript"></script>

</body>

</html>