package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.Optional;

import com.cloudapps.ecommerce.domain.cartitem.CartItemRepository;
import com.cloudapps.ecommerce.domain.cartitem.dto.FullCartItemDto;
import com.cloudapps.ecommerce.domain.product.ProductRepository;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {

	private ShoppingCartRepository shoppingCartRepository;
	
	private ProductRepository productRepository;
	
	private CartItemRepository cartItemRepository;
	
	public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository,
			ProductRepository productRepository, CartItemRepository cartItemRepository) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.productRepository = productRepository;
		this.cartItemRepository = cartItemRepository;
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
	public Optional<FullShoppingCartDto> addProduct(Long shoppingCartId, Long productId, int prodQuantity) {
		
		Optional<FullProductDto> fullProductDto = this.productRepository.findProductById(productId);
        Optional<FullShoppingCartDto> shoppingCartDto = this.shoppingCartRepository
        		.findShoppingCartById(shoppingCartId);
        
        
        if (fullProductDto.isPresent() && shoppingCartDto.isPresent()) {
        	Optional<FullCartItemDto> existingCartItem = shoppingCartDto.get().contains(productId);
        	if (existingCartItem.isPresent()) {
        		shoppingCartDto.get().updateQuantity(existingCartItem.get().getId(), prodQuantity);
        	}
        	else {
        		FullCartItemDto newCartItem = new FullCartItemDto(prodQuantity, fullProductDto.get(), shoppingCartDto.get());
        		FullCartItemDto savedCartItem = cartItemRepository.save(newCartItem);
        		shoppingCartDto.get().addItem(savedCartItem);
        	}
        	shoppingCartRepository.save(shoppingCartDto.get());
        }
        
        Optional<FullShoppingCartDto> result = this.shoppingCartRepository
        		.findShoppingCartById(shoppingCartId);
        return result;
	}

}
