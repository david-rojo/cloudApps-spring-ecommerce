package com.cloudapps.ecommerce.domain.cartitem.dto;

import com.cloudapps.ecommerce.domain.product.dto.ProductDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.ShoppingCartDto;

public class CartItemDto {
	
	private int quantity;
	
	private ProductDto product;

	private ShoppingCartDto shoppingCart;
	
	public CartItemDto() {}
	
	public CartItemDto(Long id, int quantity, ProductDto product, ShoppingCartDto shoppingCart) {
		this.quantity = quantity;
		this.product = product;
		this.shoppingCart = shoppingCart;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public ShoppingCartDto getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartDto shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
}
