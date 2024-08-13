package com.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ecommerce.Repo.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orderss {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 private UUID OrdertrackingNumber;
	 @ManyToOne
	 private User user;
	 
	 
	 @OneToOne
	 private Address address;
	 
	 @OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	 @JsonIgnore
	 private List<OrderItem> product = new ArrayList<>();

	  @Enumerated(EnumType.STRING)
 public OrderStatus statusOfOrder;
}
