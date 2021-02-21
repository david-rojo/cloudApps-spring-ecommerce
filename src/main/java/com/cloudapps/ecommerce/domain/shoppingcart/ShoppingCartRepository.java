package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.Optional;

import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

public interface ShoppingCartRepository {

	public NewShoppingCartDto create();
	
	public Optional<FullShoppingCartDto> findShoppingCartById(Long id);
	
	public FullShoppingCartDto save(FullShoppingCartDto shoppingCartDto);
	
	public FullShoppingCartDto delete(FullShoppingCartDto shoppingCartDto);
	
}
