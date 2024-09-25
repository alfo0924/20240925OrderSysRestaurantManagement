package org.example._20240925ordersysrestaurantmanagement.repository;

import org.example._20240925ordersysrestaurantmanagement.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {
}