package com.cloudapps.ecommerce.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapps.ecommerce.controller.dto.product.ProductRequestDto;
import com.cloudapps.ecommerce.controller.dto.product.ProductResponseDto;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.service.ProductService;

@RestController
@RequestMapping (value="/api/products")
public class ProductController {
	
	@Autowired
	private ProductService products;
	
	@GetMapping(value="")
	public Collection<ProductResponseDto> getProducts() {
		return products.findAll();
	}
	
	@PostMapping(value="")
	public ResponseEntity<ProductResponseDto> postProduct(@RequestBody ProductRequestDto productRequestDto) {
		
		FullProductDto fullProduct = products.save(productRequestDto);
		
		ProductResponseDto responseProductDto = new ProductResponseDto(
				fullProduct.getId(), 
				fullProduct.getName(), 
				fullProduct.getDescription(), 
				fullProduct.getQuantity()); 

		URI location = fromCurrentRequest().path("/{id}")
				.buildAndExpand(fullProduct.getId()).toUri();

		return ResponseEntity.created(location).body(responseProductDto);
	}
	
	@GetMapping(value="/{id}")
	public ProductResponseDto getProduct(@PathVariable(value="id") Long id) {
		return products.findById(id).orElseThrow();
	}
	
	@DeleteMapping(value="/{id}")
	public ProductResponseDto deleteProduct(@PathVariable(value="id") Long id) {
		
		ProductResponseDto product = products.findById(id).orElseThrow();
		products.deleteById(id);
		return product;
		
	}
}
