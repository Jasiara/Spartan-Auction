<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Auctions</title>
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
            .auctions-main {
                max-width: 900px;
                margin: 50px auto;
                padding: 20px;
                background-color: #ffffff;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
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
                .auctions-main {
                    margin: 20px;
                    padding: 15px;
                }

                h2 {
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
    <main class="auctions-main">
        <h2>Manage Auctions</h2>
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Starting Price</th>
                    <th>Current Price</th>
                    <th>Status</th>
                    <th>Actions</th>
               </tr>
               </thead>
               <tbody>
                   <#list auctions as auction>
                       <tr>
                           <td>${auction.title}</td>
                           <td>${auction.description}</td>
                           <td>${auction.startingPrice}</td>
                           <td>${auction.currentPrice}</td>
                           <td>${auction.auctionStatus}</td>
                           <td>
                               <a href="/admin/auctions/edit/${auction.id}" class="button">Edit</a>
                               <a href="/admin/auctions/delete/${auction.id}" class="button">Delete</a>
                           </td>
                       </tr>
                   </#list>
               </tbody>
               </table>
               <a href="/admin/home" class="button">Back to Dashboard</a>
               </main>
               </body>
               </html>
