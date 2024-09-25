package org.example._20240925ordersysrestaurantmanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "food_items")
@Data
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "items_id")
    private String itemsId;

    @Column(name = "menu_id")
    private String menuId;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_price")
    private BigDecimal foodPrice;

    @Column(name = "food_status")
    private String foodStatus;

    @Column(name = "food_image")
    private String foodImage;

    @Column(name = "food_category")
    private String foodCategory;
}