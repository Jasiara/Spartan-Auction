<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Reviews</title>
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
        .reviews-main {
            max-width: 900px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #004aad;
            margin-bottom: 30px;
        }

        /* Table Styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        thead {
            background-color: #004aad;
            color: #ffffff;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ccd9f0;
        }

        tbody tr:nth-child(odd) {
            background-color: #f9fbff;
        }

        tbody tr:nth-child(even) {
            background-color: #eef3fc;
        }

        /* Action Buttons Styling */
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            text-decoration: none;
            font-size: 14px;
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
            .reviews-main {
                margin: 20px;
                padding: 15px;
            }

            h1 {
                font-size: 22px;
            }

            table {
                font-size: 14px;
            }

            .button {
                padding: 8px 16px;
                font-size: 12px;
            }
        }
    </style>
</head>
<body>
    <div class="reviews-main">
        <h1>Manage Reviews</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Reviewer</th>
                    <th>Auction ID</th>
                    <th>Rating</th>
                    <th>Comment</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iterate over the reviews -->
                <#list reviews as review>
                    <tr>
                        <td>${review.id}</td>
                        <td>${review.reviewUser}</td> <!-- Assuming the review has a user object -->
                        <td>${review.auction.id}</td> <!-- Assuming the review has an auction object -->
                        <td>${review.rating}</td>
                        <td>${review.comment}</td>
                        <td>
                            <a href="/admin/reviews/edit/${review.id}" class="button">Edit</a>
                            <a href="/admin/reviews/delete/${review.id}" class="button" onclick="return confirm('Are you sure you want to delete this review?');">Delete</a>
                        </td>
                    </tr>
                </#list>
            </tbody>
        </table>
        <a href="/admin/home" class="button">Back to Dashboard</a>
    </div>
</body>
</html>