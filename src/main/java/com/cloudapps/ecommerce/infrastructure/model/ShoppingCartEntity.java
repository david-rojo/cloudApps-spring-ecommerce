package com.cloudapps.ecommerce.infrastructure.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="shopping_cart")
public class ShoppingCartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean completed;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
    		name = "shopping_cart_product",
            joinColumns = {@JoinColumn(name = "shopping_cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
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

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
	public void addProduct(ProductEntity product) {
		products.add(product);
	}
	
	public void removeProduct(ProductEntity product) {
		boolean removed = products.remove(product);
		if(!removed) {
			throw new NoSuchElementException();
		}
	}
	
}
