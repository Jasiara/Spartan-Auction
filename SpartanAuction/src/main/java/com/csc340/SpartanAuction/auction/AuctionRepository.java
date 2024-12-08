package com.csc340.SpartanAuction.auction;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Integer> {
    @Query(value = "SELECT * FROM auction WHERE title LIKE %?%", nativeQuery = true)
    List<Auction> findByName(String name);

    @Query(value = "SELECT * FROM auction WHERE category LIKE %?%", nativeQuery = true)
    List<Auction> findByCategory(String category);
    @Query(value = "SELECT * FROM auction WHERE seller_id = :providerId;", nativeQuery = true)
    List<Auction> findByProviderId(int providerId);

    @Query(value = "SELECT * FROM auction WHERE auction_status = 'active';", nativeQuery = true)
    List<Auction> findAllCurrentAuctions();

    @Query(value = "SELECT * FROM auction WHERE seller_id = :id AND auction_status = 'active';", nativeQuery = true)
    List<Auction> getCurrentAuctionsForUser(int id);

    @Query(value = "SELECT * FROM auction WHERE seller_id = :id;", nativeQuery = true)
    List<Auction> getAllAuctionsForUser(int id);
}