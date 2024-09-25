package org.example._20240925ordersysrestaurantmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "menus")
@Data
public class Menu {
    @Id
    @Column(name = "menu_id")
    private String menuId;

    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_describe")
    private String menuDescribe;

    @Column(name = "menu_status")
    private String menuStatus;

    @Column(name = "menu_image")
    private String menuImage;
}