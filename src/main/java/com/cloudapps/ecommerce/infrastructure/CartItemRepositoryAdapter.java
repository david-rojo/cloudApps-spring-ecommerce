package com.cloudapps.ecommerce.infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cloudapps.ecommerce.domain.cartitem.CartItemRepository;
import com.cloudapps.ecommerce.domain.cartitem.dto.FullCartItemDto;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.infrastructure.model.CartItemEntity;
import com.cloudapps.ecommerce.infrastructure.repository.CartItemJpaRepository;

@Component
public class CartItemRepositoryAdapter implements CartItemRepository {
	
	private CartItemJpaRepository cartItemJpaRepository;
	
	private InfrastructureObjectMapper mapper;
	
	public CartItemRepositoryAdapter(CartItemJpaRepository cartItemJpaRepository,
			InfrastructureObjectMapper mapper) {
		this.cartItemJpaRepository = cartItemJpaRepository;
		this.mapper = mapper;
	}

	@Override
	public Optional<FullCartItemDto> findCartItemByProduct(FullProductDto fullProductDto) {
		CartItemEntity savedCartItemEntity = cartItemJpaRepository
				.findByProduct(mapper.toProductEntity(fullProductDto));
		return Optional.of(mapper.toFullCartItemDto(savedCartItemEntity));
	}

	@Override
	public FullCartItemDto save(FullCartItemDto fullCartItemDto) {
		
		CartItemEntity cartItemEntity = mapper.toCartItemEntity(fullCartItemDto);		
		CartItemEntity savedCartEntity = cartItemJpaRepository.save(cartItemEntity);		
		return mapper.toFullCartItemDto(savedCartEntity);
	}

	@Override
	public void delete(FullCartItemDto fullCartItemDto) {
		
		//cartItemJpaRepository.deleteById(id);
		System.out.println("Pending to implement delete cart item repository adapter");
	}
	
	

}
