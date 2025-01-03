package org.example.hexagonal.presentaion.port.in;

import org.example.hexagonal.domain.entity.Order;
import org.example.hexagonal.presentaion.web.request.NewOrderRequest;

public interface CreateNewOrderUseCase {
	Order createOrder(NewOrderRequest newOrder) throws Exception;
}
