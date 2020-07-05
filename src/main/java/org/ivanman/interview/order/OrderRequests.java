package org.ivanman.interview.order;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple domain object representing a list of trades. 
 */

@XmlRootElement
public class OrderRequests {

	private List<OrderRequest> orderRequests;

	@XmlElement
	public List<OrderRequest> getOrderRequestList() {
		if (orderRequests == null) {
			orderRequests = new ArrayList<>();
		}
		return orderRequests;
	}

}
