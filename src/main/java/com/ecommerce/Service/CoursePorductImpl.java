package com.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Repo.CourseCategoryRepo;
import com.ecommerce.Repo.CourseProductRepo;
import com.ecommerce.entity.CourseCategory;
import com.ecommerce.entity.CourseProduct;
import com.ecommerce.entity.CoursesFromUser;

@Service
public class CoursePorductImpl implements CourseProductService{

	@Autowired
	private CourseCategoryRepo courseCtageory;
	
	@Autowired
	private CourseProductRepo courseProduct;
	
	@Override
	public CourseProduct addCourseProduct(CoursesFromUser courses) {
		
		//find top level
		String toplevel = courses.getToplevelCategory();
	CourseCategory toplevelCat  =	this.courseCtageory.findByName(toplevel);
	
		if(toplevelCat == null) {
	      toplevelCat = new CourseCategory();
			toplevelCat.setLevel(1);
			toplevelCat.setName(toplevel);
			this.courseCtageory.save(toplevelCat);
		}
		
		String secondLevel = courses.getSecondlevelCategory();
		CourseCategory secondLevelcat = this.courseCtageory.findByNameAndParent(secondLevel,toplevel);
		if(secondLevelcat ==null) {
			secondLevelcat = new CourseCategory();
			secondLevelcat.setLevel(2);
			secondLevelcat.setName(secondLevel);
			
			secondLevelcat.setParentCourseCategory(toplevelCat);
			this.courseCtageory.save(secondLevelcat);
					}
		
		String thirdLevel = courses.getThirdlevelCategory();
		CourseCategory thirdlevlecat = this.courseCtageory.findByNameAndParent(thirdLevel, secondLevel);
		if(thirdlevlecat == null) {
			thirdlevlecat = new CourseCategory();
			thirdlevlecat.setLevel(3);
			thirdlevlecat.setName(thirdLevel);
           thirdlevlecat.setParentCourseCategory(secondLevelcat);
           this.courseCtageory.save(thirdlevlecat);
		}
		
		CourseProduct cp = new CourseProduct();
		cp.setTitle(courses.getTitle());
		cp.setSetCategoryForCourseProduct(thirdlevlecat);
		cp.setPrice(courses.getPrice());
		
		this.courseProduct.save(cp);
		
		
		
		return null;
	}

	@Override
	public List<CourseProduct> getAllCourse() {
		// TODO Auto-generated method stub
		return this.courseProduct.findAll();
	}

	
}
