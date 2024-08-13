package com.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
 
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	
	private String city;
	private String state;
	private String zipCode;
	
	@Column(length=200)
 private String addressdetails;
	private String mobile;
	
	
	//we can put user so to track its previous order or saved address;
	
	@OneToOne(mappedBy="address")
	@JsonIgnore
	private Orderss order;
	
}
