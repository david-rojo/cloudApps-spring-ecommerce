package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.Optional;

import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.ShoppingCartDto;

public interface ShoppingCartUseCase {

	public NewShoppingCartDto createShoppingCart();

	public ShoppingCartDto complete(Long id);
	
	public Optional<ShoppingCartDto> findShoppingCartById(Long id);
}
