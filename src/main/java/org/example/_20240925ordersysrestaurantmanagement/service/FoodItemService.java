package org.example._20240925ordersysrestaurantmanagement.service;

import org.example._20240925ordersysrestaurantmanagement.model.FoodItem;
import org.example._20240925ordersysrestaurantmanagement.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodItem getFoodItemById(Long id) {
        return foodItemRepository.findById(id).orElse(null);
    }

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public FoodItem updateFoodItem(Long id, FoodItem foodItemDetails) {
        FoodItem foodItem = foodItemRepository.findById(id).orElse(null);
        if (foodItem != null) {
            foodItem.setFoodName(foodItemDetails.getFoodName());
            foodItem.setFoodPrice(foodItemDetails.getFoodPrice());
            foodItem.setFoodStatus(foodItemDetails.getFoodStatus());
            foodItem.setFoodImage(foodItemDetails.getFoodImage());
            foodItem.setFoodCategory(foodItemDetails.getFoodCategory());
            return foodItemRepository.save(foodItem);
        }
        return null;
    }

    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }
}