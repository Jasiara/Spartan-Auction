## Title

> Spartan Auction

 

## Team Members

> Annica Mclean, David Williams, and Jasiara Mayes

 

## Description 

> Spartan Auction is exclusively for Spartans, this app lets you create a personalized profile and explore auctions tailored to your interests. With a user-friendly interface, you can easily navigate the app to discover items you love, place bids, and monitor your auction activity. The sidebar conveniently displays relevant bids, while the bottom menu offers quick access to post new items for sale or check the status of your bids. Whether you're looking to buy or sell, Spartan Auction connects you with fellow students in a secure and engaging platform.

## Q&A

> Motivation for the App:
To create a secure, student-exclusive marketplace for UNCG students to buy, sell, and auction items within their campus community.

> Goals of the App:
Facilitate easy and safe transactions among students.
Provide a platform for students to auction items tailored to their interests.
Build a sense of community and connection through shared commerce.
Problem the App Solves:
It addresses the lack of a centralized, student-specific platform for secure peer-to-peer transactions at UNCG.

> Features of the App:
Student-only sign-up and profile creation.
Personalized auction listings based on user interests.
Easy item posting, bidding, and bid management.
Real-time notifications and updates.
What Makes the App Interesting/Cool:
It’s a unique, campus-exclusive auction platform that fosters community engagement while offering a personalized, secure shopping experience for students.


## How to Run App
1. First install XAMPP and get the sql file named `spartan-auction.sql` from the files.
2. Open up your IDE and run the program.
3. Go to http://localhost:8080/ to get to the home page.
4. From there you can use the app properly.
5. There are a few users you can use out of the gate.
    - Username: `impoptic` Password: `password` User-Type: `user`
    - Username: `shademap` Password: `password` User-Type: `user`
    - Username: `johnmclean` Password: `password` User-Type: `admin`
    - Username: `admin` Password: `admin123` User-Type: `admin`

### A Few Notes
- Some of the users in the already added database do not have encoded passwords. You can bypass this by copying the already encoded passwords and replacing the non encoded passwords.
- All of the encoded passwords are password
- Sometimes XAMPP is a bit glitchy so it might cause less of a headache if you just run the project without the database, and then take the sql and open it in a text file. From there just copy over the insert commands of the database. The oreder is user > review > auction > review_completed > reply > bid. This order allows you to avoid foreign key constraints.