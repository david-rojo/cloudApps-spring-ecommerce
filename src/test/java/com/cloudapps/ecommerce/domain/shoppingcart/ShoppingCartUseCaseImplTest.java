package com.cloudapps.ecommerce.domain.shoppingcart;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cloudapps.ecommerce.domain.cartitem.CartItemRepository;
import com.cloudapps.ecommerce.domain.product.ProductRepository;
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
        this.shoppingCartUseCase = new ShoppingCartUseCaseImpl(shoppingCartRepository, productRepository,
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
	
}
