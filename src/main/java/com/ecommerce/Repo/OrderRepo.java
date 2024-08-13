package com.ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Orderss;

public interface OrderRepo  extends JpaRepository<Orderss, Long>{

}
