<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Auction</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f9ff;
            color: #333;
        }

        /* Main Container Styling */
        .edit-auction-main {
            max-width: 400px; /* Reduced width for a smaller form */
            margin: 100px auto; /* Increased vertical spacing for centering */
            padding: 30px; /* Reduced padding for a more compact look */
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
        input[type="number"],
        input[type="datetime-local"],
        select,
        textarea {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccd9f0;
            border-radius: 4px;
            font-size: 16px;
            background-color: #f9fbff;
        }

        input:focus,
        select:focus,
        textarea:focus {
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

        form > * {
            margin-bottom: 20px;
        }

        /* Responsive Design */
        @media (max-width: 600px) {
            .edit-auction-main {
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
    <main class="auction-main">
        <div class="sign-up-login-form">
            <h2>Edit Auction</h2>
            <form action="/admin/auctions/edit/${auction.id}" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${auction.id}">

                <label for="title">Title</label>
                <input type="text" name="title" id="title" value="${auction.title}" required>

                <label for="description">Description</label>
                <textarea rows="5" cols="40" name="description" id="description" required>${auction.description}</textarea>

                <label for="startingPrice">Starting Price</label>
                <input type="number" name="startingPrice" id="startingPrice" value="${auction.startingPrice}" required>

                <label for="currentPrice">Current Price</label>
                <input type="number" name="currentPrice" id="currentPrice" value="${auction.currentPrice}" required>

                <label for="auctionStatus">Auction Status</label>
                <select name="auctionStatus" id="auctionStatus" required>
                    <option value="active" ${auction.auctionStatus} == 'active' ? then('selected', '')>Active</option>
                    <option value="completed" ${auction.auctionStatus} == 'completed' ? then('selected', '')>Completed</option>
                    <option value="cancelled" ${auction.auctionStatus} == 'cancelled' ? then('selected', '')>Cancelled</option>
                </select>

                <label for="seller">Seller ID</label>
                <input type="text" name="seller" id="seller" value="${auction.seller.id}" required>

                <label>Seller Name</label>
                <input type="text" value="${auction.seller.name}" readonly>

                <label>Seller Username</label>
                <input type="text" value="${auction.seller.username}" readonly>

                <label for="dateAndTime">Date and Time</label>
                <input type="datetime-local" name="auctionEnd" id="auctionEnd" value="${auctionEnd}" required>

                <label for="imagePath">Image Path</label>
                <input type="text" name="imagePath" id="imagePath" value="${auction.imagePath}">

                <label for="category">Category</label>
                <input type="text" name="category" id="category" value="${auction.category}" required>

                <button type="submit">Update Auction</button>
            </form>
        </div>
    </main>
</body>
</html>
