package com.cloudapps.ecommerce.domain.cartitem;

import java.util.Optional;

import com.cloudapps.ecommerce.domain.cartitem.dto.FullCartItemDto;
import com.cloudapps.ecommerce.domain.product.dto.FullProductDto;

public interface CartItemRepository {

	public Optional<FullCartItemDto> findCartItemByProduct(FullProductDto fullProductDto);
	
	public FullCartItemDto save(FullCartItemDto fullCartItemDto);
	
	public void delete(FullCartItemDto fullCartItemDto);
}
