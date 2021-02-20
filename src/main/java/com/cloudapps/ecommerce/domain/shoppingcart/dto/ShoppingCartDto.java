package com.cloudapps.ecommerce.domain.shoppingcart.dto;

import java.util.List;

import com.cloudapps.ecommerce.domain.cartitem.dto.CartItemDto;

public class ShoppingCartDto {
	
	private boolean completed;
	
	private List<CartItemDto> cartItems;
	
	public ShoppingCartDto() {}

	public ShoppingCartDto(boolean completed, List<CartItemDto> cartItems) {
		this.completed = completed;
		this.cartItems = cartItems;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public List<CartItemDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}

}
