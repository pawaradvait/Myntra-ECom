package com.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursesFromUser {
	
	private Long id;
	private String title;
	private String description;
	private int price;
	private int discountedPrice;
	private int discountPercent;
	private int quantity;




	
	private String toplevelCategory;
	private String secondlevelCategory;
	private String thirdlevelCategory;


	
}
