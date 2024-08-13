package com.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RequestOrder {

	private User user;
	private List<OrderItem> orderitem = new ArrayList<>();
 private	Address address;
}
