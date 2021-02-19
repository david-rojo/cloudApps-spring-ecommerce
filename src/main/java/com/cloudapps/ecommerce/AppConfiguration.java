package com.cloudapps.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudapps.ecommerce.domain.product.ProductRepository;
import com.cloudapps.ecommerce.domain.product.ProductUseCase;
import com.cloudapps.ecommerce.domain.product.ProductUseCaseImpl;

@Configuration
public class AppConfiguration {

	@Bean
	public ProductUseCase productUseCase(ProductRepository repositoryAdapter) {
		return new ProductUseCaseImpl(repositoryAdapter);
	}
}
