package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.Optional;

import com.cloudapps.ecommerce.domain.product.ProductRepository;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {

	private ShoppingCartRepository shoppingCartRepository;
	
	private ProductRepository productRepository;
	
	public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.productRepository = productRepository;
	}
	
	@Override
	public NewShoppingCartDto createShoppingCart() {
		return shoppingCartRepository.create();
	}

	@Override
	public FullShoppingCartDto complete(Long id) {
		
		FullShoppingCartDto shoppingCart = shoppingCartRepository.findShoppingCartById(id).orElseThrow();
		shoppingCart.setCompleted(true);
		return shoppingCartRepository.save(shoppingCart);
	}

	@Override
	public Optional<FullShoppingCartDto> findShoppingCartById(Long id) {
		return shoppingCartRepository.findShoppingCartById(id);
	}

	@Override
	public Optional<FullShoppingCartDto> addProduct(Long shoppingCartId, Long productId, Long prodQuantity) {
		
		Optional<FullProductDto> fullProductDto = this.productRepository.findProductById(productId);
        Optional<FullShoppingCartDto> shoppingCartDto = this.shoppingCartRepository.findShoppingCartById(shoppingCartId);
        
        fullProductDto.ifPresent(product -> shoppingCartDto.ifPresent(cart -> {
            for (int i = 0; i < prodQuantity; i++) {
                cart.getProducts().add(product);
            }
            this.shoppingCartRepository.save(cart);
        }));

        return shoppingCartDto;
	}

}
