package com.cloudapps.ecommerce.domain.shoppingcart.dto;

import java.util.List;
import java.util.Optional;

import com.cloudapps.ecommerce.domain.cartitem.dto.FullCartItemDto;

public class FullShoppingCartDto {

private Long id;
	
	private boolean completed;
	
	private List<FullCartItemDto> cartItems;
	
	public FullShoppingCartDto() {}

	public FullShoppingCartDto(Long id, boolean completed, List<FullCartItemDto> cartItems) {
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

	public List<FullCartItemDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<FullCartItemDto> cartItems) {
		this.cartItems = cartItems;
	}
	
	public Optional<FullCartItemDto> contains(Long productId) {
		for (FullCartItemDto cartItem : cartItems) {
			if (cartItem.getProduct().getId() == productId) {
				return Optional.of(cartItem);
			}
		}
		return Optional.empty();
	}
	
	public void addItem(FullCartItemDto cartItemDto) {
		this.cartItems.add(cartItemDto);
	}
	
	public void removeItem(FullCartItemDto cartItemDto) {
		for (FullCartItemDto item : cartItems) {
			if (item.getProduct().getId() == cartItemDto.getProduct().getId()) {
				cartItems.remove(item);
			}
		}
	}
	
	public void updateQuantity(Long cartItemId, int quantity) {
		for (int i = 0; i<cartItems.size(); i++) {
			if (cartItems.get(i).getProduct().getId() == cartItemId) {
				cartItems.get(i).setQuantity(quantity);
			}
		}
	}

}
