package com.cloudapps.ecommerce.domain.shoppingcart.dto;

import java.util.List;

import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;

public class ShoppingCartDto {

	private Long id;
	
	private boolean completed;
	
	private List<FullProductDto> products;
	
	public ShoppingCartDto() {}

	public ShoppingCartDto(Long id, boolean completed, List<FullProductDto> products) {
		this.id = id;
		this.completed = completed;
		this.products = products;
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

	public List<FullProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<FullProductDto> products) {
		this.products = products;
	}

}
