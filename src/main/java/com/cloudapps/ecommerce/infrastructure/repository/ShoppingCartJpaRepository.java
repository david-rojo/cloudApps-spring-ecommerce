package com.cloudapps.ecommerce.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.ecommerce.infrastructure.model.ShoppingCartEntity;

public interface ShoppingCartJpaRepository extends JpaRepository<ShoppingCartEntity, Long>{

}
