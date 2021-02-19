package com.cloudapps.ecommerce.service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cloudapps.ecommerce.controller.dto.product.ProductRequestDto;
import com.cloudapps.ecommerce.controller.dto.product.ProductResponseDto;
import com.cloudapps.ecommerce.domain.product.ProductUseCase;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.product.dto.ProductDto;

@Service
public class ProductService {

	private ProductUseCase productUseCase;

	public ProductService(ProductUseCase productUseCase) {
		this.productUseCase = productUseCase;
	}
	
	public Collection<ProductResponseDto> findAll() {
		return productUseCase
				.findAllProducts()
				.stream()
				.map(ProductResponseDto::fromFullProductDto)
				.collect(Collectors.toList());
	}
	
	public Optional<ProductResponseDto> findById(Long id) {
		return productUseCase.findProductById(id).map(ProductResponseDto::fromFullProductDto);
	}
	
	public FullProductDto save(ProductRequestDto product) {
		
		ProductDto productDto = new ProductDto(
				product.getName(),
				product.getDescription(),
				product.getQuantity());
		
		return productUseCase.createProduct(productDto);
	}
	
	public void deleteById(Long id) {
		productUseCase.deleteProduct(id);
	}

}
