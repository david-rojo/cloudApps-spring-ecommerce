package com.cloudapps.ecommerce.controller.dto.shoppingcart;

import java.util.List;

import com.cloudapps.ecommerce.controller.dto.cartitem.CartItemResponseDto;

public class ShoppingCartResponseDto {
	
	private Long id;
	
	private boolean completed;
	
	private List<CartItemResponseDto> cartItems;
	
	public ShoppingCartResponseDto() {}

	public ShoppingCartResponseDto(Long id, boolean completed, List<CartItemResponseDto> cartItems) {
		this.id = id;
		this.completed = completed;
		this.cartItems = cartItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public List<CartItemResponseDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemResponseDto> cartItems) {
		this.cartItems = cartItems;
	}

}
