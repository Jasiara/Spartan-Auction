package com.csc340.SpartanAuction.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query(value = "SELECT * FROM item WHERE name LIKE %?%", nativeQuery = true)
    List<Item> findByName(String name);

    @Query(value = "SELECT * FROM item WHERE category LIKE %?%", nativeQuery = true)
    List<Item> findByCategory(String category);
    @Query(value = "SELECT * FROM item WHERE provider_id = :providerId", nativeQuery = true)
    List<Item> findByProviderId(int providerId);
}