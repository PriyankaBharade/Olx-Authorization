package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Black List Auth Token")
public class BlackListUser {
	@ApiModelProperty("Auth Token")
	public String authToken;
	

	@Override
	public String toString() {
		return "BlackListUser [authToken=" + authToken + "]";
	}

	public BlackListUser() {
		super();
	}

	public BlackListUser(String authToken) {
		super();
		this.authToken = authToken;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
}
