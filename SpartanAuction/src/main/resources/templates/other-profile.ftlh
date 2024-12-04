<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Other Profile User Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>

<body>
    <#include "/include/header.ftlh">
    <main>
        <#include "/include/profile-top.ftlh">
        <#include "/include/other-user-nav(current_auctions).ftlh">
        <#include "/include/current-auctions.ftlh">
    </main>
    <script src="/script/profile.js" type="text/javascript"></script>
    </body>

</html>