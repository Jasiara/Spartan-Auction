<div class="profile-top">
    <div class="profile-img">
        <!--IMAGE SOURCE:  https://www.pinterest.com/pin/712905816020483535/-->
            <#if user.imagePath = 'imagePath'>
                <i class="fa fa-user-circle"></i>
            <#else>
                <img class="profile-img" src="/images/${user.imagePath}" alt="">
            </#if>
        </div>
        <div class="profile-desc">
            <#if loggedIn = true>
                <p>Name: ${user.name}</p>
            </#if>
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
            <#if loggedIn = true>
            <a href="/users/update/${user.id}"><i class="fa fa-gear"></i></a>
            </#if>
</div>