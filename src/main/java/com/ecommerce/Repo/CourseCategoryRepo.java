package com.ecommerce.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.CourseCategory;

public interface CourseCategoryRepo extends JpaRepository<CourseCategory, Long>{

	@Query("select c from CourseCategory c where c.name = :toplevel")
	CourseCategory findByName(String toplevel);

	@Query("select c from CourseCategory c where c.name= :secondLevel and c.parentCourseCategory.name = :toplevel")
	CourseCategory findByNameAndParent(String secondLevel, String toplevel);

	@Query("select  c from CourseCategory c where c.level = :level")
	List<CourseCategory> findByLevel(String level);
	

	@Query("select c from CourseCategory c where c.level = 3 and c.parentCourseCategory.parentCourseCategory.name =:name")
	List<CourseCategory> findCategoryByNameMain(String name);
}
