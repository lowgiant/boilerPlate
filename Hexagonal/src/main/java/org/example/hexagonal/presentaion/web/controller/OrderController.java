package org.example.hexagonal.presentaion.web.controller;

import org.example.hexagonal.presentaion.port.in.CreateNewOrderUseCase;
import org.example.hexagonal.presentaion.port.in.GetOrderInfoUseCase;
import org.example.hexagonal.presentaion.web.request.NewOrderRequest;
import org.example.hexagonal.presentaion.web.response.NewPurchaseOrderMessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

	private final CreateNewOrderUseCase createNewOrderUseCase;
	private final GetOrderInfoUseCase getOrderInfoUseCase;

	@PostMapping()
	public NewPurchaseOrderMessageResponse newOrder(@RequestBody @Valid NewOrderRequest newOrder) throws Exception {
		return NewPurchaseOrderMessageResponse.from(createNewOrderUseCase.createOrder(newOrder));
	}



}
