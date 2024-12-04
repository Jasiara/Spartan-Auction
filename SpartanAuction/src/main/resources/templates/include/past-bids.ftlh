<div class="current-and-past-bids hide" id="past-bids-block">
    <#if currentBidAmount gt 0>
        <#assign index = 0>
            <#list pastBids as bid>
                <a href="/api/auctions/${bid.auction.id}" class="item-link">
                    <div class="item">
                        <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                        <img src="/images/${bid.auction.imagePath}" alt="">
                        <p class="black-writing">Item Name: ${bid.auction.title}</p>
                        <p class="black-writing">Highest Bid: $ ${bid.auction.currentPrice}</p>
                        <p><span class="black-writing">User: </span><a href="/users/other-profile/${bid.auction.seller.id}">@${bid.auction.seller.username}</a></p>
                        <a href="./write-review.html" class="navy-button">Write A Review</a>
                        <#assign index = index + 1>
                    </div>
                </a>
            </#list>
    <#else>
        <div class="no-current-bids-container">
            <br>
            <p class="no-current-bids"> You currently haven't won any bids</p>
            <br><br><br><br>
        </div>
    </#if>
</div>