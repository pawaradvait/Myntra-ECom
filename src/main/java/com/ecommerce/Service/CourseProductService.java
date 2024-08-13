package com.ecommerce.Service;

import java.util.List;

import com.ecommerce.entity.CourseProduct;
import com.ecommerce.entity.CoursesFromUser;

public interface CourseProductService {

	CourseProduct addCourseProduct(CoursesFromUser courses);
	 
	List<CourseProduct> getAllCourse(); 
	
}
