<div class="current-and-past-bids hide" id="auction-block">
    <#list auctions as item>
        <a href="/api/auctions/${item.id}" class="item-link">
            <div class="item">
                <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                <img src="/images/${item.imagePath}" alt="">
                <p class="black-writing">Item Name: ${item.title}</p>
                <p class="black-writing">Highest Bid: $ ${item.currentPrice}</p>
                <!--Not correct, need to figure it out-->
                <p class="black-writing">Time Left: ${item.dateAndTime}</p>
                <!--<p><span class="black-writing">User: </span><a href="/users/other-profile/${item.seller.id}">
                    @${item.seller.username}</a></p>-->
            </div>
        </a>
    </#list>
    <a href="./auctioning.html" class="item-link">
        <div class="item">
            <i class="fa fa-plus"></i>
            <p><span class="black-writing"></span><a href="./auctioning.html">Register New Auction</a></p>
        </div>
    </a>
</div>
