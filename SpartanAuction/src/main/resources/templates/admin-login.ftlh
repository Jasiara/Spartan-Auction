<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <main class="login-main">
        <div class="sign-up-login-form">
            <div>
                <h2>Admin Login</h2>
            </div>
            <div>
                <form action="/admin/validate" method="post">
                    <label for="username">Username</label>
                    <br>
                    <input type="text" name="username" id="username" required>
                    <br>
                    <label for="password">Password</label>
                    <br>
                    <input type="password" name="password" id="password" required>
                    <br>
                    <div>
                        <button type="submit">Login</button>

                    </div>
                    <#if error??>
                        <div class="error">${error}</div>
                    </#if>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
