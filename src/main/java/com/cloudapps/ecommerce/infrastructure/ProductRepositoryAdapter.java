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
	
	private InfrastructureObjectMapper mapper;
	
	public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository, InfrastructureObjectMapper mapper) {
		this.productJpaRepository = productJpaRepository;
		this.mapper = mapper;
	}
	
	@Override
	public FullProductDto save(FullProductDto product) {
		
		ProductEntity savedProductEntity = productJpaRepository.save(mapper.toProductEntity(product));		
		return mapper.toFullProductDto(savedProductEntity);
	}

	@Override
	public List<FullProductDto> findAllProducts() {

		List<ProductEntity> products = productJpaRepository.findAll();
		return products
				.stream()
				.map(mapper::toFullProductDto)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<FullProductDto> findProductById(Long id) {
		
		Optional<ProductEntity> maybeAProduct = productJpaRepository.findById(id);
		return Optional.of(mapper.toFullProductDto(maybeAProduct.get()));
	}

	@Override
	public void delete(Long id) {
		
		productJpaRepository.deleteById(id);		
	}

}
