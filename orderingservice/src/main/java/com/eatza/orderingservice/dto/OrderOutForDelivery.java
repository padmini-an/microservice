package com.eatza.orderingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class OrderOutForDelivery {
	

	private Long id;
	private Long customerId;
	private String status;
	private Long restaurantId;

	
	

}
