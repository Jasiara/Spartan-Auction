<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Auction</title>
    <link type="text/css" rel="stylesheet" href="/css/style.css">
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
