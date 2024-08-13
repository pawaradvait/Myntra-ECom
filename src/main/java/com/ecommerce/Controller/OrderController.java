package com.ecommerce.Controller;

import java.util.List;import org.slf4j.helpers.ThreadLocalMapOfStacks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Repo.OrderItemRepo;
import com.ecommerce.Repo.OrderRepo;
import com.ecommerce.Service.OrderService;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.Orderss;
import com.ecommerce.entity.RequestOrder;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

	@Autowired
	private OrderService os;
	
	@PostMapping("/")
	public ResponseEntity<?> addOrderItem(@RequestBody RequestOrder order){
return ResponseEntity.ok(this.os.addOrder(order));
	
	
	}

	
}
