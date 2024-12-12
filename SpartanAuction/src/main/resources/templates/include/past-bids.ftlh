<div class="current-and-past-bids hide" id="past-bids-block">
    <div class="items-view">
    <#if pastBidsAmount gt 0>
        <#assign index = 0>
            <#list pastBids as bid>
                <a href="/public/api/auctions/${bid.auction.id}" class="item-link">
                    <div class="item">
                        <#if bid.auction.imagePath == "imagePath">
                            <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                            <img src="/images/no-auction-photo.jpg" alt="">
                        <#else>
                            <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                            <img src="/images/${bid.auction.imagePath}" alt="">
                        </#if>
                        <p class="black-writing">Item Name: ${bid.auction.title}</p>
                        <p class="black-writing">Highest Bid: $ ${bid.auction.currentPrice}</p>
                        <p><span class="black-writing">User: </span><a href="/public/users/other-profile/${bid.auction.seller.id}">@${bid.auction.seller.username}</a></p>
                        <#if reviewsCompletedAmount gt 0>
                            <#assign reviewsCompletedCount = reviewsCompletedAmount>
                            <#list reviewsCompleted as reviewCompleted>
                                <#if reviewsCompletedCount gt 0>
                                    <#if reviewCompleted.auction.id == bid.auction.id && reviewCompleted.reviewCompleted == true>
                                        <a href="/reviews/update-review/${reviewCompleted.review.id}/auction/${bid.auction.id}" class="navy-button-2">Edit Review</a>
                                        <#assign reviewsCompletedCount = reviewsCompletedCount - 1>
                                    <#else>
                                        <a href="/reviews/write-review/user/${user.id}/auction/${bid.auction.id}" class="navy-button-2">Write A Review</a>
                                    </#if>
                                <#else>
                                    <a href="/reviews/write-review/user/${user.id}/auction/${bid.auction.id}" class="navy-button-2">Write A Review</a>
                                </#if>
                            </#list>
                        <#else>
                            <a href="/reviews/write-review/user/${user.id}/auction/${bid.auction.id}" class="navy-button-2">Write A Review</a>
                        </#if>
                        <#assign index = index + 1>
                    </div>
                </a>
            </#list>
    </div>
    <#else>
        <div class="no-current-bids-container">
            <br><br><br>
            <p class="no-current-bids"> You currently haven't won any auctions</p>
            <br><br><br><br><br><br><br><br><br><br>
        </div>
    </#if>
</div>