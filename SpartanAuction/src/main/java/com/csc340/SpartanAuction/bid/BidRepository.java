package com.csc340.SpartanAuction.bid;

import com.csc340.SpartanAuction.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface BidRepository extends JpaRepository<Bid, Integer> {
    @Query(value = "SELECT * FROM bid WHERE auction_id = :auctionId", nativeQuery = true)
    public List<Bid> getAllBidsForOneAuction(@Param("auctionId") int auctionId);

    @Query(value = "SELECT bid.id, bid.amount, bid.auction_id, bid.user_id FROM bid, auction WHERE bid.auction_id = auction.id AND user_id = :userId AND auction.auction_status = 'active' ORDER BY bid.auction_id DESC, bid.amount DESC;", nativeQuery = true)
    List<Bid> getCurrentBidsForUser(@Param("userId")int userId);

    //SELECT bid.id, bid.amount, bid.auction_id, bid.user_id FROM bid, auction WHERE bid.auction_id = auction.id AND bid.user_id = 252 AND auction.auction_status = 'completed';
    @Query(value = "SELECT bid.id, bid.amount, bid.auction_id, bid.user_id FROM bid, auction WHERE bid.auction_id = auction.id AND bid.user_id = :userId AND auction.auction_status = 'completed';", nativeQuery = true)
    List<Bid> getPastBidsForUser(@Param("userId")int userId);

    @Query(value = "SELECT bid.id, bid.amount, bid.auction_id, bid.user_id FROM bid, auction WHERE bid.auction_id = auction.id AND bid.user_id = :userId;", nativeQuery = true)
    List<Bid> getAllBidsForUser(@Param("userId")int userId);

    @Query(value = "SELECT (CASE WHEN MAX(bid.amount) != 0 then MAX(bid.amount) else 0 END) FROM bid WHERE auction_id = :auctionId", nativeQuery = true)
    double getHighestBidForAuction(@Param("auctionId")int auctionId);

    @Query(value = "SELECT (CASE WHEN MAX(bid.amount) != 0 then (SELECT bid.user_id FROM bid WHERE bid.auction_id = :auctionId LIMIT 1) ELSE 0 END) FROM bid WHERE bid.auction_id = :auctionId; ", nativeQuery = true)
    int getHighestBidderForOneAuction(@Param("auctionId")int auctionId);

    @Query(value = "SELECT * FROM bid WHERE auction_id = :auctionId and user_id = :userId;", nativeQuery = true)
    List<Bid> getAllBidsForOneUserForOneAuction(@Param("userId")int userId, @Param("auctionId")int auctionId);

}
