package org.example._20240925ordersysrestaurantmanagement.controller;

import org.example._20240925ordersysrestaurantmanagement.model.FoodItem;
import org.example._20240925ordersysrestaurantmanagement.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fooditems")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping
    public List<FoodItem> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
        FoodItem foodItem = foodItemService.getFoodItemById(id);
        if (foodItem != null) {
            return ResponseEntity.ok(foodItem);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public FoodItem createFoodItem(@RequestBody FoodItem foodItem) {
        return foodItemService.createFoodItem(foodItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long id, @RequestBody FoodItem foodItemDetails) {
        FoodItem updatedFoodItem = foodItemService.updateFoodItem(id, foodItemDetails);
        if (updatedFoodItem != null) {
            return ResponseEntity.ok(updatedFoodItem);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long id) {
        foodItemService.deleteFoodItem(id);
        return ResponseEntity.ok().build();
    }
}