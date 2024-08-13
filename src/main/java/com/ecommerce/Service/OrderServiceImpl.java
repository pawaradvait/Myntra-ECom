package com.ecommerce.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.Repo.AdressRepo;
import com.ecommerce.Repo.OrderItemRepo;
import com.ecommerce.Repo.OrderRepo;
import com.ecommerce.Repo.OrderStatus;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.Orderss;
import com.ecommerce.entity.RequestOrder;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo or;
	
	@Autowired
	private OrderItemRepo oi;
	
	@Autowired
	private AdressRepo ar;
	
	@Override
	@Transactional
	public Orderss addOrder(RequestOrder order) {
		
        UUID orderId = UUID.randomUUID(); 

		List<OrderItem>orderitem = 		order.getOrderitem();
		System.out.println(orderitem.toString());
		Orderss orders = new Orderss();
		orders.setUser(order.getUser());
		orders.setOrdertrackingNumber(orderId);
		orders.setStatusOfOrder(OrderStatus.ORDERED);
		Orderss as=this.or.save(orders);
		
		Address aa = order.getAddress();
		aa.setOrder(orders);
		this.ar.save(aa);
		orders.setAddress(order.getAddress());

		for(int i=0 ; i < orderitem.size();i++) {
			  OrderItem o = orderitem.get(i);
			  System.out.println(orders.getId());
		 o.setOrder(orders);
			
			  o.setProducts(o.getProducts());

			 this.oi.save(o);
		
		}
		 return as;


	}
	
	
			
}
	


