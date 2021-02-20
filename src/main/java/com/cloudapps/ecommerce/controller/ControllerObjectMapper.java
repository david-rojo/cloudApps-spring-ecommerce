package com.cloudapps.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cloudapps.ecommerce.controller.dto.product.ProductResponseDto;
import com.cloudapps.ecommerce.controller.dto.shoppingcart.ShoppingCartResponseDto;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.ShoppingCartDto;

@Component
public class ControllerObjectMapper {

	public ProductResponseDto toProductResponseDto(FullProductDto fullProduct) {
		
		return new ProductResponseDto(
				fullProduct.getId(), 
				fullProduct.getName(), 
				fullProduct.getDescription(), 
				fullProduct.getQuantity());
	}
	
	public ShoppingCartResponseDto toShoppingCartResponseDto(ShoppingCartDto shoppingCart) {
		List<ProductResponseDto> listProductResponseDto = new ArrayList<>();
		shoppingCart.getProducts().forEach(fullProduct -> listProductResponseDto.add(this.toProductResponseDto(fullProduct)));
	
		return new ShoppingCartResponseDto(
				shoppingCart.getId(),
				shoppingCart.isCompleted(),
				listProductResponseDto);
	}
}
