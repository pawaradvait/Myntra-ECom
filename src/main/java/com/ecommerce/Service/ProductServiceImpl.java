package com.ecommerce.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.Repo.CategoryRepo;
import com.ecommerce.Repo.ProductRepo;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductformfrontendtoCreate;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public Product createProduct(ProductformfrontendtoCreate product) {
	    String catName = product.getToplevelCategory();
	    Category cat = categoryRepo.findByName(catName);
	    if (cat == null) {
	        cat = new Category();
	        cat.setLevel(1);
	        cat.setName(product.getToplevelCategory());
	        cat = categoryRepo.save(cat);
	    }

	    String catName2 = product.getSecondlevelCategory();
	    Category secondCat = categoryRepo.findByNameAndParent(catName2, cat.getName());
	    if (secondCat == null) {
	        secondCat = new Category();
	        secondCat.setName(catName2);
	        secondCat.setLevel(2);
	        secondCat.setParentCategory(cat);
	        secondCat = categoryRepo.save(secondCat);
	    }

	    String catName3 = product.getThirdlevelCategory();
	    Category thirdCat = categoryRepo.findByNameAndParent(catName3, secondCat.getName());
	    if (thirdCat == null) {
	        thirdCat = new Category();
	        thirdCat.setLevel(3);
	        thirdCat.setName(catName3);
	        thirdCat.setParentCategory(secondCat);
	        thirdCat = categoryRepo.save(thirdCat);
	    }

	    Product p = new Product();
	    p.setTitle(product.getTitle());
	    p.setDescription(product.getDescription());
	    p.setPrice(String.valueOf(product.getPrice()));
	    p.setDiscountedPrice(String.valueOf(product.getDiscountedPrice()));
	    p.setDiscountPercent(String.valueOf(product.getDiscountPercent()));
	    p.setQuantity(String.valueOf(product.getQuantity()));
	    p.setSizes(product.getSizes());
	    p.setCategory(thirdCat);
	    p.setCreatedat(LocalDateTime.now());
	    
	    return productRepo.save(p);
	}

	

	

	@Override
	public Product findProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}
	
	@Override
public List<Product> getallaproduct(String stock,String category, int minprice, List<String> color, List<String> sizes,
			int maxprice, int mindiscount, String sort, int pagenumber, int pagesize) {
		// TODO Auto-generated method stub

//		Pageable pageable =PageRequest.of(pagenumber, pagesize);

		List<Product> prodcut = productRepo.filterProduct(category, minprice, maxprice, mindiscount, sort);
		
		if(!color.isEmpty())
		{
			prodcut = prodcut.stream().filter(p->color.stream().anyMatch(c->c.equalsIgnoreCase(p.getColor()))).collect(Collectors.toList());
			
		}else if(stock.equals("in_stock")) {
			prodcut = prodcut.stream().filter(p->Integer.parseInt(p.getQuantity())>0).collect(Collectors.toList());
			
		}else if(stock.equals("out_of_stock")) {
			prodcut = prodcut.stream().filter(p->Integer.parseInt(p.getQuantity())<1).collect(Collectors.toList());
		}
		
		return prodcut;
	}





	@Override
	public List<Product> getallaproductbycategory(String category) {
		
	return	productRepo.findByCategoryname(category);
	
	}

}
