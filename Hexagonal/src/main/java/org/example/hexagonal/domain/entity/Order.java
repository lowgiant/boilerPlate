package org.example.hexagonal.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "ed_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	private String name;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "payment_id")
	private String paymentId;

	@Column(name = "total_price")
	private int totalPrice;

	protected Order() {
	}

	@Builder
	public Order(String name, String phoneNumber, String paymentId, int totalPrice) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.paymentId = paymentId;
		this.totalPrice = totalPrice;
	}
}
