package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloudapps.ecommerce.domain.cartitem.CartItemRepository;
import com.cloudapps.ecommerce.domain.cartitem.dto.FullCartItemDto;
import com.cloudapps.ecommerce.domain.exception.NotValidatedShoppingCartException;
import com.cloudapps.ecommerce.domain.product.ProductRepository;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {

	private ShoppingCartRepository shoppingCartRepository;
	
	private ProductRepository productRepository;
	
	private CartItemRepository cartItemRepository;
	
	private AvailabilityService availabilityService;
	
	private Logger log = LoggerFactory.getLogger(ShoppingCartUseCaseImpl.class);
	
	public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository,
			ProductRepository productRepository, CartItemRepository cartItemRepository,
			AvailabilityService availabilityService) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.productRepository = productRepository;
		this.cartItemRepository = cartItemRepository;
		this.availabilityService = availabilityService;
	}
	
	@Override
	public NewShoppingCartDto createShoppingCart() {
		return shoppingCartRepository.create();
	}

	@Override
	public Optional<FullShoppingCartDto> complete(Long id) throws NotValidatedShoppingCartException {
		
		FullShoppingCartDto shoppingCart = shoppingCartRepository.findShoppingCartById(id)
				.orElseThrow();
		boolean validated = availabilityService.check(shoppingCart.getCartItems());
		if (!validated) {
			log.warn("Not validated shopping cart");
			throw new NotValidatedShoppingCartException();
		}
		log.info("validated shopping cart");
		shoppingCart.setCompleted(true);
		return Optional.of(shoppingCartRepository.save(shoppingCart));
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
        
        return shoppingCartDto;
	}

	@Override
	public Optional<FullShoppingCartDto> deleteProduct(Long shoppingCartId, Long productId) {
		
		Optional<FullProductDto> fullProductDto = this.productRepository.findProductById(productId);
        Optional<FullShoppingCartDto> shoppingCartDto = this.shoppingCartRepository
        		.findShoppingCartById(shoppingCartId);
        
        if (fullProductDto.isPresent() && shoppingCartDto.isPresent()) {
        	Optional<FullCartItemDto> existingCartItem = shoppingCartDto.get().contains(productId);
        	if (existingCartItem.isPresent()) {
        		shoppingCartDto.get().removeItem(existingCartItem.get());
        		shoppingCartRepository.save(shoppingCartDto.get());
        	}
        }
        
		return this.shoppingCartRepository.findShoppingCartById(shoppingCartId);
	}

	@Override
	public Optional<FullShoppingCartDto> delete(Long shoppingCartId) {

		Optional<FullShoppingCartDto> shoppingCart = shoppingCartRepository.findShoppingCartById(shoppingCartId);
        if (shoppingCart.isPresent()) {
        	shoppingCartRepository.delete(shoppingCart.get());
        }
        return shoppingCart;
	}

}
