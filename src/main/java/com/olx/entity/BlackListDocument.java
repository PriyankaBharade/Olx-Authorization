package com.olx.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "BlackListedUsers")
public class BlackListDocument {
	public String authToken;

	@Override
	public String toString() {
		return "BlackListUser [authToken=" + authToken + "]";
	}

	public BlackListDocument() {
		super();
	}

	public BlackListDocument(String authToken) {
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
