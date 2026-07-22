package com.microservices.inventory.controller;

import com.microservices.inventory.client.ProductClient;
import com.microservices.inventory.entity.Inventory;
import com.microservices.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductClient productClient;

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @GetMapping("/product/{productId}")
    public List<Inventory> getInventoryByProduct(@PathVariable Long productId) {
        return inventoryRepository.findByProductId(productId);
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        // Verify product exists
        Map product = productClient.getProduct(inventory.getProductId());
        if (product == null) {
            throw new RuntimeException("Product not found with id: " + inventory.getProductId());
        }
        return inventoryRepository.save(inventory);
    }

    @GetMapping("/product/{productId}/total")
    public Integer getTotalStock(@PathVariable Long productId) {
        List<Inventory> inventoryList = inventoryRepository.findByProductId(productId);
        return inventoryList.stream().mapToInt(Inventory::getQuantity).sum();
    }
}
