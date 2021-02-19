package com.cloudapps.ecommerce.domain.product;

import java.util.List;
import java.util.Optional;

import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;

public interface ProductRepository {
	
	public FullProductDto save(FullProductDto product);

	public List<FullProductDto> findAllProducts();

	public Optional<FullProductDto> findProductById(Long id);
	
	public void delete(Long id);
}
