package com.csc340.SpartanAuction.bid;

import com.csc340.SpartanAuction.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface BidRepository extends JpaRepository<Bid, Integer> {
    @Query(value = "SELECT * FROM bid WHERE auction_id = :auctionId", nativeQuery = true)
    public List<Bid> getAllBidsForOneAuction(@Param("auctionId") int auctionId);

    @Query(value = "SELECT * FROM bid WHERE user_id = :userId", nativeQuery = true)
    List<Bid> getCurrentBidsForUser(@Param("userId")int userId);
}
