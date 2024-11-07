package com.csc340.demo.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}