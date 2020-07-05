package org.ivanman.interview.order;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(OrderRequestController.class)
class OrderRequestControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderRequestRepository orderRequestRepo;

	@BeforeEach
	void setup() throws ParseException {

		String sTimePlaced = "24-JAN-18 10:27:44";
		Date timePlaced = new SimpleDateFormat("dd-MMM-yy HH:mm:ss", Locale.ENGLISH).parse(sTimePlaced);

		OrderRequest orderRequest = new OrderRequest();
		orderRequest.setId(1);
		orderRequest.setCurrencyFrom("EUR");
		orderRequest.setCurrencyTo("GBP");
		orderRequest.setAmountSell(new BigDecimal(1000.00));
		orderRequest.setAmountBuy(new BigDecimal(747.10));
		orderRequest.setRate(new BigDecimal(0.7471));
		orderRequest.setTimePlaced(timePlaced);
		orderRequest.setOriginatingCountry("FR");

		given(this.orderRequestRepo.findAll()).willReturn(Lists.newArrayList(orderRequest));

	}

	@Test
	void testShowOrderRequestListHtml() throws Exception {
		mockMvc.perform(get("/order_requests.html")).andExpect(status().isOk())
				.andExpect(model().attributeExists("orderRequests")).andExpect(view().name("orders/orderRequestList"));
	}

	@Test
	void testShowResourcesOrderRequestList() throws Exception {
		ResultActions actions = mockMvc.perform(get("/orderRequests").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.orderRequestList[0].id").value(1));
	}

}
