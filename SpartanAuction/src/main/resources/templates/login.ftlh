<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>
    <#include "./include/header.ftlh">
    <main class="login-main">
        <div class="sign-up-login-form">
            <h2>Login</h2>
            <form action="/login" method="post" >
                <label for="username">Username</label>
                <br>
                <input type="text" name="username" id="username" required>
                <br>
                <label for="password">Password</label>
                <br>
                <input type="password" name="password" id="password" required>
                <br>
                <a href="#">Forgot Username or Password</a><br>
                <div>
                    <div>
                        <a href="/signup" class="sign-log-link">Sign Up Instead</a>
                    </div>
                    <div>
                        <button class=".sign-log-button">Login</button>
                    </div>
                        <!--<button class=".sign-log-button">Admin Login</button>-->
                </div>
            </form>
        </div>
    </main>
</body>
</html>