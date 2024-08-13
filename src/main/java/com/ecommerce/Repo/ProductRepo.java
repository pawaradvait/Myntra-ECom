package com.ecommerce.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{
	@Query("SELECT p FROM Product p WHERE p.category.name = :category "
		    + "AND ((:minprice IS NULL AND :maxprice IS NULL) OR (p.discountedPrice BETWEEN :minprice AND :maxprice)) "
		    + "AND (:mindiscount IS NULL OR p.discountPercent >= :mindiscount) "
		    + "ORDER BY "
		    + "CASE WHEN :sort = 'price_low' THEN p.discountedPrice END ASC, "
		    + "CASE WHEN :sort = 'price_high' THEN p.discountedPrice END DESC")
		List<Product> filterProduct(String category, Integer minprice, Integer maxprice, Integer mindiscount, String sort);

	@Query("select  p from Product p where p.category.name =:category")
	List<Product> findByCategoryname(String category);
}
