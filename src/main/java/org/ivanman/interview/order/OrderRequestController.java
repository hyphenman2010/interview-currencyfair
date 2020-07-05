package org.ivanman.interview.order;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class OrderRequestController {

	private final OrderRequestRepository orderRequestRepo;

	public OrderRequestController(OrderRequestRepository orderRequestRepo) {
		this.orderRequestRepo = orderRequestRepo;
	}
	
	
	@GetMapping("/order_requests.html")
	public String showTradeList(Map<String, Object> model) {
		OrderRequests orderRequests = new OrderRequests();
		orderRequests.getOrderRequestList().addAll(this.orderRequestRepo.findAll());
		model.put("orderRequests", orderRequests);
		return "orders/orderRequestList";
	}
	
	
	@GetMapping({ "/orderRequests" })
	public @ResponseBody OrderRequests showResourcesTradeList() {
		OrderRequests trades = new OrderRequests();
		trades.getOrderRequestList().addAll(this.orderRequestRepo.findAll());
		return trades;
	}
	

}
