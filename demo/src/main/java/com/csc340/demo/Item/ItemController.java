package com.csc340.demo.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // POST a new Item
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    // GET all items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // GET item by its name
    @GetMapping("/name/{name}")
    public List<Item> getItemsByName(@PathVariable String name) {
        return itemService.getItemsByName(name);
    }

    // GET item by its category
    @GetMapping("/category/{category}")
    public List<Item> getItemsByCategory(@PathVariable String category) {
        return itemService.getItemsByCategory(category);
    }

    // GET statistics for items by provider
    @GetMapping("/provider/{providerId}/statistics")
    public List<Item> getItemsByProvider(@PathVariable int providerId) {
        return itemService.getItemsByProvider(providerId);
    }
}