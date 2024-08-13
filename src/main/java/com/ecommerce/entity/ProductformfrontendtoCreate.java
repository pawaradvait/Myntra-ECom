package com.ecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductformfrontendtoCreate {
	private Long id;
	private String title;
	private String description;
	private int price;
	private int discountedPrice;
	private int discountPercent;
	private int quantity;
	private String brand;
	private String color;

	

	private Set<Size> sizes = new HashSet<>();
	private String images;
	
	private String toplevelCategory;
	private String secondlevelCategory;
	private String thirdlevelCategory;

}
