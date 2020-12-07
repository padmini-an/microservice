package com.eatza.restaurantsearchservice.service.restaurantservice;

import java.util.List;

import com.eatza.restaurantsearchservice.dto.RestaurantRequestDto;
import com.eatza.restaurantsearchservice.dto.RestaurantResponseDto;
import com.eatza.restaurantsearchservice.model.MenuItem;
import com.eatza.restaurantsearchservice.model.Restaurant;

public interface RestaurantService {
	
	RestaurantResponseDto findAllRestaurants(int pageNumber, int pageSize);
	Restaurant saveRestaurant(RestaurantRequestDto restaurant);
	
	RestaurantResponseDto findByName(String name, int pageNumber, int pageSize);
	RestaurantResponseDto findByLocationAndCuisine(String location, String cuisine, int pageNumber, int pageSize);
	RestaurantResponseDto findByBudget(int budget, int pageNumber, int pageSize);
	RestaurantResponseDto findByLocationAndName(String location, String name, int pageNumber, int pageSize);
	RestaurantResponseDto findByRating(double rating,int pageNumber, int pageSize);
	Restaurant findById(Long id)  ;
	List<MenuItem> findMenuItemByRestaurantId(Long restaurantId, int pageNumber, int pageSize);
//	public Restaurant VerifyRestaurant(Long restaurantId)throws RestaurantNotVerifiedException;
}
