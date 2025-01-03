package org.example.hexagonal.application.service;

import org.example.hexagonal.application.port.out.repository.OrderRepository;
import org.example.hexagonal.domain.entity.Order;
import org.example.hexagonal.presentaion.port.in.CreateNewOrderUseCase;
import org.example.hexagonal.presentaion.web.request.NewOrderRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderCommandService  implements CreateNewOrderUseCase {

		private final OrderRepository orderRepository;

		@Override
		public Order createOrder(NewOrderRequest newOrder) throws Exception {
			return orderRepository.save(newOrder.toEntity());
		}
}
