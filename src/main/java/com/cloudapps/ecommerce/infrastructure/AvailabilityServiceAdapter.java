package com.cloudapps.ecommerce.infrastructure;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cloudapps.ecommerce.domain.shoppingcart.AvailabilityService;

@Component
public class AvailabilityServiceAdapter implements AvailabilityService {

	private Logger log = LoggerFactory.getLogger(AvailabilityServiceAdapter.class);
	
	@Override
	public boolean check() {
		Random rd = new Random();
		boolean availability = rd.nextBoolean();
		log.info("Generated availability: {}", availability);
	    return availability; 
	}

}
