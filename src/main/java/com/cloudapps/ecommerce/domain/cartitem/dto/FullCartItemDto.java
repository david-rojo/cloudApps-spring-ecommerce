package com.cloudapps.ecommerce.domain.cartitem.dto;

import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;

public class FullCartItemDto {

	private Long id;
	
	private int quantity;
	
	private FullProductDto product;
	
	private FullShoppingCartDto shoppingCart;

	public FullCartItemDto() {}
	
	public FullCartItemDto(int quantity, FullProductDto product, FullShoppingCartDto shoppingCart) {
		this(null, quantity, product, shoppingCart);
	}
	
	public FullCartItemDto(Long id, int quantity, FullProductDto product, FullShoppingCartDto shoppingCart) {
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public FullProductDto getProduct() {
		return product;
	}

	public void setProduct(FullProductDto product) {
		this.product = product;
	}

	public FullShoppingCartDto getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(FullShoppingCartDto shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
}
