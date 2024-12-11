<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>

<body>
    <#include "./include/header.ftlh">
    <main class="sign-up-main">
        <div class="sign-up-login-form">
            <div>
                <h2>Update ${user.username} Profile</h2>
                <div class="delete-div">
                    <a href="/users/delete/${user.id}" class="delete">Delete Profile</a>
                </div>
            </div>
            <form action="/users/update/${user.id}" method="post" modelAttribute="${user}">
                <label for="name">Name</label>
                <br>
                <input type="text" name="name" id="name" value="${user.name}"">
                <br>
                <label for="email">Email Address</label>
                <br>
                <input type="email" name="email" id="email" value=${user.email}>
                <br>
                <label for="username">Username</label>
                <br>
                <input type="text" name="username" id="username" value=${user.username}>
                <label for="location">Location</label>
                <br>
                <input type="text" name="location" id="location" value="${user.location}">
                <br>
                <label for="imagePath">Image Path</label>
                <br>
                <input type="text" name="imagePath" id="imagePath" value=${user.imagePath}>
                <label for="password">New Password</label>
                <br>
                <input type="password" name="password" id="password" value=${user.password}>
                <br>
                <input type="text" name="userType" id="userType" value=${user.userType} class="hide">
                <div>
                    <div>
                        <a href="/users/profile" class="sign-log-link">Cancel</a>
                    </div>
                    <div>
                        <button type=submit class=".sign-log-button">Update Profile</button>
                    </div>
                </div>
            </form>
        </div>
    </main>
</body>
</html>