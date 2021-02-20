package com.cloudapps.ecommerce.infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cloudapps.ecommerce.domain.shoppingcart.ShoppingCartRepository;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.ShoppingCartDto;
import com.cloudapps.ecommerce.infrastructure.model.ShoppingCartEntity;
import com.cloudapps.ecommerce.infrastructure.repository.ShoppingCartJpaRepository;

@Component
public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {

	private ShoppingCartJpaRepository shoppingCartJpaRepository;
	
	private ObjectMapper mapper;
	
	public ShoppingCartRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository, ObjectMapper mapper) {
		this.shoppingCartJpaRepository = shoppingCartJpaRepository;
		this.mapper = mapper;
	}
	
	@Override
	public NewShoppingCartDto save() {
		
		ShoppingCartEntity savedShoppingCartEntity = shoppingCartJpaRepository.save(new ShoppingCartEntity(false));
		return new NewShoppingCartDto(
				savedShoppingCartEntity.getId(),
				savedShoppingCartEntity.isCompleted());
	}

	@Override
	public Optional<ShoppingCartDto> findShoppingCartById(Long id) {
		Optional<ShoppingCartEntity> maybeAShoppingCart = shoppingCartJpaRepository.findById(id);
		return Optional.of(mapper.toShoppingCartDto(maybeAShoppingCart.get()));
	}

}
