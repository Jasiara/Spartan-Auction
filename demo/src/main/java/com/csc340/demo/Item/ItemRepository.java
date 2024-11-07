package com.csc340.demo.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByName(String name);
    List<Item> findByCategory(String category);
    List<Item> findByProviderId(int providerId);
}