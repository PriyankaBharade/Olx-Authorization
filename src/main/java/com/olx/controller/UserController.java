package com.olx.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.olx.dto.AuthenticationRequest;
import com.olx.dto.User;
import com.olx.security.JwtUtil;
import com.olx.service.LoginService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx/authentication")
public class UserController {

	@Autowired
	@Qualifier("MONGO_SERVICE")
	LoginService loginService;
	@Autowired
	JwtUtil jwtutil;
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	AuthenticationManager authenticationManager;

	@ApiOperation(value = "Authenticate user in the application.")
	@PostMapping(value = "/user/authenticate", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> login(@RequestBody AuthenticationRequest authenticationRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			String JwtToken = jwtutil
					.generateToken(userDetailsService.loadUserByUsername(authenticationRequest.getUsername()));
			return new ResponseEntity<>(JwtToken, HttpStatus.OK);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Logs out authenticated user from the application.")
	@PostMapping(value = "/user/logout")
	public boolean logout(@RequestHeader("Authorization") String authToken) {
		return loginService.logout(authToken);
	}

	// @ApiOperation(value = "Logs out authenticated user from the application.")
	// @GetMapping(value = "/user/logout")
	public boolean getBlackListToken(String authToken) {
		return loginService.getBlackListToken(authToken);
	}

	@ApiOperation(value = "Register a user in the application.")
	@PostMapping(value = "/user")
	public User registerUser(@RequestBody User user) {
		return loginService.registerUser(user);
	}

	@ApiOperation(value = "Get information of a user from the application.")
	@GetMapping(value = "/user")
	public User getUserInfo(@RequestHeader("Authorization") String authToken) {
		String JwtToken = authToken.substring(7, authToken.length());
		String username = jwtutil.extractUsername(JwtToken);
		List<Map> map = loginService.getCategory();
		return loginService.getUserInfo(authToken, username);
	}


	@ApiOperation(value = "Token Validation.")
	@GetMapping(value = "/user/validate/token")
	public ResponseEntity<Boolean> validateToken(@RequestHeader("Authorization") String authToken) {
		String JwtToken = authToken.substring(7, authToken.length());
		String username = jwtutil.extractUsername(JwtToken);
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		boolean isTokenValid = jwtutil.validateToken(JwtToken, userDetails);
		if (getBlackListToken(authToken)) {
			return new ResponseEntity<Boolean>(isTokenValid, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}

}
