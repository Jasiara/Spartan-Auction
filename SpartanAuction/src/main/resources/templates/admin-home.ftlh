<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-k6RqeWeci5ZR/Lv4MR0sA0FfDOM4iYZzjH0nEy99TI5bQ1xFAmTQk0gddw7G0lQ" crossorigin="anonymous">
    <style>
        /* General Body Styling */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f9ff;
            color: #333;
        }

        /* Header Styling */
        .header {
            background-color: #004aad;
            color: #fff;
            padding: 15px;
            text-align: center;
            position: sticky;
            top: 0;
            z-index: 1000;
        }

        /* Main Container Styling */
        .dashboard-main {
            max-width: 900px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            color: #004aad;
            margin-bottom: 20px;
        }

        p {
            color: #555;
            font-size: 18px;
            margin-bottom: 30px;
        }

        /* Card Layout */
        .card-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
        }

        .card {
            flex: 1 1 calc(30% - 20px);
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
        }

        .card i {
            font-size: 40px;
            color: #004aad;
            margin-bottom: 10px;
        }

        .card a {
            text-decoration: none;
            color: #004aad;
            font-size: 16px;
            font-weight: bold;
        }

        .card a:hover {
            text-decoration: underline;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .card {
                flex: 1 1 100%;
            }

            h1 {
                font-size: 22px;
            }

            p {
                font-size: 16px;
            }
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Admin Dashboard</h1>
    </div>

    <div class="dashboard-main">
        <p>Welcome, Admin! Here's an overview of your tasks:</p>

        <div class="card-container">
            <div class="card">
                <i class="fas fa-users"></i>
                <a href="/admin/users">Manage Users</a>
            </div>

            <div class="card">
                <i class="fas fa-gavel"></i>
                <a href="/admin/auctions">Manage Auctions</a>
            </div>

            <div class="card">
                <i class="fas fa-chart-line"></i>
                <a href="/admin/analytics">View Analytics</a>
            </div>

            <div class="card">
                <i class="fas fa-cogs"></i>
                <a href="/admin/settings">Settings</a>
            </div>

            <div class="card">
                <i class="fas fa-sign-out-alt"></i>
                <a href="/logout">Logout</a>
            </div>
        </div>
    </div>
</body>
</html>
<<<<<<< HEAD
=======
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
     <style>
            /* General Body Styling */
            body {
                font-family: 'Arial', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f9ff;
                color: #333;
            }

            /* Main Container Styling */
            .dashboard-main {
                max-width: 800px;
                margin: 50px auto;
                padding: 20px;
                background-color: #ffffff;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                text-align: center;
            }

            h1 {
                color: #004aad;
                margin-bottom: 20px;
            }

            p {
                color: #555;
                font-size: 18px;
                margin-bottom: 30px;
            }

            /* Button Styling */
            .button {
                display: inline-block;
                padding: 12px 30px;
                margin: 15px;
                text-decoration: none;
                font-size: 16px;
                font-weight: bold;
                color: #ffffff;
                background-color: #ffcb05;
                border-radius: 6px;
                transition: all 0.3s ease-in-out;
            }

            .button:hover {
                background-color: #ffd633;
                color: #004aad;
            }

            /* Responsive Design */
            @media (max-width: 600px) {
                .dashboard-main {
                    margin: 20px;
                    padding: 15px;
                }

                h1 {
                    font-size: 22px;
                }

                p {
                    font-size: 16px;
                }

                .button {
                    padding: 10px 20px;
                    font-size: 14px;
                }
            }
        </style>
</head>
<body>
    <h1>Admin Dashboard</h1>
    <p>Welcome, Admin!</p>

    <div>
        <!-- Buttons for admin actions -->
        <a href="/admin/users" class="button">View and Manage Users</a>
        <a href="/admin/auctions" class="button">View and Manage Auctions</a>
       <a href="/logout" class="button">Logout</a>
    </div>
</body>
</html>
=======
>>>>>>> 8ca39ae0639ac96dfb49de5749319bd1c292f233
