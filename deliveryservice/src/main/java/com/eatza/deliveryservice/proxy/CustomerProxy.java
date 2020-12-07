package com.eatza.deliveryservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eatza.deliveryservice.dto.CustomerDto;

@FeignClient(name="customerservice")
public interface CustomerProxy {
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable long customerId);

}
