package com.cloudapps.ecommerce.domain.shoppingcart;

import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {

	private ShoppingCartRepository shoppingCartRepository;
	
	public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository) {
		this.shoppingCartRepository = shoppingCartRepository;
	}
	
	@Override
	public NewShoppingCartDto createShoppingCart() {
		return shoppingCartRepository.save();
	}

}
