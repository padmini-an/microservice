package com.eatza.orderingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DeliveryRequestDto {

	private Long customerId;
	private Long restaurantId;
	private String status;
}
