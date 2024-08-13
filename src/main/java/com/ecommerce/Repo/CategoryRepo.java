package com.ecommerce.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.CourseCategory;

public interface CategoryRepo extends JpaRepository<Category, Long>{

	Category findByName(String name);

	@Query("select c from Category c where c.name= :name and c.parentCategory.name = :pc")
	Category findByNameAndParent(String name, String pc);
	

}
