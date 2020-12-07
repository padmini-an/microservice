package com.eatza.restaurantsearchservice.service.menuitemservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eatza.restaurantsearchservice.dto.ItemRequestDto;
import com.eatza.restaurantsearchservice.exception.ItemNotFoundException;
import com.eatza.restaurantsearchservice.model.MenuItem;
import com.eatza.restaurantsearchservice.model.Restaurant;


public interface MenuItemService {
	
	MenuItem saveMenuItem(ItemRequestDto itemDto);
	List<Restaurant> findByName(String name, int pagenumber, int pagesize) throws  ItemNotFoundException ;
	Optional<MenuItem> findById(Long id);
	Page<MenuItem> findByMenuId(Long id , Pageable pageable);

}
