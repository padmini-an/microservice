package com.eatza.orderingservice.service.orderservice;

import java.util.Optional;

import com.eatza.orderingservice.dto.OrderRequestDto;
import com.eatza.orderingservice.dto.OrderUpdateDto;
import com.eatza.orderingservice.dto.OrderUpdateResponseDto;
import com.eatza.orderingservice.exception.OrderException;
import com.eatza.orderingservice.model.Order;

public interface OrderService  {
	
	Order placeOrder(OrderRequestDto orderRequest) throws OrderException;
	boolean cancelOrder(Long orderId);
	Optional<Order> getOrderById(Long id);
	double getOrderAmountByOrderId(Long id);
	OrderUpdateResponseDto updateOrder(OrderUpdateDto orderUpdateRequest) throws OrderException;

}
