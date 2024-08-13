package com.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private int price;
	private int discountedPrice;
	private int discountPercent;
	private int quantity;
	

	
	
	@ManyToOne
private CourseCategory setCategoryForCourseProduct;
	
	@OneToMany(mappedBy="products")
	@JsonIgnore
	private List<OrderItem> orderitem = new ArrayList<>();

}
