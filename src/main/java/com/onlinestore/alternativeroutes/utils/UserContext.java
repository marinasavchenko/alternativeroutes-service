package com.onlinestore.alternativeroutes.utils;

import org.springframework.stereotype.Component;

/**
 * Contextual information scrapped from incoming HTTP request.
 */
@Component
public class UserContext {

	public static final String CORRELATION_ID = "onlst-correlation-id";
	public static final String AUTH_TOKEN = "onlst-auth-token";
	public static final String USER_ID = "onlst-user-id";
	public static final String CUSTOMER_ID = "onlst-customer-id";

	private String correlationId = "";
	private String authToken = "";
	private String userId = "";
	private String customerId = "";

	public String getCorrelationId() {
		return correlationId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getUserId() {
		return userId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "UserContext{" +
				"correlationId='" + correlationId + '\'' +
				", authToken='" + authToken + '\'' +
				", userId='" + userId + '\'' +
				", customerId='" + customerId + '\'' +
				'}';
	}
}