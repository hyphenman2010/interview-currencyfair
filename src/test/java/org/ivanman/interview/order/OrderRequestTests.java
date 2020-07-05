package org.ivanman.interview.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.util.SerializationUtils;


class OrderRequestTests {

	@Test
	void testSerialization() throws ParseException {
		
	    String sTimePlaced="24-JAN-18 10:27:44";  
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

		
		OrderRequest other = (OrderRequest) SerializationUtils.deserialize(SerializationUtils.serialize(orderRequest));
		assertThat(other.getCurrencyFrom()).isEqualTo(orderRequest.getCurrencyFrom());
		assertThat(other.getCurrencyTo()).isEqualTo(orderRequest.getCurrencyTo());
		assertThat(other.getId()).isEqualTo(orderRequest.getId());
		
		//TODO: all other fields assertion here............

		
		
	}
	
	//TODO: more edge cases here, especially paly around the bigdecimal

}
