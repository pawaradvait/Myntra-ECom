package com.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Repo.CourseCategoryRepo;
import com.ecommerce.entity.CourseCategory;

@Service
public class CourseCategoryImpl implements CourseCategoryService{

	@Autowired
	private CourseCategoryRepo ccr;
	
	@Override
	public List<CourseCategory> getAllCategories() {
		// TODO Auto-generated method stub
		return this.ccr.findAll();
	}

	@Override
	public List<CourseCategory> getAllCatOfLevel1(String level) {
		
		return this.ccr.findByLevel(level);
	}
	
	

}
