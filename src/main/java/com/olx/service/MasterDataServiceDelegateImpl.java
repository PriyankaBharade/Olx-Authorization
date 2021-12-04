package com.olx.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MasterDataServiceDelegateImpl implements MatserDataServiceDelegate {

	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	@CircuitBreaker(name = "CATEGORY-CIRCUIT-BREAKER", fallbackMethod = "fallBackGetCategories")
	public List<Map> getUserAdvertisment() {
		List<Map> advertisementList = restTemplate.getForObject("http://masterdata-service/olx/masterdata/advertise/category", List.class);
		return advertisementList;
	}

	@Override
	public String getUserNameByAuthToken(String authToken) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Map> fallBackGetCategories(Throwable ex){
		System.out.print("Master Call Failed : " + ex);
		return null;
	}
	

}
