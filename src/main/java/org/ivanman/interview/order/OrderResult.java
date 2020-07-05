package org.ivanman.interview.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.ivanman.interview.model.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Simple JavaBean domain object representing a order execution result.
 *
 */
@Entity
@Table(name = "order_results")
public class OrderResult extends BaseEntity {

	@Column(name = "user_id")
	@NotEmpty
	private String userId;


	@Column(name = "order_result_status")
	@NotEmpty
	private String orderResultStatus;

	@Column(name = "time_executed")
	@DateTimeFormat(pattern = "yyyy-MMM-dd HH:mm:ss")
	private Date timeExecuted;

	@Column(name = "execution_venue")
	@NotEmpty
	private String executionVenue;
	
	
	
	
	
	@OneToOne
	@JoinColumn(name = "order_request_id")
	private OrderRequest orderRequest;

	
	public void setOrderRequest(OrderRequest orderRequest) {
		this.orderRequest = orderRequest;
	}

	
	
	

	public OrderRequest getOrderRequest() {
		return orderRequest;
	}

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

}
