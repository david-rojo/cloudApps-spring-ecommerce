package com.cloudapps.ecommerce.domain.product.dto;

public class FullProductDto {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private int quantity;
	
	public FullProductDto() {}

	public FullProductDto(String name, String description, int quantity) {
		this(null, name, description, quantity);
	}
	
	public FullProductDto(Long id, String name, String description, int quantity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	

}
