package com.cloudapps.ecommerce.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cloudapps.ecommerce.domain.cartitem.dto.FullCartItemDto;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;
import com.cloudapps.ecommerce.infrastructure.model.CartItemEntity;
import com.cloudapps.ecommerce.infrastructure.model.ProductEntity;
import com.cloudapps.ecommerce.infrastructure.model.ShoppingCartEntity;

@Component
public class InfrastructureObjectMapper {
	
	public FullProductDto toFullProductDto(ProductEntity product) {
		return product == null ? null : new FullProductDto(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getPrice());
	}
	
	public FullCartItemDto toFullCartItemDto(CartItemEntity cartItem) {
		
		return cartItem == null ? null : new FullCartItemDto(
					cartItem.getId(),
					cartItem.getQuantity(),
					this.toFullProductDto(cartItem.getProduct()),
					null);
	}
	
	public FullShoppingCartDto toFullShoppingCartDto(ShoppingCartEntity shoppingCart) {

		if (shoppingCart == null) {
			return null;
		}
		else {
			List<FullCartItemDto> listCartItemDto = new ArrayList<>();
			shoppingCart.getCartItems().forEach(cartItemEntity
					-> listCartItemDto.add(this.toFullCartItemDto(cartItemEntity)));
		
			return new FullShoppingCartDto(
					shoppingCart.getId(),
					shoppingCart.isCompleted(),
					listCartItemDto);
		}
	}

	public ProductEntity toProductEntity(FullProductDto fullProductDto) {
		
		return fullProductDto == null ? null : new ProductEntity(
				fullProductDto.getId(),
				fullProductDto.getName(),
				fullProductDto.getDescription(),
				fullProductDto.getPrice());
	}
	
	public CartItemEntity toCartItemEntity(FullCartItemDto fullCartItemDto) {
		return fullCartItemDto == null ? null : new CartItemEntity(
				fullCartItemDto.getId(),
				this.toProductEntity(fullCartItemDto.getProduct()),
				fullCartItemDto.getQuantity(), null);
	}
	
	public ShoppingCartEntity toShoppingCartEntity(FullShoppingCartDto shoppingCartDto) {
		
		if (shoppingCartDto == null) {
			return null;
		}
		else {
			List<CartItemEntity> listCartItemEntity = new ArrayList<>();
			shoppingCartDto.getCartItems().forEach(cartItemDto
					-> listCartItemEntity.add(this.toCartItemEntity(cartItemDto)));
		
			return new ShoppingCartEntity(
					shoppingCartDto.getId(),
					shoppingCartDto.isCompleted(),
					listCartItemEntity);
		}
	}

}
