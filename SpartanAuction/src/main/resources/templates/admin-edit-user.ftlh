<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User</title>
      <style>
            body {
                font-family: 'Arial', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f9ff;
                color: #333;
            }

            /* Main Container Styling */
            .edit-user-main {
                max-width: 500px;
                margin: 50px auto;
                padding: 50px;
                background-color: #ffffff;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                text-align: center;
                color: #004aad;
            }

            /* Label Styling */
            label {
                font-weight: bold;
                color: #004aad;
            }

            /* Input Styling */
            input[type="text"],
            input[type="email"],
            input[type="password"],
            select {
                width: 100%;
                padding: 10px;
                margin: 8px 0;
                border: 1px solid #ccd9f0;
                border-radius: 4px;
                font-size: 16px;
                background-color: #f9fbff;
            }

            input[type="text"]:focus,
            input[type="email"]:focus,
            input[type="password"]:focus,
            select:focus {
                border-color: #004aad;
                outline: none;
                box-shadow: 0 0 5px rgba(0, 74, 173, 0.5);
            }

            /* Button Styling */
            button {
                width: 100%;
                background-color: #ffcb05;
                color: #004aad;
                border: none;
                padding: 12px;
                font-size: 18px;
                font-weight: bold;
                border-radius: 4px;
                cursor: pointer;
                transition: all 0.3s ease-in-out;
            }

            button:hover {
                background-color: #ffd633;
            }

            /* Form Container Spacing */
            form {
                display: flex;
                flex-direction: column;
            }

            /* Extra Spacing */
            .edit-user-main form > * {
                margin-bottom: 20px;
            }

            /* Responsive Design */
            @media (max-width: 600px) {
                .edit-user-main {
                    margin: 20px;
                    padding: 15px;
                }

                h2 {
                    font-size: 20px;
                }
            }
        </style>
</head>
<body>

    <main class="edit-user-main">
        <h2>Edit User</h2>
        <form action="/admin/users/edit/${user.id}" method="post">
        <form action="/admin/users/new" method="post">
            <!-- Name -->
            <label for="name">Name</label>
            <br>
            <input type="text" name="name" id="name" value="${user.name}" required>
            <br>

            <!-- Username -->
            <label for="username">Username</label>
            <br>
            <input type="text" name="username" id="username" value="${user.username}" required>
            <br>

            <!-- Email Address -->
            <label for="email">Email Address</label>
            <br>
            <input type="email" name="email" id="email" value="${user.email}" required>
            <br>

            <!-- Password -->
            <label for="password">Password</label>
            <br>
            <input type="password" name="password" id="password" required>
            <br>

            <!-- Confirm Password -->
            <label for="confirm-password">Confirm Password</label>
            <br>
            <input type="password" name="confirm-password" id="confirm-password" required>
            <br>

            <!-- User Type -->
            <label for="userType">Account Type</label>
            <br>
            <select id="userType" name="userType" required>
                <option value="user">User</option>
                <option value="admin">Admin</option>
            </select>
            <br><br>

            <!-- Submit Button -->
            <button type="submit">Submit</button>
        </form>

    </main>
</body>
</html>
