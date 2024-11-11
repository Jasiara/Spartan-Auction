package com.csc340.SpartanAuction.auction;

import com.csc340.SpartanAuction.item.Item;
import com.csc340.SpartanAuction.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csc340.SpartanAuction.user.*;
import java.util.List;

@Service
public class AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private UserRepository userRepository; // Add this line to inject the UserRepository

    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public Auction getAuctionById(int id) {
        return auctionRepository.findById(id).orElseThrow(() -> new RuntimeException("Auction not found"));
    }

    public List<Auction> getAuctionsByName(String name) {
        return auctionRepository.findByName(name);
    }

    public List<Auction> getAuctionsByCategory(String category) {
        return auctionRepository.findByCategory(category);
    }

    public List<Auction> getAuctionsByProvider(int providerId) {
        return auctionRepository.findByProviderId(providerId);
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
        auction.setCurrentPrice(auctionDetails.getCurrentPrice());
        auction.setAuctionStatus(auctionDetails.getAuctionStatus());
        auction.setSeller(auctionDetails.getSeller());
        auction.setDateAndTime(auctionDetails.getDateAndTime());
        auction.setImagePath(auctionDetails.getImagePath());
        auction.setCategory(auctionDetails.getCategory());
        return auctionRepository.save(auction);
    }

    public void deleteAuction(int id) {
        auctionRepository.deleteById(id);
    }
}



