package com.csc340.demo.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // GET item by ID
    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable int id) {
        return itemService.getItemById(id);
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

    // PUT (update) an existing Item
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item itemDetails) {
        return itemService.updateItem(id, itemDetails);
    }

    // DELETE an Item
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return "Item with ID " + id + " has been deleted.";
    }
}