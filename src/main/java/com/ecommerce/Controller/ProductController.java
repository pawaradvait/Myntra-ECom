package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Service.ProductService;
import com.ecommerce.entity.ProductformfrontendtoCreate;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<?> addProduct(@RequestBody ProductformfrontendtoCreate product){
		
		return ResponseEntity.ok(productService.createProduct(product));
		
	}
	@GetMapping("/{category}")
	public ResponseEntity<?> getallfilter(@PathVariable String category){
		return ResponseEntity.ok(productService.getallaproductbycategory(category));
	}
	
}
