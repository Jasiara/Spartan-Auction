package com.csc340.SpartanAuction.bid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface BidRepository extends JpaRepository<Bid, Integer> {
    @Query(value = "SELECT * FROM bid WHERE item_id = :itemId", nativeQuery = true)
    public List<Bid> getAllBidsForOneItem(@Param("itemId") int itemId);
}