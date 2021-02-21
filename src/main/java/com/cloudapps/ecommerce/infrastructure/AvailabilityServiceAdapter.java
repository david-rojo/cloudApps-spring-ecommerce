package com.cloudapps.ecommerce.infrastructure;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cloudapps.ecommerce.domain.cartitem.dto.FullCartItemDto;
import com.cloudapps.ecommerce.domain.shoppingcart.AvailabilityService;

@Component
public class AvailabilityServiceAdapter implements AvailabilityService {

	private Logger log = LoggerFactory.getLogger(AvailabilityServiceAdapter.class);

	@Override
	public boolean check(List<FullCartItemDto> list) {
		Random rd = new Random();
		boolean availability = rd.nextBoolean();
		log.info("Generated availability: {}", availability);
	    return availability;
	}

}
