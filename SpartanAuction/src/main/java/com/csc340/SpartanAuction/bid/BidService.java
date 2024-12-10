package com.csc340.SpartanAuction.bid;


import com.csc340.SpartanAuction.auction.Auction;
import com.csc340.SpartanAuction.auction.AuctionRepository;
import com.csc340.SpartanAuction.auction.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BidService {
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private AuctionRepository auctionRepository;

    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    public Bid getBidById(int id) {
        return bidRepository.findById(id).orElse(null);
    }

    public List<Bid> getAllBidsForOneItem(int itemId) {
        return bidRepository.getAllBidsForOneAuction(itemId);
    }

    public void addNewBid(Bid bid) {
        if (bidRepository.existsById(bid.getId())) {
            bid = new Bid(bid);
            bidRepository.save(bid);
            return;
        }
        bid = new Bid(bid.getAuction(), bid.getAmount(), bid.getUser());
        bidRepository.save(bid);
    }

    public List<Bid> getCurrentBidsForUser(int userId) {
        List<Bid> listOfAllBids = bidRepository.getCurrentBidsForUser(userId);
        List<Bid> highestBids = new ArrayList<>();
        if (listOfAllBids.size() > 0) {
            Bid addingBid = listOfAllBids.get(0);
            highestBids.add(addingBid);
            Auction currentAuction = listOfAllBids.get(0).getAuction();
            for (int i = 1; i < listOfAllBids.size(); i++) {
                if (listOfAllBids.get(i).getAuction() != currentAuction) {
                    highestBids.add(listOfAllBids.get(i));
                    currentAuction = listOfAllBids.get(i).getAuction();
                }

            }
        }
        return highestBids;
    }

    public double getHighestBidForAuction(int auctionId) {
        double highestBid = bidRepository.getHighestBidForAuction(auctionId);
        if (highestBid == 0) {
            Auction auction = auctionRepository.findById(auctionId).orElse(null);
            highestBid = auction.getStartingPrice();
        }
        return highestBid;
    }

    public List<Bid> getPastBidsForUser(int userId) {
        List<Bid> listOfAllBids = bidRepository.getPastBidsForUser(userId);
        List<Bid> pastBids = new ArrayList<>();

        for (int i = 0; i < listOfAllBids.size(); i++) {
            if (listOfAllBids.get(i).getAuction().getCurrentPrice() == listOfAllBids.get(i).getAmount()) {
                pastBids.add(listOfAllBids.get(i));
            }
        }
        return pastBids;
    }

    public List<Bid> getAllBidsForUser(int userId) {
        return bidRepository.getAllBidsForUser(userId);
    }

    public void updateBid(int id, Bid bid) {
        Bid existing = getBidById(id);
        existing.setAuction(bid.getAuction());
        existing.setAmount(bid.getAmount());
        existing.setUser(bid.getUser());

        //Technically the 4 lines above are not necessary because the save method merges by default.
        bidRepository.save(existing);
    }

    public void deleteBidById(int id) {
        bidRepository.deleteById(id);
    }

    public void deleteAllBidsForOneUserAndAuction(int userId, int auctionId) {
        List<Bid> bids = bidRepository.getAllBidsForOneUserForOneAuction(userId,auctionId);

        while (!bids.isEmpty()) {
            Bid deletedBid = bids.get(0);
            bids.remove(0);
            bidRepository.deleteById(deletedBid.getId());
        }
    }

}
