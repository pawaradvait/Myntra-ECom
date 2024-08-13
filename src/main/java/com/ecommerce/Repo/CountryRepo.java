package com.ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer>{

}
