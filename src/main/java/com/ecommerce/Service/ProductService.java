package com.ecommerce.Service;

import java.util.List;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductformfrontendtoCreate;

public interface ProductService {

	Product createProduct(ProductformfrontendtoCreate product);
	Product findProductById(Long id);
	List<Product> getallaproduct(String stock,String category,int minprice,List<String> color,List<String> sizes,
			int maxprice ,int mindiscount , String sort, int pagenumber ,int pagesize);
	List<Product> getallaproductbycategory(String category);
}
