package com.cloudapps.ecommerce.controller.dto.product;

import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;

public class ProductResponseDto {

	private Long id;
	
	private String name;
	
	private String description;

	public ProductResponseDto(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

//	public static ProductResponseDto fromFullProductDto(FullProductDto fullProductDto) {
//		return new ProductResponseDto(
//				fullProductDto.getId(),
//				fullProductDto.getName(),
//				fullProductDto.getDescription(),
//				fullProductDto.getQuantity());
//	}
}
