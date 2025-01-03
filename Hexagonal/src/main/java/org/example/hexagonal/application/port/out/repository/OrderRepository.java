package org.example.hexagonal.application.port.out.repository;

import org.example.hexagonal.domain.entity.Order;

public interface OrderRepository {
	Order findById(String id);
	Order save(Order newOrder);
}
