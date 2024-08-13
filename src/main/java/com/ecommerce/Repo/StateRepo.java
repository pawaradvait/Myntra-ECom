package com.ecommerce.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.State;

public interface StateRepo extends JpaRepository<State, Integer>{
 
	@Query("select s from State s where s.countryid.id = :id")
	List<State> findStateByCountryId(int id); 
	
	
}
