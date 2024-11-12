# API

## Users
- http://localhost:8080/users/new
- Body: 
  {
      "username": "musicstarchy", 
      "password": "password8", 
      "email": "musicstarchy@gmail.com", 
      "name": "Tori Finch", 
      "location": "Greensboro, NC", 
      "userType": "user", 
      "imagePath": "imagePath8"
  }

- http://localhost:8080/users/1

- http://localhost:8080/users/update/1
- Body:
  {
    "username": "impoptic",
    "password": "updatedPassword",
    "email": "impoptic@gmail.com",
    "name": "Hazel Victor",
    "location": "Greensboro, NC",
    "userType": "user",
    "imagePath": "imagePath1"
  }
- http://localhost:8080/users/delete/6

- http://localhost:8080/users/all

## Auctions
- http://localhost:8080/api/auctions/all

- http://localhost:8080/api/auctions/2
- Body:
  {
    "title": "Sony Headphones",
    "description": "These are headphones",
    "startingPrice": 40.0,
    "currentPrice": 40.0,
    "auctionStatus": "active",
    "seller": 1,
    "dateAndTime": "2024-11-23T18:25:43.000+00:00",
    "imagePath": "updatedImagePath",
    "category": "headphone"
}

- The get and delete request
- http://localhost:8080/api/auctions/1

- http://localhost:8080/api/auctions/provider/2/statistics

- http://localhost:8080/api/auctions/category/phone

- http://localhost:8080/api/auctions/name/headphone

## Reviews
- http://localhost:8080/reviews/new
- Body:
  {
    "reviewUser": 1, 
    "providerUser": 4, 
    "review": "random", 
    "rating": 1
  }

- http://localhost:8080/reviews/user/1

- http://localhost:8080/reviews/3

- http://localhost:8080/reviews/update/1
- Body:
  {
    "reviewUser": 1, 
    "providerUser": 2, 
    "review": "updatedReview", 
    "rating": 1
  }

- http://localhost:8080/reviews/delete/12
## Bids
- http://localhost:8080/bids/new
- Body:
  {
    "auction": 4,
    "amount": 135,
    "user": 1
  }

- http://localhost:8080/bids/1

- http://localhost:8080/bids/delete/6

- http://localhost:8080/bids/update/1
- Body:
  {
    "auction": 4,
    "amount": 135,
    "user": 1
  }
