package com.cloudapps.ecommerce.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.ecommerce.infrastructure.model.CartItemEntity;
import com.cloudapps.ecommerce.infrastructure.model.ProductEntity;

public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, Long> {

	public CartItemEntity findByProduct(ProductEntity productEntity);
}
