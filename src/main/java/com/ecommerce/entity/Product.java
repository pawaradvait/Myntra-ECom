package com.ecommerce.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
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
public class Product { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private String price;
	private String discountedPrice;
	private String discountPercent;
	private String quantity;
	private String brand;
	private String color;
	
	@Embedded
	@ElementCollection

	private Set<Size> sizes = new HashSet<>();
	private String images;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="rating")
		private List<Rating> rating = new ArrayList<>();
  
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="review")
private List<Review> review = new ArrayList<>();
  
	private int numRatings;
   
	@ManyToOne
	private Category category;
	
	private LocalDateTime createdat;

}
