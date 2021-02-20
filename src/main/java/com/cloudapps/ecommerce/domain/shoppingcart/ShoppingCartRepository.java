package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.Optional;

import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.ShoppingCartDto;

public interface ShoppingCartRepository {

	public NewShoppingCartDto create();
	
	public Optional<ShoppingCartDto> findShoppingCartById(Long id);
	
	public ShoppingCartDto save(ShoppingCartDto shoppingCartDto);	
	
}
