<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>
    <#include "/include/header.html">
    <main class="login-main">
        <div class="sign-up-login-form">
            <div>
                <h2>Login</h2>
            </div>
            <div>
                <form action="" method="post">
                    <label for="email-adress">Email Adress</label>
                    <br>
                    <input type="email" name="email-address" id="email-address">
                    <br>
                    <label for="password">Password</label>
                    <br>
                    <input type="password" name="password" id="password">
                    <br>
                    <a href="#">Forgot Username or Password</a><br>
                    <div>
                        <a href="./signup.html" class="sign-log-link">Sign Up Instead</a>
                        <a href="./profile.html" class="sign-log-link">Login</a>
                        <a href="./adminboard.html">Admin Login</a>
                    </div>
                </form>
            </div>
        </div>
    </main>
</body>
</html>