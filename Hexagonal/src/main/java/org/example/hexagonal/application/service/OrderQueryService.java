package org.example.hexagonal.application.service;

import org.example.hexagonal.application.port.out.repository.OrderRepository;
import org.example.hexagonal.domain.entity.Order;
import org.example.hexagonal.presentaion.port.in.GetOrderInfoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class OrderQueryService implements GetOrderInfoUseCase {

	private final OrderRepository orderRepository;

	@Override
	public Order getOrderInfo(String orderId) {
		return orderRepository.findById(orderId);
	}
}
