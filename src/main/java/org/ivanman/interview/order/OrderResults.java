package org.ivanman.interview.order;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple domain object representing a list of order execution. 
 */

@XmlRootElement
public class OrderResults {

	private List<OrderResult> orderResults;

	@XmlElement
	public List<OrderResult> getOrderResultList() {
		if (orderResults == null) {
			orderResults = new ArrayList<>();
		}
		return orderResults;
	}

}
