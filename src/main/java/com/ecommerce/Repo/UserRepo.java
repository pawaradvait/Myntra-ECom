package com.ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	@Query("select u from User u where u.username = :username")
	User findByUsername(String username);

	@Query("select u from User u where u.email = :email")
	User findByEmail(String email);
}
