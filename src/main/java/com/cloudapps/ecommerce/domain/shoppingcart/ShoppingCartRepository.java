package com.cloudapps.ecommerce.domain.shoppingcart;

import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

public interface ShoppingCartRepository {

	public NewShoppingCartDto save();
	
}
