package com.csc340.SpartanAuction.bid;

import com.csc340.SpartanAuction.rating.Rating;
import com.csc340.SpartanAuction.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {
    @Autowired
    private RatingRepository bidRepository;

    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    public Bid getBidById(int id) {
        return bidRepository.findById(id).orElse(null);
    }

    public List<Bid> getAllBidsForOneItem(int itemId) {
        return bidRepository.getAllBidsForOneItem(itemId);
    }

    public void addNewBid(Bid bid) {
        if (bidRepository.existsById(bid.getId())) {
            bid = new Bid(bid);
            bidRepository.save(bid);
            return;
        }
        bid = new Bid(bid.getItem(), bid.getAmount(), bid.getUser());
        bidRepository.save(bid);
    }

    public void updateBid(int id, Bid bid) {
        Bid existing = getBidById(id);
        existing.setItem(bid.getItem());
        existing.setAmount(bid.getAmount());
        existing.setUser(bid.setUser());

        //Technically the 4 lines above are not necessary because the save method merges by default.
        bidRepository.save(existing);
    }

    public void deleteBidById(int id) {
        bidRepository.deleteById(id);
    }

}
