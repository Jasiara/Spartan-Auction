<header>
    <div class="header-items">
        <a href="/public/api/auctions">Spartan Auction</a>
    </div>
    <form class="search" action="">
        <input type="text" placeholder="Search . . .">
        <a href="./search.html"><i class="fa fa-search"></i></a>
    </form>
    <#if currentlyLoggedIn == true>
        <a href="/users/profile" class="link-header-div">
            <#if smallUser.imagePath == 'imagePath'>
                <i class="fa fa-user-circle"></i>
            <#else>
                <img class="profile-img-small-header" src="/images/${smallUser.imagePath}" alt="">
            </#if>
            <p>@${smallUser.username}</p>
        </a>
        <form action="/logout" method="post">
            <button class="link-button" type="submit">Sign Out</button>
        </form>
    <#else>
        <div class="sign-up-login">
            <a href="/login" class="link-button">Login</a>
            <a href="/signup" class="link-button">Sign Up</a>
        </div>
    </#if>
</header>