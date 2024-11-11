package com.csc340.SpartanAuction.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Create a new Item
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // Get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get an item by its ID
    public Item getItemById(int id) {
        return itemRepository.findById(id).orElse(null);
    }

    // Get an item by its name
    public List<Item> getItemsByName(String name) {
        return itemRepository.findByName(name);
    }

    // Get items by category
    public List<Item> getItemsByCategory(String category) {
        return itemRepository.findByCategory(category);
    }

    // Get statistics for items by provider
    public List<Item> getItemsByProvider(int providerId) {
        return itemRepository.findByProviderId(providerId);
    }

    // Update an existing Item
    public Item updateItem(int id, Item itemDetails) {
        return itemRepository.findById(id).map(item -> {
            item.setName(itemDetails.getName());
            item.setProviderId(itemDetails.getProviderId());
            item.setDateAndTime(itemDetails.getDateAndTime());
            item.setImagePath(itemDetails.getImagePath());
            item.setInfo(itemDetails.getInfo());
            item.setStartBid(itemDetails.getStartBid());
            item.setHighestBid(itemDetails.getHighestBid());
            item.setCategory(itemDetails.getCategory());
            item.setStatus(itemDetails.getStatus());
            return itemRepository.save(item);
        }).orElseThrow(() -> new RuntimeException("Item not found with id " + id));
    }

    // Delete an Item by ID
    public void deleteItem(int id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new RuntimeException("Item not found with id " + id);
        }
    }
}