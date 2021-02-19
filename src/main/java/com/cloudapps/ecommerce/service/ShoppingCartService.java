package com.cloudapps.ecommerce.service;

import org.springframework.stereotype.Service;

import com.cloudapps.ecommerce.domain.shoppingcart.ShoppingCartUseCase;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

@Service
public class ShoppingCartService {

	private ShoppingCartUseCase shoppingCartUseCase;

	public ShoppingCartService(ShoppingCartUseCase shoppingCartUseCase) {
		this.shoppingCartUseCase = shoppingCartUseCase;
	}
	
	public NewShoppingCartDto create() {
		
		return shoppingCartUseCase.createShoppingCart();
	}
}
