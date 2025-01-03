package org.example.hexagonal.infrastructure.mysql.order;

import org.example.hexagonal.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<Order, String> {
}
