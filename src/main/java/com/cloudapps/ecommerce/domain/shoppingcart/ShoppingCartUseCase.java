package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.Optional;

import com.cloudapps.ecommerce.domain.exception.NotValidatedShoppingCartException;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

public interface ShoppingCartUseCase {

	public NewShoppingCartDto createShoppingCart();

	public Optional<FullShoppingCartDto> complete(Long id) throws NotValidatedShoppingCartException;
	
	public Optional<FullShoppingCartDto> findShoppingCartById(Long id);

	public Optional<FullShoppingCartDto> addProduct(Long shoppingCartId, Long productId, int prodQuantity);
	
	public Optional<FullShoppingCartDto> deleteProduct(Long shoppingCartId, Long productId);

	public Optional<FullShoppingCartDto> delete(Long shoppingCartId);
}
