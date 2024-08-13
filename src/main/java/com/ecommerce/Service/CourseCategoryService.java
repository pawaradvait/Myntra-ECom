package com.ecommerce.Service;

import java.util.List;

import com.ecommerce.entity.CourseCategory;

public interface CourseCategoryService {

	List<CourseCategory> getAllCategories();
	
	List<CourseCategory> getAllCatOfLevel1(String level);
	
}
