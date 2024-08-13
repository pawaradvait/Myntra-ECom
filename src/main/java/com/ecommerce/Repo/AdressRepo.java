package com.ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Address;

public interface AdressRepo extends JpaRepository<Address, Long>{

}
