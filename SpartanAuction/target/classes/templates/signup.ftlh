<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign-Up Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>

<body>
    <#include "./include/header.ftlh">
    <main class="sign-up-main">
        <div class="sign-up-login-form">
            <h2>Sign-Up</h2>
            <form action="/users/new" method="post">
                <label for="name">Name</label>
                <br>
                <input type="text" name="name" id="name" required>
                <br>
                <label for="username">Username</label>
                <br>
                <input type="text" name="username" id="username" required>
                <br>
                <label for="email">Email Address</label>
                <br>
                <input type="email" name="email" id="email" required>
                <br>
                <label for="password">Password</label>
                <br>
                <input type="password" name="password" id="password" required>
                <br>
                <label for="confirm-password">Confirm Password</label>
                <br>
                <input type="password" name="confirm-password" id="confirm-password" required>
                <br>
                <p><span id="message"></span></p>
                <div>
                    <div>
                        <a href="/users/login" class="sign-log-link">Login Instead</a>
                    </div>
                    <div>
                        <button class="sign-log-button">Sign-Up</button>
                    </div>
                </div>
            </form>
        </div>
    </main>
    <script>
        let check = function() {
            if (document.getElementById('password').value !== document.getElementById('confirm-password').value) {
                document.getElementById('message').style.color = 'red';
                document.getElementById('message').innerHTML = 'not matching';
            }
        }
    </script>
</body>

</html>