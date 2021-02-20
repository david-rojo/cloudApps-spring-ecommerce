package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.Optional;

import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {

	private ShoppingCartRepository shoppingCartRepository;
	
	public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository) {
		this.shoppingCartRepository = shoppingCartRepository;
	}
	
	@Override
	public NewShoppingCartDto createShoppingCart() {
		return shoppingCartRepository.create();
	}

	@Override
	public FullShoppingCartDto complete(Long id) {
		
		FullShoppingCartDto shoppingCart = shoppingCartRepository.findShoppingCartById(id).orElseThrow();
		shoppingCart.setCompleted(true);
		return shoppingCartRepository.save(shoppingCart);
	}

	@Override
	public Optional<FullShoppingCartDto> findShoppingCartById(Long id) {
		return shoppingCartRepository.findShoppingCartById(id);
	}

}
