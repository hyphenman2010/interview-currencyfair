package org.ivanman.interview.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Producer {

	@Autowired
	private Queue queue;

	@Autowired
	private JmsTemplate jmsTemplate;

	@PostMapping("publish")
	public @ResponseBody String publish(@RequestParam("msg") String msg) {
		if (msg == null) {
			System.err.println("ERROR: msg is null");
		}
		try {
			jmsTemplate.convertAndSend(queue, msg);
		} catch (Exception e) {
			System.err.println("Error on sending msg to jms");
			System.err.println(e.toString());
		}
		return "{\"result\": \"received\"}";
	}

}
