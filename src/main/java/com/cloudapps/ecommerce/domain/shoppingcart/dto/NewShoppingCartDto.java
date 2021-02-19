package com.cloudapps.ecommerce.domain.shoppingcart.dto;

public class NewShoppingCartDto {

	private Long id;
	
	private boolean completed;

	public NewShoppingCartDto() {}

	public NewShoppingCartDto(Long id, boolean completed) {
		this.id = id;
		this.completed = completed;
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

}
