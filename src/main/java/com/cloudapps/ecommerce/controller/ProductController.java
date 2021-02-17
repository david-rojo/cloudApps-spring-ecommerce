package com.cloudapps.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapps.ecommerce.controller.dto.product.DeleteProductResponseDto;
import com.cloudapps.ecommerce.controller.dto.product.PostProductRequestDto;
import com.cloudapps.ecommerce.controller.dto.product.ProductResponseDto;

@RestController
@RequestMapping (value="/api/products")
public class ProductController {
	
	@GetMapping(value="/")
	public List<ProductResponseDto> getProducts() {
		//TODO pending to implement
		return null;
	}
	
	@PostMapping(value="/")
	public ProductResponseDto postProduct(@RequestBody PostProductRequestDto postBookRequestDto) {
		//TODO pending to implement
		return null;
	}
	
	@GetMapping(value="/{id}")
	public ProductResponseDto getProduct(@PathVariable(value="productId") Long id) {
		//TODO pending to implement
		return null;
	}
	
	@DeleteMapping(value="/{id}")
	public DeleteProductResponseDto deleteProduct(@PathVariable(value="id") Long id) {
		//TODO pending to implement
		return null;
	}
}
