package org.ivanman.interview.order;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class OrderResultController {

	private final OrderResultRepository orderResultRepo;

	public OrderResultController(OrderResultRepository orderResultRepo) {
		this.orderResultRepo = orderResultRepo;
	}
	
	
	@GetMapping("/order_results.html")
	public String showTradeList(Map<String, Object> model) {
		OrderResults orderResults = new OrderResults();
		orderResults.getOrderResultList().addAll(this.orderResultRepo.findAll());
		model.put("orderResults", orderResults);
		return "orders/orderResultList";
	}
	
	
	@GetMapping({ "/orderResults" })
	public @ResponseBody OrderResults showResourcesTradeList() {
		OrderResults results = new OrderResults();
		results.getOrderResultList().addAll(this.orderResultRepo.findAll());
		return results;
	}
	

}
