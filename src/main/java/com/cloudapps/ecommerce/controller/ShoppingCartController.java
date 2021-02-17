package com.cloudapps.ecommerce.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapps.ecommerce.controller.dto.shoppingcart.ShoppingCartResponseDto;

@RestController
@RequestMapping (value="/api/shoppingcarts")
public class ShoppingCartController {

	@PostMapping(value="/")
	public ShoppingCartResponseDto postShoppingCart() {
		//TODO pending to implement
		return null;
	}
	
	@PatchMapping(path = "/{id}")
	public ShoppingCartResponseDto patchShoppingCart(@PathVariable String id) {
		//TODO pending to implement
		return null;
	}
	
	@GetMapping(value="/{id}")
	public ShoppingCartResponseDto getShoppingCart(@PathVariable(value="id") Long id) {
		//TODO pending to implement
		return null;
	}
	
	@DeleteMapping(value="/{id}")
	public ShoppingCartResponseDto deleteShoppingCart(@PathVariable(value="id") Long id) {
		//TODO pending to implement
		return null;
	}
	
	@PostMapping(value="/{cartId}/product/{productId}/quantity/{prodQuantity}")
	public ShoppingCartResponseDto postProductToShoppingCart(
			@PathVariable(value="cartId") Long cartId,
			@PathVariable(value="productId") Long productId,
			@PathVariable(value="prodQuantity") Long prodQuantity) {
		//TODO pending to implement
		return null;
	}
	
	@DeleteMapping(value="/{cartId}/product/{productId}")
	public ShoppingCartResponseDto deleteProductFromShoppingCart(
			@PathVariable(value="cartId") Long cartId,
			@PathVariable(value="productId") Long productId) {
		//TODO pending to implement
		return null;
	}
}
