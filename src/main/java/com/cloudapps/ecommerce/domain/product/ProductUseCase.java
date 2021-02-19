package com.cloudapps.ecommerce.domain.product;

import java.util.Collection;
import java.util.Optional;

import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.product.dto.ProductDto;

public interface ProductUseCase {

	public Collection<FullProductDto> findAllProducts();
	
	public FullProductDto createProduct(ProductDto productDto);
	
	public Optional<FullProductDto> findProductById(Long id);
	
	public void deleteProduct(Long id);
}
