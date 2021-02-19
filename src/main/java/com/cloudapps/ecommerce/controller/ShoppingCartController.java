package com.cloudapps.ecommerce.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapps.ecommerce.controller.dto.shoppingcart.ShoppingCartPostResponseDto;
import com.cloudapps.ecommerce.controller.dto.shoppingcart.ShoppingCartResponseDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;
import com.cloudapps.ecommerce.service.ShoppingCartService;

@RestController
@RequestMapping (value="/api/shoppingcarts")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCarts;
	
	@PostMapping(value="")
	public ResponseEntity<ShoppingCartPostResponseDto> postShoppingCart() {
		
		NewShoppingCartDto shoppingCart = shoppingCarts.create();
		
		ShoppingCartPostResponseDto shoppingCartPostResponseDto = new ShoppingCartPostResponseDto(
				shoppingCart.getId(),
				shoppingCart.isCompleted()); 

		URI location = fromCurrentRequest().path("/{id}")
				.buildAndExpand(shoppingCart.getId()).toUri();

		return ResponseEntity.created(location).body(shoppingCartPostResponseDto);
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
