package com.ecommerce.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
   @ManyToOne
	private User user;
	@ManyToOne
	@JsonIgnore
   private Product product;
	private double rating;
	private LocalDateTime date;

	@ManyToOne
	private Category category;
	private LocalDateTime createdat;
	
  }
