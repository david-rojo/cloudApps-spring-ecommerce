package com.cloudapps.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cloudapps.ecommerce.domain.shoppingcart.ShoppingCartUseCase;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;
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
	
	public FullShoppingCartDto complete(Long id) {
		
		return shoppingCartUseCase.complete(id);
	}

	public Optional<FullShoppingCartDto> findById(Long id) {

		return shoppingCartUseCase.findShoppingCartById(id);
	}

	public Optional<FullShoppingCartDto> addProduct(Long cartId, Long productId, int prodQuantity) {
		
		return shoppingCartUseCase.addProduct(cartId, productId, prodQuantity);
	}

	public Optional<FullShoppingCartDto> deleteProduct(Long cartId, Long productId) {
		
		return shoppingCartUseCase.deleteProduct(cartId, productId);
	}

	public void delete(Long id) {
		
		shoppingCartUseCase.delete(id);
		
	}
	
	
}
