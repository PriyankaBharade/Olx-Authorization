package com.olx.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.olx.dto.AuthenticationRequest;
import com.olx.dto.User;
import com.olx.entity.BlackListDocument;

public interface LoginService {
	
	    boolean logout(String authToken);
	    
	    boolean getBlackListToken(String authToken);

	    User registerUser(User user);

	    User getUserInfo(String authToken,String username);
	    
	    List<Map> getCategory();
	      
	    ResponseEntity<String> authenticateUser(AuthenticationRequest user);
}
