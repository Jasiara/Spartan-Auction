package com.csc340.SpartanAuction.auction;

import com.csc340.SpartanAuction.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;

    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public Auction getAuctionById(int id) {
        return auctionRepository.findById(id).orElseThrow(() -> new RuntimeException("Auction not found"));
    }

    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    public Auction updateAuction(int id, Auction auctionDetails) {
        Auction auction = auctionRepository.findById(id).orElseThrow(() -> new RuntimeException("Auction not found"));
        auction.setTitle(auctionDetails.getTitle());
        auction.setDescription(auctionDetails.getDescription());
        auction.setStartingPrice(auctionDetails.getStartingPrice());
        auction.setCurrentPrice(auctionDetails.getCurrentPrice());
        auction.setAuctionStatus(auctionDetails.getAuctionStatus());
        auction.setSellerUsername(auctionDetails.getSellerUsername());
        return auctionRepository.save(auction);
    }

    public void deleteAuction(int id) {
        auctionRepository.deleteById(id);
    }
}