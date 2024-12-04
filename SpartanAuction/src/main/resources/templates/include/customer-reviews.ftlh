<div class="customer-review hide" id="customer-review-block">
    <#list customerReviews as review>
    <div class="customer-review-item">
        <!--IMAGE SOURCE: https://wooj.design/collections/table-lamps-->
        <img class="profile-img-small" src="/images/${review.reviewUser.imagePath}" alt="">
        <div>
            <p>Reviewer: <a href="/users/other-profile/${review.reviewUser.id}">@${review.reviewUser.username}</a></p>
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
            <p>${review.review}</p>
        </div>
    </div>
    </#list>
</div>