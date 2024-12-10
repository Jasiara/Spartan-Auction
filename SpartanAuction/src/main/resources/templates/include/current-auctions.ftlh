<div class="current-and-past-bids-2 show" id="current-bids-block">
<div class="items-view">
<#if currentAuctionAmount gt 0>
<#assign index = 0>
    <#list currentAuctions as item>
        <#if item.auctionStatus == "active">
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
                    <p class="black-writing" id="auction-end${index}">Time Left: ${item.dateAndTime}</p>
                    <#assign index = index + 1>
                </div>
            </a>
        </#if>
    </#list>
<#else>
    <div class="no-current-bids-container">
        <br><br><br>
        <p class="no-current-bids">${user.username} currently doesn't have any auctions</p>
        <br><br><br><br><br><br>
    </div>
    </#if>
</div>
</div>