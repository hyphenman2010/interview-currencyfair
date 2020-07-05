package org.ivanman.interview.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.ivanman.interview.order.OrderRequest;
import org.ivanman.interview.order.OrderRequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class OrderRequestRepositoryTests {

	@Autowired
	protected OrderRequestRepository orderRequestRepo;

	@Test
	@Transactional
	void shouldInsertOrderRequest() throws ParseException {

		String sTimePlaced = "24-JAN-18 10:27:44";
		Date timePlaced = new SimpleDateFormat("dd-MMM-yy HH:mm:ss", Locale.ENGLISH).parse(sTimePlaced);

		OrderRequest orderRequest = new OrderRequest();
		orderRequest.setUserId("00001");
		orderRequest.setCurrencyFrom("EUR");
		orderRequest.setCurrencyTo("GBP");
		orderRequest.setAmountSell(new BigDecimal(1000.00));
		orderRequest.setAmountBuy(new BigDecimal(747.10));
		orderRequest.setRate(new BigDecimal(0.7471));
		orderRequest.setTimePlaced(timePlaced);
		orderRequest.setOriginatingCountry("FR");

		this.orderRequestRepo.save(orderRequest);
		assertThat(orderRequest.getId().longValue()).isNotEqualTo(0);
	}

}
