package com.onlinestore.alternativeroutes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when route record of the service can not be found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RouteRecordNotFoundException extends RuntimeException {
	/**
	 * Constructs new {@code RouteRecordNotFoundException} instance.
	 *
	 * @param serviceId service id
	 */
	public RouteRecordNotFoundException(String serviceId) {
		super("RouteRecord of service " + serviceId + "not found");
	}
}
