package com.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.sqm.CastType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String code;
	private String name;

	@OneToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	List<State> states = new ArrayList<>();
 
}
