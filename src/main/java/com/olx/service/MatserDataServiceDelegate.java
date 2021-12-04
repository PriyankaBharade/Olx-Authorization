package com.olx.service;

import java.util.List;
import java.util.Map;


public interface MatserDataServiceDelegate {
	public List<Map> getUserAdvertisment();
	public String getUserNameByAuthToken(String authToken);

}
