package com.cloudapps.ecommerce.infrastructure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cloudapps.ecommerce.domain.product.ProductRepository;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.infrastructure.model.ProductEntity;
import com.cloudapps.ecommerce.infrastructure.repository.ProductJpaRepository;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

	private ProductJpaRepository productJpaRepository;
	
	public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
		this.productJpaRepository = productJpaRepository;
	}
	
	@Override
	public FullProductDto save(FullProductDto product) {
		
		ProductEntity productEntity = new ProductEntity(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getQuantity());
		
		ProductEntity savedBookEntity = productJpaRepository.save(productEntity);
		
		return toFullProductDto(savedBookEntity);
	}

	@Override
	public List<FullProductDto> findAllProducts() {

		List<ProductEntity> products = productJpaRepository.findAll();
		return products
				.stream()
				.map(ProductRepositoryAdapter::toFullProductDto)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<FullProductDto> findProductById(Long id) {
		
		Optional<ProductEntity> maybeAProduct = productJpaRepository.findById(id);
		return maybeAProduct.map(ProductRepositoryAdapter::toFullProductDto);
	}

	@Override
	public void delete(Long id) {
		
		productJpaRepository.deleteById(id);		
	}
	
	private static FullProductDto toFullProductDto(ProductEntity product) {
		
		return new FullProductDto(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getQuantity());
	}

}
