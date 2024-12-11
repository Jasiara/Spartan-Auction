<div class="customer-review hide" id="customer-review-block">
    <#if customerReviewsAmount gt 0>
        <#assign idNum = 0>
        <#list customerReviews as review>
            <div class="customer-review-item">
                <!--IMAGE SOURCE: https://wooj.design/collections/table-lamps-->
                <#if review.reviewUser.imagePath == 'imagePath'>
                    <i class="fa fa-user-circle"></i>
                <#else>
                    <img class="profile-img-small" src="/images/${review.reviewUser.imagePath}" alt="">
                </#if>
                <div>
                    <p>Reviewer: <a href="/public/users/other-profile/${review.reviewUser.id}">@${review.reviewUser.username}</a></p>
                    <p>Rating:</p>
                    <#assign ratingTimesTen = review.rating * 10>
                    <#assign runAmount = [1,2,3,4,5]>
                    <div class="stars">
                        <#list runAmount as currentRun>
                            <#if ratingTimesTen gte 10>
                                <i class="fa fa-star"></i>
                                <#assign ratingTimesTen = ratingTimesTen - 10>
                            <#elseif ratingTimesTen gt 0 && ratingTimesTen <= 9>
                                <i class="fa fa-star-half-empty"></i>
                                <#assign ratingTimesTen = ratingTimesTen - ratingTimesTen>
                            <#else>
                                <i class="fa fa-star-o"></i>
                            </#if>
                        </#list>
                        <#assign ratingNonDouble = review.rating * 100>
                        <#assign ratingDouble = ratingNonDouble / 100>
                        <p class="rating-number">${review.rating?string("0.0")}</p>
                    </div>
                    <p>Review:</p>
                    <p>${review.comment}</p>
                    <#if loggedIn == true>
                        <button class="reply" id="review-button${idNum}">
                            <i class="fa fa-reply"></i>
                            <p>Reply to comment</p>
                        </button>
                    </#if>
            </div>
        </div>
        <div class="customer-reply-item hide" id="reply-form-${idNum}">
            <form action="/replies/new/${review.providerUser.id}" method="post">
                <label for="reply-comment-${idNum}">Your reply:</label><br><br>
                <textarea id="reply-comment-${idNum}" name="comment" required></textarea><br>
                <input type="text" id="review-id-${idNum}" name="review" value="${review.id}" class="hide">
                <button type="submit">Submit Reply</button>
            </form>
        </div>
        <#if repliesAmount gt 0>
            <#list replies as reply>
                <#if reply.review.id == review.id>
                    <div class="customer-reply-item">

                        <!--IMAGE SOURCE: https://wooj.design/collections/table-lamps-->
                        <#if review.providerUser.imagePath == 'imagePath'>
                            <i class="fa fa-user-circle"></i>
                        <#else>
                            <img class="profile-img-small-replies" src="/images/${review.providerUser.imagePath}" alt="">
                        </#if>
                        <div>
                        <p>Replier: <a href="/public/users/other-profile/${reply.review.providerUser.id}">@${reply.review.providerUser.username}</a></p>
                        <p>Reply:</p>
                        <p>${reply.comment}</p>
                        </div>
                        <#if loggedIn == true>
                            <div class="edit-and-delete-buttons">
                                <div class="trash-reply">
                                    <form action="/replies/delete/${reply.id}" method="get">
                                        <button><i class="fa fa-trash"></i> Delete Reply</button>
                                    </form>
                                </div>
                                <div>
                                    <!--<button><i class="fa fa-pencil"></i> Edit reply</button>-->
                                </div>
                            </div>
                        </#if>
                    </div>
                </#if>
            </#list>
        </#if>
        <#assign idNum = idNum + 1>
    </#list>
    <br>
    <#else>
        <#if loggedIn == true>
            <div class="no-current-bids-container">
                <br><br><br><br>
                <p class="no-current-bids"> You currently don't have any reviews</p>
                <br><br><br><br><br><br><br><br><br><br>
            </div>
        <#else>
            <div class="no-current-bids-container">
                <br><br><br><br>
                <p class="no-current-bids"> This user doesn't have any reviews currently</p>
                <br><br><br><br><br><br><br><br><br><br>
            </div>
        </#if>
    </#if>
</div>