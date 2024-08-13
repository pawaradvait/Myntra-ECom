package com.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Repo.CourseCategoryRepo;
import com.ecommerce.Service.CourseCategoryService;
import com.ecommerce.entity.CourseCategory;

@RestController
@RequestMapping("/course-category")
@CrossOrigin("*")
public class CourseCategoryController {

	@Autowired
	private CourseCategoryService  ccs;
	
	@Autowired
	private CourseCategoryRepo ccr;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory(){
		
		List<CourseCategory> getall =  this.ccs.getAllCategories();
		if(getall !=null) {
			return new ResponseEntity<>(getall,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/level/{lvl}")
	public ResponseEntity<?> getCatByLevel(@PathVariable String lvl){
		List<CourseCategory> getByLevel = this.ccs.getAllCatOfLevel1(lvl);
		if(getByLevel !=null) {
			return new ResponseEntity<>(getByLevel,HttpStatus.OK);

		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	@GetMapping("/main/{name}")
	public ResponseEntity<?> getThirdLevelCatByNameOfLevle1(@PathVariable String name){
		
		return ResponseEntity.ok(this.ccr.findCategoryByNameMain(name));
	}
}
