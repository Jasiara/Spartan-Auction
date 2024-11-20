package com.csc340.SpartanAuction.bid;


import com.csc340.SpartanAuction.auction.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BidService {
    @Autowired
    private BidRepository bidRepository;

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
        for (int i = 0; i < listOfAllBids.size(); i++) {
            Bid addingBid = listOfAllBids.get(i);
            for (int j = i + 1; j < listOfAllBids.size(); j++) {
                if (listOfAllBids.get(i).getAuction().equals(listOfAllBids.get(j).getAuction()) && listOfAllBids.get(j).getAmount() > addingBid.getAmount()) {
                    addingBid = listOfAllBids.get(j);
                }
            }
            highestBids.add(addingBid);
        }
        return highestBids;
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

}
