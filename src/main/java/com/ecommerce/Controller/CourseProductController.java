package com.ecommerce.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Repo.CourseCategoryRepo;
import com.ecommerce.Repo.CourseProductRepo;
import com.ecommerce.Service.CourseProductService;
import com.ecommerce.entity.CourseProduct;
import com.ecommerce.entity.CoursesFromUser;
import com.ecommerce.entity.MinMaxPrice;
import com.ecommerce.entity.StartEndCount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseProductController {

	@Autowired
	private CourseProductService courseproductService;
	
	
	@Autowired
	private CourseProductRepo cpr;
	
	@PostMapping("/")
        public  ResponseEntity<?> addCourseProduct(@RequestBody CoursesFromUser cu){
		
		return ResponseEntity.ok(this.courseproductService.addCourseProduct(cu));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllProduct(){
		List<CourseProduct> cp = this.courseproductService.getAllCourse();
	    
		if(cp !=null) {
			return ResponseEntity.ok(cp);
		}else {
			return new ResponseEntity<>("notfound",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/{parentname}")
	public ResponseEntity<?> getProductByCategoryName(@PathVariable String parentname){
		
		return ResponseEntity.ok(this.cpr.findProductByName(parentname));
	}
	
	
	@GetMapping("/current/{category}")
	public ResponseEntity<?> findProductByCurrentCategory(@PathVariable String category){
		return ResponseEntity.ok(this.cpr.findProductByCurrentName(category));
	}
	
	@GetMapping("/brandfilter/{category}")
	public ResponseEntity<?> getlistofBrandfilter(@PathVariable String category){
		return ResponseEntity.ok(this.cpr.tester(category));
	}

	@GetMapping("/price-filter/{name}/{price}")
	public ResponseEntity<?> getrangeofPriceswithcatnamegivesProduct(@PathVariable String name,@PathVariable String price) throws JsonMappingException, JsonProcessingException, UnsupportedEncodingException{
		  ObjectMapper objectMapper = new ObjectMapper();
		    List<StartEndCount> ranges = objectMapper.readValue(
		        URLDecoder.decode(price, "UTF-8"), 
		        new TypeReference<List<StartEndCount>>() {}
		    );
		    List<CourseProduct> allProducts = new ArrayList<>();

		    // Loop through each range and get products
		    for (StartEndCount range : ranges) {
		        List<CourseProduct> products = this.cpr.getproductByPirceFilter(name, range.getStart(), range.getEnd());
		        allProducts.addAll(products); // Add the products from this range to the final list
		    }

		    // Return the combined list of products
		    return ResponseEntity.ok(allProducts);
	}
	
	@GetMapping("/tt/{name}/{titles}")
	public ResponseEntity<?> gettester(@PathVariable String titles,@PathVariable String name){
		  List<String> tt = Arrays.asList(titles.split(","));
		List<List<CourseProduct>> pp = new ArrayList<>()  ;
		for(int i=0;i<tt.size();i++) {
			pp.add(this.cpr.findProductByTitle(tt.get(i),name));
		}
		 List<CourseProduct> singleList = new ArrayList<>();

		    // Loop through pp and add all CourseProduct objects to singleList
		    for (List<CourseProduct> sublist : pp) {
 
		     for(CourseProduct c : sublist) {
		    	 singleList.add(c);
		     }
		    }
		return ResponseEntity.ok(singleList);
	}
	
	@GetMapping("/min-max/{name}")
	public ResponseEntity<?> getMinMax(@PathVariable String name){

		MinMaxPrice mm = this.cpr.getMinMaxPrice();
	int mid =	(mm.getMin() + mm.getMax()) /2;
	int mid1 = (mm.getMin() + mid) /2;
	int mid2 = (mid1 + mm.getMax())/2;
	//start -mid1--mid -- mid2 -- end;
	
	List<StartEndCount> sec = new ArrayList<>();
	StartEndCount ss1 = new StartEndCount();
	ss1.setStart(mm.getMin());
	ss1.setEnd(mid1);
	sec.add(ss1);
	
	StartEndCount ss2 = new StartEndCount();

	ss2.setStart(mid1+1);
	ss2.setEnd(mid);
	
	sec.add(ss2);
	
	StartEndCount ss3 = new StartEndCount();
 
	ss3.setStart(mid+1);
	ss3.setEnd(mid2);
	sec.add(ss3);
	
	StartEndCount ss4= new StartEndCount();
 
	ss4.setStart(mid2+1);
	ss4.setEnd(mm.getMax());
	sec.add(ss4);
	
	for(int i=0;i<sec.size();i++) {
		
		sec.get(i).setCount(this.cpr.getjustCountOfRange(name,sec.get(i).getStart(), sec.get(i).getEnd()));
	}
		
	
	return ResponseEntity.ok(sec);

	}
	
	
	@GetMapping("/total-filter/{name}/{price}/{titles}")
	public ResponseEntity<?> gettotalFilter(@PathVariable String name,@PathVariable String price,@PathVariable String titles) throws JsonMappingException, JsonProcessingException, UnsupportedEncodingException{
		  List<String> tt = Arrays.asList(titles.split(","));
		  ObjectMapper objectMapper = new ObjectMapper();
		    List<StartEndCount> ranges = objectMapper.readValue(
		        URLDecoder.decode(price, "UTF-8"), 
		        new TypeReference<List<StartEndCount>>() {}
		    );
			List<List<CourseProduct>> pp = new ArrayList<>()  ;
		
			for(int i=0;i<tt.size();i++) {
				
				for(int j = 0;j<ranges.size();j++) {
					pp.add(this.cpr.gettotalFilter(name, ranges.get(j).getStart(), ranges.get(j).getEnd(), tt.get(i)));
				}
			}
			
			 List<CourseProduct> singleList = new ArrayList<>();

			    // Loop through pp and add all CourseProduct objects to singleList
			    for (List<CourseProduct> sublist : pp) {
	 
			     for(CourseProduct c : sublist) {
			    	 singleList.add(c);
			     }
			    }
			
			return ResponseEntity.ok(singleList);
			
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getPorductById(@PathVariable Long id){
		return ResponseEntity.ok(this.cpr.findById(id));
	}
	
}
