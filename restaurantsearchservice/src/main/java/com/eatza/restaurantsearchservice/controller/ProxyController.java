//package com.eatza.restaurantsearch.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.eatza.restaurantsearch.exception.RestaurantNotVerifiedException;
//import com.eatza.restaurantsearch.model.Restaurant;
//import com.eatza.restaurantsearch.service.restaurantservice.RestaurantService;
//@RestController
//public class ProxyController {
//	
//	@Autowired
//	RestaurantService restaurantService;
//	
//	@GetMapping("/restaurant/getRestaurant/{restaurantId}")
//	public Restaurant verifyRestaurant(@RequestHeader String authorization,@PathVariable Long restaurantId) throws RestaurantNotVerifiedException {
//		return restaurantService.VerifyRestaurant(restaurantId);
//	}
//
//}
