package com.eatza.restaurantsearchservice.service.menuservice;

import java.util.Optional;

import com.eatza.restaurantsearchservice.model.Menu;

public interface MenuService {
	
	Menu saveMenu(Menu menu);
	Optional<Menu> getMenuById(Long id);
	Menu getMenuByRestaurantId(Long id);

}
