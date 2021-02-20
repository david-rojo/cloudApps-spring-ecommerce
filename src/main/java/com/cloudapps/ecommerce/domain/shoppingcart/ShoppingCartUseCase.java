package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.Optional;

import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

public interface ShoppingCartUseCase {

	public NewShoppingCartDto createShoppingCart();

	public FullShoppingCartDto complete(Long id);
	
	public Optional<FullShoppingCartDto> findShoppingCartById(Long id);
}
