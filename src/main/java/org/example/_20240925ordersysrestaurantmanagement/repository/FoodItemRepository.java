package org.example._20240925ordersysrestaurantmanagement.repository;

import org.example._20240925ordersysrestaurantmanagement.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}