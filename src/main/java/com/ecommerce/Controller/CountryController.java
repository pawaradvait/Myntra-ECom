package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Repo.CountryRepo;
import com.ecommerce.Repo.StateRepo;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
public class CountryController {

	@Autowired
	private CountryRepo cr;
	
	@Autowired
	private StateRepo sr;

	@GetMapping("/")
 public ResponseEntity<?> getAllCountry(){
	 
		return ResponseEntity.ok(this.cr.findAll());
 }
	
	@GetMapping("/states/{id}")
	public ResponseEntity<?> getStatesByCountryid(@PathVariable int id){
		return ResponseEntity.ok(this.sr.findStateByCountryId(id));
		
	}
}
