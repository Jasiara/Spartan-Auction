<div class="current-and-past-bids-2 show" id="current-bids-block">
<div class="items-view">
<#assign index = 0>
    <#list currentAuctions as item>
        <#if item.auctionStatus = "active">
            <a href="/api/auctions/${item.id}" class="item-link">
                <div class="item">
                    <#if item.imagePath = "imagePath">
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
</div>
</div>