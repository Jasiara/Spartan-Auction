<div class="current-and-past-bids show" id="current-bids-block">
        <div class="current-and-past-bids">
        <#if currentBidAmount gt 0>
            <#assign index = 0>
                <#list currentBids as bid>
                    <a href="/api/auctions/${bid.auction.id}" class="item-link">
                        <div class="item">
                        <#if bid.auction.imagePath = "imagePath">
                            <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                            <img src="/images/no-auction-photo.jpg" alt="">
                        <#else>
                            <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                            <img src="/images/${bid.auction.imagePath}" alt="">
                        </#if>
                            <p class="black-writing">Item Name: ${bid.auction.title}</p>
                            <p class="black-writing">Highest Bid: $ ${bid.auction.currentPrice}</p>
                            <p class="black-writing">Your Highest Bid: $ ${bid.amount}</p>
                            <p class="black-writing" id="auction-end${index}">Time Left: </p>
                            <p><span class="black-writing">User: </span><a href="/users/other-profile/${bid.auction.seller.id}">@${bid.auction.seller.username}</a></p>
                            <#assign index = index + 1>
                        </div>
                    </a>
                </#list>
        <#else>
            <div class="no-current-bids-container">
                <br>
                <p class="no-current-bids"> You are currently not bidding on any items</p>
                <br>
                <p class="no-current-bids">Would you like to find some <a href="/api/auctions">items?</a></p>
                <br><br><br>
            </div>
        </#if>
    </div>
    </div>