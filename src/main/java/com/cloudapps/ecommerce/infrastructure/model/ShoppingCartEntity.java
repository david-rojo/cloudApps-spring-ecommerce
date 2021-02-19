package com.cloudapps.ecommerce.infrastructure.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean completed;
	
	@OneToMany(mappedBy="shoppingCart", cascade = CascadeType.ALL)
	private List<ProductEntity> products;
	
	public ShoppingCartEntity() {}

	public ShoppingCartEntity(Long id, boolean completed) {
		this(id, completed, new ArrayList<>());
	}
	
	public ShoppingCartEntity(boolean completed) {
		this(null, completed, new ArrayList<>());
	}
	
	public ShoppingCartEntity(Long id, boolean completed, List<ProductEntity> products) {
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

	public void addProduct(ProductEntity product) {
		products.add(product);
		product.setShoppingCart(this);
	}
	
	public void removeProduct(ProductEntity product) {
		boolean removed = products.remove(product);
		if(!removed) {
			throw new NoSuchElementException();
		}
		product.setShoppingCart(null);
	}	
	
}
