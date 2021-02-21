package com.cloudapps.ecommerce.domain.product;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;
import com.cloudapps.ecommerce.domain.product.dto.ProductDto;

@ExtendWith(MockitoExtension.class)
@DisplayName("ProductUseCase Unit tests using mocks")
class ProductUseCaseImplTest {
	
	@Mock
    private ProductRepository productRepository;
	
	private ProductUseCase productUseCase;
	
	@BeforeEach
    public void beforeEach() {
        this.productUseCase = new ProductUseCaseImpl(productRepository);
    }
	
	@Test
	@DisplayName("Given new product when saved then return saved product, expected ok")
    void givenNewProductWhenSavedThenReturnSavedProduct() {
        
		ProductDto newProduct = new ProductDto("test-name", "test-description", 15);
        FullProductDto savedProduct = new FullProductDto(Long.valueOf(1), "test-name", "test-description", 15);

        when(this.productRepository.save(any())).thenReturn(savedProduct);

        FullProductDto productToSave = productUseCase.createProduct(newProduct);
        Assertions.assertNotNull(productToSave);
        Assertions.assertEquals(productToSave.getName(), newProduct.getName());
        Assertions.assertEquals(productToSave.getDescription(), newProduct.getDescription());
        Assertions.assertEquals(productToSave.getPrice(), newProduct.getPrice());
    }
	
	@Test
	@DisplayName("Given existing product when delete then return product, expected ok")
    void givenExistingProductWhenDeleteThenReturnProduct() {
       
		FullProductDto product = new FullProductDto(Long.valueOf(1), "test-name", "test-description", 15);

        when(productRepository.findProductById(isA(Long.class))).thenReturn(Optional.of(product));
        when(productRepository.delete(any())).thenReturn(product);
        
        FullProductDto deletedProduct = productUseCase.deleteProduct(Long.valueOf(1)).get();
        Assertions.assertNotNull(deletedProduct);
        Assertions.assertEquals(deletedProduct.getName(), product.getName());
        Assertions.assertEquals(deletedProduct.getDescription(), product.getDescription());
        Assertions.assertEquals(deletedProduct.getPrice(), product.getPrice());
    }
	
	@Test
	@DisplayName("Given not existing product when delete then return empty, expected ok")
    void givenNotExistingProductWhenDeleteThenReturnEmpty() {
		
        when(productRepository.findProductById(isA(Long.class))).thenReturn(Optional.empty());
        
        Optional<FullProductDto> deletedProduct = productUseCase.deleteProduct(Long.valueOf(1));
        Assertions.assertNotNull(deletedProduct);
        Assertions.assertEquals(deletedProduct, Optional.empty());
    }

}
