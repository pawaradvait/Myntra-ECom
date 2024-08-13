package com.ecommerce.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.CourseProduct;
import com.ecommerce.entity.MinMaxPrice;
import com.ecommerce.entity.ProductFilter;

public interface CourseProductRepo extends JpaRepository<CourseProduct, Long>{
 
	@Query("select c from CourseProduct c where c.setCategoryForCourseProduct.parentCourseCategory.name = :name")
	List<CourseProduct> findProductByName(String name);
	
	@Query("select c from CourseProduct c where c.setCategoryForCourseProduct.name =:name")
	List<CourseProduct> findProductByCurrentName(String name);
	
	@Query("SELECT     new com.ecommerce.entity.ProductFilter(c.title , COUNT(c))  FROM CourseProduct c where setCategoryForCourseProduct.name = :name GROUP BY c.title")
	List<ProductFilter> tester(String name);

	@Query("select c from CourseProduct c where c.setCategoryForCourseProduct.name = :name and c.title =:title")
	List<CourseProduct> findProductByTitle(String title,String name);

	
	@Query("select   new  com.ecommerce.entity.MinMaxPrice(min(price) , max(price)) from CourseProduct")
	MinMaxPrice getMinMaxPrice();
	
	
	@Query("select count(*) from CourseProduct c where c.setCategoryForCourseProduct.name = :name and c.price >= :start and c.price <= :end ")
	int getjustCountOfRange(String name,int start,int end);


 
	@Query("select c from CourseProduct c where c.setCategoryForCourseProduct.name = :name and c.price >= :start and c.price <= :end")
	List<CourseProduct> getproductByPirceFilter(String name,int start,int end);
	

	
	@Query("select c from CourseProduct c where c.setCategoryForCourseProduct.name = :name and c.price >= :start and c.price <= :end and c.title = :title ")
	List<CourseProduct> gettotalFilter(String name,int start,int end,String title);
}
