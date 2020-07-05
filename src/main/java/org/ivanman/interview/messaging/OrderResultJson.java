package org.ivanman.interview.messaging;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class OrderResultJson {

	/*
	 {"userId": "134256", 
	  "order_result_status": "",
	  "time_executed": "24-JAN-18 10:27:44", 
	  "execution_venue": "",
	  "order_request_id": ""
	  }
	 */

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("order_result_status")
	private String orderResultStatus;

	@JsonProperty("time_executed")
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	private Date timeExecuted;

	@JsonProperty("execution_venue")
	private String executionVenue;

	@JsonProperty("order_request_id")
	private Long orderRequestId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderResultStatus() {
		return orderResultStatus;
	}

	public void setOrderResultStatus(String orderResultStatus) {
		this.orderResultStatus = orderResultStatus;
	}

	public Date getTimeExecuted() {
		return timeExecuted;
	}

	public void setTimeExecuted(Date timeExecuted) {
		this.timeExecuted = timeExecuted;
	}

	public String getExecutionVenue() {
		return executionVenue;
	}

	public void setExecutionVenue(String executionVenue) {
		this.executionVenue = executionVenue;
	}

	public Long getOrderRequestId() {
		return orderRequestId;
	}

	public void setOrderRequestId(Long orderRequestId) {
		this.orderRequestId = orderRequestId;
	}

}
