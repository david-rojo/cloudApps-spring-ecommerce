package com.cloudapps.ecommerce.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.ecommerce.infrastructure.model.ProductEntity;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

}
