package com.cloudapps.ecommerce.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.ShoppingCartDto;
import com.cloudapps.ecommerce.infrastructure.model.ProductEntity;
import com.cloudapps.ecommerce.infrastructure.model.ShoppingCartEntity;

@Component
public class InfrastructureObjectMapper {
	
	public FullProductDto toFullProductDto(ProductEntity product) {
		return product == null ? null : new FullProductDto(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getQuantity());
	}
	
	public ShoppingCartDto toShoppingCartDto(ShoppingCartEntity shoppingCart) {

		if (shoppingCart == null) {
			return null;
		}
		else {
			List<FullProductDto> listProductDto = new ArrayList<>();
			shoppingCart.getProducts().forEach(productEntity -> listProductDto.add(this.toFullProductDto(productEntity)));
		
			return new ShoppingCartDto(
					shoppingCart.getId(),
					shoppingCart.isCompleted(),
					listProductDto);
		}
	}

	public ProductEntity toProductEntity(FullProductDto fullProductDto) {
		return fullProductDto == null ? null : new ProductEntity(
				fullProductDto.getId(),
				fullProductDto.getName(),
				fullProductDto.getDescription(),
				fullProductDto.getQuantity());
	}
	
	public ShoppingCartEntity toShoppingCartEntity(ShoppingCartDto shoppingCartDto) {
		if (shoppingCartDto == null) {
			return null;
		}
		else {
			List<ProductEntity> listProductEntity = new ArrayList<>();
			shoppingCartDto.getProducts().forEach(productDto -> listProductEntity.add(this.toProductEntity(productDto)));
		
			return new ShoppingCartEntity(
					shoppingCartDto.getId(),
					shoppingCartDto.isCompleted(),
					listProductEntity);
		}
	}

}
