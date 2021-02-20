package com.cloudapps.ecommerce.controller.dto.cartitem;

import com.cloudapps.ecommerce.controller.dto.product.ProductResponseDto;

public class CartItemResponseDto {

	private Long id;
	
	private int quantity;
	
	private ProductResponseDto product;

	public CartItemResponseDto() {}
	
	public CartItemResponseDto(Long id, int quantity, ProductResponseDto product) {
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

	public ProductResponseDto getProduct() {
		return product;
	}

	public void setProduct(ProductResponseDto product) {
		this.product = product;
	}
}
