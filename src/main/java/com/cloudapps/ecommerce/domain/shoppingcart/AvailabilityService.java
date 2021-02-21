package com.cloudapps.ecommerce.domain.shoppingcart;

import java.util.List;

import com.cloudapps.ecommerce.domain.cartitem.dto.FullCartItemDto;

public interface AvailabilityService {

	public boolean check(List<FullCartItemDto> list);

}
