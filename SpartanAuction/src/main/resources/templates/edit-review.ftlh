<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Review Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">

</head>

<body>
    <#include "./include/header.ftlh">
    <main class="sign-up-main">
        <div class="sign-up-login-form">
            <div>
                <h2>Editing Review for ${auction.title}</h2>
                <a href="/reviews/delete/${review.id}"><i class="fa fa-trash"></i></a>
            </div>
            <div class="write-review-form">
                <#if auction.imagePath == "imagePath">
                    <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                    <img src="/images/no-auction-photo.jpg" alt="">
                <#else>
                    <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                    <img src="/images/${auction.imagePath}" alt="">
                </#if>
                <form action="/reviews/update/${review.id}" method="post" modelAttribute="${review}">
                    <label for="">Username: @${review.providerUser.username}</label>
                    <label for="rating">Stars:</label>
                    <input type="number" name="rating" id="rating" min="0" max="5" step="1" value="${review.rating}">
                    <label for="comment">Review:</label><br>
                    <textarea name="comment" id="comment" rows="5" cols="40" value="comment"></textarea><br>
                    <input type="text" name="reviewUser" id="reviewUser" value="${review.reviewUser.id}" class="hide">
                    <input type="text" name="providerUser" id="providerUser" value="${auction.seller.id}" class="hide">
                    <div>
                        <a class="cancel sign-log-link" href="/users/profile/${review.reviewUser.id}">Cancel Edit</a>
                        <button class="bid sign-log-button">Edit Review</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
