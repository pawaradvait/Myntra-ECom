package com.ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Role;

public interface RolesRepo extends JpaRepository<Role, Long>{

}
