package com.onlinestore.alternativeroutes.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Implementation of the {@link ClientHttpRequestInterceptor} interface.
 * <p>
 * Used to inject the {@code UserContext} values (like correlation ID) into any outgoing HTTP-based service requests
 * being executed from RestTemplate instance for establishing a linkage between service calls.
 */
public class UserContextInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		HttpHeaders headers = request.getHeaders();
		headers.add(UserContext.CORRELATION_ID, UserContextHolder.getContext().getCorrelationId());
		headers.add(UserContext.AUTH_TOKEN, UserContextHolder.getContext().getAuthToken());

		return execution.execute(request, body);
	}
}