package com.cloudapps.ecommerce.domain.product;

import java.util.Collection;
import java.util.Optional;

import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.product.dto.ProductDto;

public class ProductUseCaseImpl implements ProductUseCase {

	private ProductRepository productRepository;
	
	public ProductUseCaseImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public Collection<FullProductDto> findAllProducts() {
		return productRepository.findAllProducts();
	}

	@Override
	public FullProductDto createProduct(ProductDto productDto) {
		
		FullProductDto product = new FullProductDto(
				productDto.getName(),
				productDto.getDescription(),
				productDto.getPrice());
		return productRepository.save(product);				
	}

	@Override
	public Optional<FullProductDto> findProductById(Long id) {
		return productRepository.findProductById(id);
	}

	@Override
	public Optional<FullProductDto> deleteProduct(Long id) {
		
		Optional<FullProductDto> product = productRepository.findProductById(id);
        if (product.isPresent()) {
        	productRepository.delete(product.get());
        }
        return product;
	}

}
