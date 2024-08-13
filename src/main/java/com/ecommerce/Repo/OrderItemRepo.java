package com.ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long>{

}
