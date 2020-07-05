package org.ivanman.interview.messaging;

import java.util.Date;

import org.ivanman.interview.order.OrderRequest;
import org.ivanman.interview.order.OrderRequestRepository;
import org.ivanman.interview.order.OrderResult;
import org.ivanman.interview.order.OrderResultRepository;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Consumer {

	private final OrderRequestRepository orderRequestRepository;
	private final OrderResultRepository orderResultRepository;

	public Consumer(OrderRequestRepository orderRequestRepository, OrderResultRepository orderResultRepository) {
		this.orderRequestRepository = orderRequestRepository;
		this.orderResultRepository = orderResultRepository;
	}

	@JmsListener(destination = "order-queue")
	public void listener(String msg) {
		System.out.println("Received Message : " + msg);

		try {
			OrderRequestJson json = new ObjectMapper().readValue(msg, OrderRequestJson.class);

			// create OrderRequest entity
			OrderRequest req = new OrderRequest();
			req.setUserId(json.getUserId());
			req.setCurrencyFrom(json.getCurrencyFrom());
			req.setCurrencyTo(json.getCurrencyTo());
			req.setAmountSell(json.getAmountSell());
			req.setAmountBuy(json.getAmountBuy());
			req.setRate(json.getRate());
			req.setTimePlaced(json.getTimePlaced());
			req.setOriginatingCountry(json.getOriginatingCountry());

			// create OrderResult entity
			OrderResult res = new OrderResult();
			res.setUserId(json.getUserId());
			res.setOrderResultStatus("SUCCESS");
			res.setTimeExecuted(new Date());
			res.setExecutionVenue("JPM");
			res.setOrderRequest(req);

			orderRequestRepository.save(req);
			orderResultRepository.save(res);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
		}

	}
}
