package com.cloudapps.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cloudapps.ecommerce.controller.dto.cartitem.CartItemResponseDto;
import com.cloudapps.ecommerce.controller.dto.product.ProductResponseDto;
import com.cloudapps.ecommerce.controller.dto.shoppingcart.ShoppingCartResponseDto;
import com.cloudapps.ecommerce.domain.cartitem.dto.FullCartItemDto;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;

@Component
public class ControllerObjectMapper {

	
	public ProductResponseDto toProductResponseDto(FullProductDto fullProduct) {
		
		return new ProductResponseDto(
				fullProduct.getId(), 
				fullProduct.getName(), 
				fullProduct.getDescription(),
				fullProduct.getPrice());
	}
	
	public CartItemResponseDto toCartItemResponseDto(FullCartItemDto fullCartItem) {
		
		return new CartItemResponseDto(
				fullCartItem.getId(),
				fullCartItem.getQuantity(),
				this.toProductResponseDto(fullCartItem.getProduct()));
	}
	
	public ShoppingCartResponseDto toShoppingCartResponseDto(FullShoppingCartDto shoppingCart) {
		List<CartItemResponseDto> listCartItemResponseDto = new ArrayList<>();
		shoppingCart.getCartItems().forEach(fullCartItem
				-> listCartItemResponseDto.add(this.toCartItemResponseDto(fullCartItem)));
	
		return new ShoppingCartResponseDto(
				shoppingCart.getId(),
				shoppingCart.isCompleted(),
				listCartItemResponseDto);
	}
}
