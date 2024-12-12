package com.csc340.SpartanAuction.auction;

import com.csc340.SpartanAuction.bid.Bid;
import com.csc340.SpartanAuction.bid.BidRepository;
import com.csc340.SpartanAuction.bid.BidService;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompleted;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompletedRepository;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompletedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csc340.SpartanAuction.user.*;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private UserRepository userRepository; // Add this line to inject the UserRepository

    @Autowired
    private BidService bidService;

    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private ReviewCompletedRepository reviewCompletedRepository;
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public List<Auction> getAllCurrentAuctions() {
        checkForActiveAuctions(auctionRepository.findAllCurrentAuctions());
        return auctionRepository.findAllCurrentAuctions();
    }
    public Auction getAuctionById(int id) {
        Auction auction = auctionRepository.findById(id).orElseThrow(() -> new RuntimeException("Auction not found"));
        updateHighestBidForOneAuction(auction);
        return auction;
    }

    public List<Auction> getCurrentAuctionsForUser(int id) {
        checkForActiveAuctions(auctionRepository.getCurrentAuctionsForUser(id));
        return auctionRepository.getCurrentAuctionsForUser(id);
    }

    public List<Auction> getAuctionsByName(String name) {
        return auctionRepository.findByName(name);
    }

    public List<Auction> getAuctionsByCategory(String category) {
        return auctionRepository.findByCategory(category);
    }

    public List<Auction> getAuctionsByProvider(int providerId) {
        checkForActiveAuctions(auctionRepository.findByProviderId(providerId));
        return auctionRepository.findByProviderId(providerId);
    }

    public List<Auction> getAllAuctionsForUser(int userId) {
        checkForActiveAuctions(auctionRepository.getAllAuctionsForUser(userId));
        return auctionRepository.getAllAuctionsForUser(userId);
    }


    //    public Auction createAuction(Auction auction) {
//        return auctionRepository.save(auction);
//    }
    public void createAuction(Auction auction) {
        /*User seller = userRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        auction.setSeller(seller); // Set the seller before saving*/
        if (auctionRepository.existsById(auction.getId())) {
            auction = new Auction(auction);
            auctionRepository.save(auction);
            return;
        }
        auction = new Auction(auction.getTitle(), auction.getDescription(), auction.getStartingPrice(),
                auction.getCurrentPrice(), auction.getAuctionStatus(), auction.getSeller(),
                auction.getDateAndTime(), auction.getImagePath(), auction.getCategory());
        auctionRepository.save(auction);


    }


    public Auction updateAuction(int id, Auction auctionDetails) {
        Auction auction = auctionRepository.findById(id).orElseThrow(() -> new RuntimeException("Auction not found"));
        auction.setTitle(auctionDetails.getTitle());
        auction.setDescription(auctionDetails.getDescription());
        auction.setStartingPrice(auctionDetails.getStartingPrice());
        if (auctionDetails.getStartingPrice() > auctionDetails.getCurrentPrice()) {
            auction.setCurrentPrice(auctionDetails.getStartingPrice());
        } else  {
            auction.setCurrentPrice(auctionDetails.getCurrentPrice());
        }
        auction.setAuctionStatus(auctionDetails.getAuctionStatus());
        auction.setSeller(auctionDetails.getSeller());
        auction.setDateAndTime(auctionDetails.getDateAndTime());
        auction.setImagePath(auctionDetails.getImagePath());
        auction.setCategory(auctionDetails.getCategory());
        return auctionRepository.save(auction);
    }

    public void deleteAuction(int id) {
        List<Bid> bidsForOneAuction = bidRepository.getAllBidsForOneAuction(id);

        while (!bidsForOneAuction.isEmpty()) {
            Bid deletedBid = bidsForOneAuction.get(0);
            bidsForOneAuction.remove(0);
            bidService.deleteBidById(deletedBid.getId());
        }

        ReviewCompleted reviewCompleted = reviewCompletedRepository.getReviewCompletedByAuctionId(id);
        if (reviewCompleted != null) {
            reviewCompletedRepository.deleteById(reviewCompleted.getId());
        }

        auctionRepository.deleteById(id);
    }

    public void updateHighestBidForOneAuction(Auction auction) {
        double highestBid = bidService.getHighestBidForAuction(auction.getId());
        auction.setCurrentPrice(highestBid);
        auctionRepository.save(auction);
    }

    public void updateHighestBidForAllAuction(List<Auction> auctions) {
        for (int i = 0; i < auctions.size(); i++) {
            double highestBid = bidService.getHighestBidForAuction(auctions.get(i).getId());
            auctions.get(i).setCurrentPrice(highestBid);
            auctionRepository.save(auctions.get(i));
        }
    }

    public void checkForActiveAuctions(List<Auction> auctions) {
        long millis = System.currentTimeMillis();
        Timestamp currentTime = new Timestamp(millis);
        for (int i = 0; i < auctions.size(); i++) {
            double highestBid = bidService.getHighestBidForAuction(auctions.get(i).getId());
            auctions.get(i).setCurrentPrice(highestBid);

            long timeLeft = auctions.get(i).getDateAndTime().getTime() - currentTime.getTime();
            if (timeLeft < 0) {
                auctions.get(i).setAuctionStatus("completed");
                ReviewCompleted newReviewCompleted = new ReviewCompleted();
                newReviewCompleted.setAuction(auctions.get(i));
                newReviewCompleted.setReviewCompleted(false);
                reviewCompletedRepository.save(newReviewCompleted);
            }
            auctionRepository.save(auctions.get(i));
        }
    }
}



