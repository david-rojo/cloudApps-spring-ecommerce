package com.cloudapps.ecommerce.infrastructure;

import org.springframework.stereotype.Component;

import com.cloudapps.ecommerce.domain.shoppingcart.ShoppingCartRepository;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;
import com.cloudapps.ecommerce.infrastructure.model.ShoppingCartEntity;
import com.cloudapps.ecommerce.infrastructure.repository.ShoppingCartJpaRepository;

@Component
public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {

	private ShoppingCartJpaRepository shoppingCartJpaRepository;
	
	public ShoppingCartRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository) {
		this.shoppingCartJpaRepository = shoppingCartJpaRepository;
	}
	
	@Override
	public NewShoppingCartDto save() {
		
		ShoppingCartEntity savedShoppingCartEntity = shoppingCartJpaRepository.save(new ShoppingCartEntity(false));
		return new NewShoppingCartDto(
				savedShoppingCartEntity.getId(),
				savedShoppingCartEntity.isCompleted());
	}

}
