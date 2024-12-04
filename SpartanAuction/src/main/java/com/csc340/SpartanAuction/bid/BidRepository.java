package com.csc340.SpartanAuction.bid;

import com.csc340.SpartanAuction.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface BidRepository extends JpaRepository<Bid, Integer> {
    @Query(value = "SELECT * FROM bid WHERE auction_id = :auctionId", nativeQuery = true)
    public List<Bid> getAllBidsForOneAuction(@Param("auctionId") int auctionId);

    @Query(value = "SELECT bid.id, bid.amount, bid.auction_id, bid.user_id FROM bid, auction WHERE bid.auction_id = auction.id AND user_id = :userId AND auction.auction_status = 'active';", nativeQuery = true)
    List<Bid> getCurrentBidsForUser(@Param("userId")int userId);

    //SELECT bid.id, bid.amount, bid.auction_id, bid.user_id FROM bid, auction WHERE bid.auction_id = auction.id AND bid.user_id = 252 AND auction.auction_status = 'completed';
    @Query(value = "SELECT bid.id, bid.amount, bid.auction_id, bid.user_id FROM bid, auction WHERE bid.auction_id = auction.id AND bid.user_id = :userId AND auction.auction_status = 'completed';", nativeQuery = true)
    List<Bid> getPastBidsForUser(@Param("userId")int userId);
}
