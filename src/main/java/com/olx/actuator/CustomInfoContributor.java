package com.olx.actuator;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;

import com.olx.repo.UserRepository;


public class CustomInfoContributor implements InfoContributor{

	UserRepository userRepo;
	
	@Override
	public void contribute(Builder builder) {
		 builder
         .withDetail("total-registered-users", userRepo.count())
         .withDetail("active-login-count", 30)
         .build();
		
	}

}
