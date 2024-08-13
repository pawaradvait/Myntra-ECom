package com.ecommerce.Service;

import com.ecommerce.entity.Orderss;
import com.ecommerce.entity.RequestOrder;

public interface OrderService {

	Orderss addOrder(RequestOrder order);
	
}
