<div class="profile-top">
    <div class="profile-img">
        <!--IMAGE SOURCE:  https://www.pinterest.com/pin/712905816020483535/-->
            <img class="profile-img" src="/images/${user.imagePath}" alt="">
        </div>
        <div class="profile-desc">
            <p>Name: ${user.name}</p>
            <p>Username: ${user.username}</p>
            <p>Location: ${user.location}</p>
            <div class="rating">
                <#if user.ratingAverage != 0>
                    <p>Rating:</p>
                    <#assign ratingTimesTen = user.ratingAverage * 10>
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
                        <#assign ratingNonDouble = user.ratingAverage * 100>
                        <#assign ratingDouble = ratingNonDouble / 100>
                        <p class="rating-number">${user.ratingAverage?string("0.0")}</p>
                    </div>
                <#else>
                    <p class="no-rating">No Rating</p>
                </#if>
            </div>
        </div>
            <a href="/users/update/${user.id}"><i class="fa fa-gear" style="font-size: 500%;"></i></a>

</div>