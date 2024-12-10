<div class="current-and-past-bids-2 hide" id="auction-block">
    <h2> Current Auctions </h2>
    <div>
    <#assign index = 0>
    <#list auctions as item>
        <#if item.auctionStatus == 'active'>
            <a href="/public/api/auctions/${item.id}" class="item-link">
                <div class="item">
                    <#if item.imagePath == "imagePath">
                        <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                        <img src="/images/no-auction-photo.jpg" alt="">
                    <#else>
                        <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                        <img src="/images/${item.imagePath}" alt="">
                    </#if>
                    <p class="black-writing">Item Name: ${item.title}</p>
                    <p class="black-writing">Highest Bid: $ ${item.currentPrice}</p>
                    <p class="black-writing">Auction End: ${item.dateAndTime}</p>
                    <a href="/api/auctions/update/${item.id}" class="navy-button-2">Edit Auction</a>
                    <#assign index = index + 1>
                </div>
            </a>
        </#if>
    </#list>
    <#if loggedIn = true>
            <a href="/api/auctions/new-auction/${user.id}" class="item-link">
                <div class="item">
                    <i class="fa fa-plus"></i>
                    <p><span class="black-writing"></span><a href="/api/auctions/new-auction/${user.id}">Register New Auction</a></p>
                </div>
            </a>
        </#if>
    </div>
    <h2> Past Auctions </h2>
    <div>
    <#list auctions as item>
            <#if item.auctionStatus == 'completed'>
                <a href="/public/api/auctions/${item.id}" class="item-link">
                    <div class="item">
                        <#if item.imagePath == "imagePath">
                            <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                            <img src="/images/no-auction-photo.jpg" alt="">
                        <#else>
                            <!--IMAGE SOURCE:  https://www.thehouseofr.com/victrola-record-player-->
                            <img src="/images/${item.imagePath}" alt="">
                        </#if>
                        <p class="black-writing">Item Name: ${item.title}</p>
                        <p class="black-writing">Highest Bid: $ ${item.currentPrice}</p>
                    </div>
                </a>
            </#if>
    </#list>
    </div>
</div>
