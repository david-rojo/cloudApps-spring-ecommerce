package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.List;
import java.util.Optional;

import com.cloudapps.ecommerce.domain.cartitem.CartItem;

public class ShoppingCart {

private Long id;
	
	private boolean completed;
	
	private List<CartItem> cartItems;
	
	public ShoppingCart() {}

	public ShoppingCart(Long id, boolean completed, List<CartItem> cartItems) {
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

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public Optional<CartItem> contains(Long productId) {
		for (CartItem cartItem : cartItems) {
			if (cartItem.getProduct().getId() == productId) {
				return Optional.of(cartItem);
			}
		}
		return Optional.empty();
	}
	
	public void addItem(CartItem cartItem) {
		this.cartItems.add(cartItem);
	}
	
	public void removeItem(CartItem cartItem) {
		for (CartItem item : cartItems) {
			if (item.getProduct().getId() == cartItem.getProduct().getId()) {
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
