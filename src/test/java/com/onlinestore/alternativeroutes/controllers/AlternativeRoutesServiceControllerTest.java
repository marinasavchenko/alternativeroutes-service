package com.onlinestore.alternativeroutes.controllers;

import com.onlinestore.alternativeroutes.domain.RouteRecord;
import com.onlinestore.alternativeroutes.services.RouteRecordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AlternativeRoutesServiceController.class, secure = false)
public class AlternativeRoutesServiceControllerTest {

	private static final String SERVICE_NAME = "customerservice";
	private static final String URI = "/v1/route/records";

	@MockBean
	private RouteRecordService routeRecordService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void shouldGetRouteRecordByServiceName() throws Exception {
		mockMvc.perform(get(URI + "/" + SERVICE_NAME)).andExpect((status().isOk()));
		verify(routeRecordService).getRouteRecordByServiceName(SERVICE_NAME);
	}

	@Test
	public void shouldAddRouteRecord() throws Exception {
		mockMvc.perform(post(URI)).andExpect((status().isCreated()));
		verify(routeRecordService).addAddRouteRecord(any(RouteRecord.class));
	}

}