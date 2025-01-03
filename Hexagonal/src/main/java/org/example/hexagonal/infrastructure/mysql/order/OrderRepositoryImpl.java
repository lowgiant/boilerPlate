package org.example.hexagonal.infrastructure.mysql.order;

import java.util.NoSuchElementException;

import org.example.hexagonal.application.port.out.repository.OrderRepository;
import org.example.hexagonal.domain.entity.Order;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

	private final OrderJpaRepository orderJpaRepository;

	@Override
	public Order findById(String id) {
		return orderJpaRepository
			.findById(id)
			.orElseThrow(() -> new NoSuchElementException("OrderId not found"));
	}

	@Override
	public Order save(Order newOrder) {
		return orderJpaRepository.save(newOrder);
	}

}
