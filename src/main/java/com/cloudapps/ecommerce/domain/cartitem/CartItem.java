package com.cloudapps.ecommerce.domain.cartitem;

import com.cloudapps.ecommerce.domain.product.Product;

public class CartItem {

	private Long id;
	
	private int quantity;
	
	private Product product;

	public CartItem() {}
	
	public CartItem(int quantity, Product product) {
		this(null, quantity, product);
	}
	
	public CartItem(Long id, int quantity, Product product) {
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
