package com.cloudapps.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cloudapps.ecommerce.controller.dto.shoppingcart.ShoppingCartResponseDto;
import com.cloudapps.ecommerce.domain.shoppingcart.ShoppingCartUseCase;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.ShoppingCartDto;

@Service
public class ShoppingCartService {

	private ShoppingCartUseCase shoppingCartUseCase;

	public ShoppingCartService(ShoppingCartUseCase shoppingCartUseCase) {
		this.shoppingCartUseCase = shoppingCartUseCase;
	}
	
	public NewShoppingCartDto create() {
		
		return shoppingCartUseCase.createShoppingCart();
	}
	
	public ShoppingCartDto complete(Long id) {
		
		return shoppingCartUseCase.complete(id);
	}

	public Optional<ShoppingCartResponseDto> findById(Long id) {
		return shoppingCartUseCase.findShoppingCartById(id).map(ShoppingCartResponseDto::fromShoppingCartDto);
	}
}
