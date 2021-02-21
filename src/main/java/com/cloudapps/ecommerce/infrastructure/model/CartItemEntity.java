package com.cloudapps.ecommerce.infrastructure.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_item")
public class CartItemEntity {
	
	//https://stackoverflow.com/questions/7308804/setting-the-correct-jpa-mapping-for-shopping-cart-items-and-product
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int quantity;
		
	@ManyToOne
	//@JoinColumn(name="shoppingCartId", nullable=false)
	private ShoppingCartEntity shoppingCart;
	
	@ManyToOne
	private ProductEntity product;
	
	public CartItemEntity() {}

	public CartItemEntity(ProductEntity product, int quantity, ShoppingCartEntity shoppingCart) {
		this(null, product, quantity, shoppingCart);
	}
	
	public CartItemEntity(Long id, ProductEntity product, int quantity, ShoppingCartEntity shoppingCart) {
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.shoppingCart = shoppingCart;
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

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public ShoppingCartEntity getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartEntity shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
