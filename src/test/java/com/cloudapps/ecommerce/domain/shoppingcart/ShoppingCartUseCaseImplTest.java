package com.cloudapps.ecommerce.domain.shoppingcart;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cloudapps.ecommerce.domain.cartitem.CartItemRepository;
import com.cloudapps.ecommerce.domain.cartitem.dto.FullCartItemDto;
import com.cloudapps.ecommerce.domain.product.ProductRepository;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.FullShoppingCartDto;
import com.cloudapps.ecommerce.domain.shoppingcart.dto.NewShoppingCartDto;

@ExtendWith(MockitoExtension.class)
@DisplayName("ShoppingCartUseCase Unit tests using mocks")
public class ShoppingCartUseCaseImplTest {

	@Mock
	private ShoppingCartRepository shoppingCartRepository;
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private CartItemRepository cartItemRepository;
	
	@Mock
	private AvailabilityService availabilityService;

	private ShoppingCartUseCase shoppingCartUseCase;
	
	@BeforeEach
    public void beforeEach() {
        
		shoppingCartUseCase = new ShoppingCartUseCaseImpl(shoppingCartRepository, productRepository,
        		cartItemRepository, availabilityService);
    }
	
	@Test
	@DisplayName("When create shopping cart then return new shopping cart with completed false, expected ok")
    void whenCreateShoppingCartThenReturnShoppingCartWithCompletedFalse() {
		
        NewShoppingCartDto newShoppingCart = new NewShoppingCartDto(Long.valueOf(1), false);
        
        when(shoppingCartRepository.create()).thenReturn(newShoppingCart);

        NewShoppingCartDto createdShoppingCart = shoppingCartUseCase.createShoppingCart();
        Assertions.assertNotNull(createdShoppingCart);
        Assertions.assertEquals(createdShoppingCart.getId(), newShoppingCart.getId());
        Assertions.assertEquals(createdShoppingCart.isCompleted(), newShoppingCart.isCompleted());
    }
	
	@Disabled
	@Test
	@DisplayName("Given existing cart and product when add product to cart then return cart with product, expected ok")
    void givenExistingCartAndProductWhenAddProductToCartThenReturnCartWithProduct() {
        
		FullShoppingCartDto existingShoppingCart = new FullShoppingCartDto(Long.valueOf(1), false, new ArrayList<>());
        FullProductDto existingProduct = new FullProductDto(Long.valueOf(2),"test-name", "test-description", 15);
        FullCartItemDto requestSaveCartItem = new FullCartItemDto(4, existingProduct, existingShoppingCart);
        FullCartItemDto createdCartItem = new FullCartItemDto(Long.valueOf(3), 4, existingProduct, existingShoppingCart);

        when(shoppingCartRepository.findShoppingCartById(Long.valueOf(1))).thenReturn(Optional.of(existingShoppingCart));
        when(productRepository.findProductById(Long.valueOf(2))).thenReturn(Optional.of(existingProduct));
        when(cartItemRepository.save(requestSaveCartItem)).thenReturn(createdCartItem);

        FullShoppingCartDto updatedShoppingCart = this.shoppingCartUseCase.addProduct(Long.valueOf(1), Long.valueOf(2), 4).get();
        Assertions.assertNotNull(updatedShoppingCart);
        Assertions.assertEquals(updatedShoppingCart.getId(), existingShoppingCart.getId());
        Assertions.assertEquals(updatedShoppingCart.isCompleted(), existingShoppingCart.isCompleted());
        Assertions.assertEquals(updatedShoppingCart.getCartItems().size(), 1);
    }
	
}
