package org.example.hexagonal.presentaion.port.in;

import org.example.hexagonal.domain.entity.Order;

public interface GetOrderInfoUseCase {
	Order getOrderInfo(String orderId);
}
