package org.example.hexagonal.presentaion.web.response;

import org.example.hexagonal.domain.entity.Order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NewPurchaseOrderMessageResponse {
	private Long orderId;
	private String name;
	private String phoneNumber;
	private String paymentId;
	private int totalPrice;

	@Builder
	public NewPurchaseOrderMessageResponse(Long orderId, String name,
		String phoneNumber, String paymentId, int totalPrice) {
		this.orderId = orderId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.paymentId = paymentId;
		this.totalPrice = totalPrice;
	}

	public static NewPurchaseOrderMessageResponse from(Order order) {
		return NewPurchaseOrderMessageResponse.builder()
			.orderId(order.getOrderId())
			.name(order.getName())
			.phoneNumber(order.getPhoneNumber())
			.paymentId(order.getPaymentId())
			.totalPrice(order.getTotalPrice())
			.build();
	}
}
