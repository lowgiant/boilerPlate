package org.example.hexagonal.presentaion.web.request;

import java.util.UUID;

import org.example.hexagonal.domain.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewOrderRequest {
	private String name;
	private String phoneNumber;
	private String paymentId;
	private int totalPrice;

	public Order toEntity() {
		return Order.builder()
			.name(name)
			.phoneNumber(phoneNumber)
			.paymentId(paymentId)
			.totalPrice(totalPrice)
			.build();
	}
}
