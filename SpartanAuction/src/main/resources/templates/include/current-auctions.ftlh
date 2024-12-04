<div class="current-and-past-bids show" id="current-bids-block">
    <#list currentAuctions as item>
        <a href="/api/auctions/${item.id}" class="item-link">
            <div class="item">
                <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                <img src="/images/${item.imagePath}" alt="">
                <p class="black-writing">Item Name: ${item.title}</p>
                <p class="black-writing">Highest Bid: $ ${item.currentPrice}</p>
                <p class="black-writing">Time Left: ${item.dateAndTime}</p>
                <!--<p><span class="black-writing">User: </span><a href="/users/other-profile/${item.seller.id}">@${item.seller.username}</a></p>-->
            </div>
        </a>
    </#list>
</div>