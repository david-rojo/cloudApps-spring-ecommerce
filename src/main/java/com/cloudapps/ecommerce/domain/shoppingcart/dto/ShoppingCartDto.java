package com.cloudapps.ecommerce.domain.shoppingcart.dto;

import java.util.List;

import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;

public class ShoppingCartDto {

	private Long id;
	
	private List<FullProductDto> products;
	
	public ShoppingCartDto() {}

	public ShoppingCartDto(Long id, List<FullProductDto> products) {
		this.id = id;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FullProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<FullProductDto> products) {
		this.products = products;
	}

}
