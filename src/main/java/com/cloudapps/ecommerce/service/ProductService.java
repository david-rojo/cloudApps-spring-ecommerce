package com.cloudapps.ecommerce.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cloudapps.ecommerce.controller.dto.product.ProductRequestDto;
import com.cloudapps.ecommerce.domain.product.ProductUseCase;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.product.dto.ProductDto;

@Service
public class ProductService {

	private ProductUseCase productUseCase;

	public ProductService(ProductUseCase productUseCase) {
		this.productUseCase = productUseCase;
	}
	
	public Collection<FullProductDto> findAll() {
		return productUseCase.findAllProducts();
	}
	
	public Optional<FullProductDto> findById(Long id) {
		return productUseCase.findProductById(id);
	}
	
	public FullProductDto create(ProductRequestDto product) {
		
		ProductDto productDto = new ProductDto(
				product.getName(),
				product.getDescription());
		
		return productUseCase.createProduct(productDto);
	}
	
	public Optional<FullProductDto> delete(Long id) {
		return productUseCase.deleteProduct(id);
	}

}
