package org.ivanman.interview.order;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.ivanman.interview.model.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Simple JavaBean domain object representing a trade.
 *
 */
@Entity
@Table(name = "order_requests")
public class OrderRequest extends BaseEntity {

	@Column(name = "user_id")
	@NotEmpty
	private String userId;

	@Column(name = "currency_from")
	@NotEmpty
	private String currencyFrom;

	@Column(name = "currency_to")
	@NotEmpty
	private String currencyTo;

	@Column(name = "amount_sell")
	private BigDecimal amountSell;

	
	@Column(name = "amount_buy")
	private BigDecimal amountBuy;

	
	@Column(name = "rate")
	private BigDecimal rate;

	
	@Column(name = "time_placed")
	@DateTimeFormat(pattern = "yyyy-MMM-dd HH:mm:ss")
	private Date timePlaced;
	
	
	@Column(name = "originating_country")
	@NotEmpty
	private String originatingCountry;


	@OneToOne(cascade = CascadeType.ALL, mappedBy = "orderRequest")
	private OrderResult orderResult; 

	
	
	
	public void addOrderResult(OrderResult orderResult) {
		orderResult.setOrderRequest(this);
	}
	
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getCurrencyFrom() {
		return currencyFrom;
	}


	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}


	public String getCurrencyTo() {
		return currencyTo;
	}


	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}


	public BigDecimal getAmountSell() {
		return amountSell;
	}


	public void setAmountSell(BigDecimal amountSell) {
		this.amountSell = amountSell;
	}


	public BigDecimal getAmountBuy() {
		return amountBuy;
	}


	public void setAmountBuy(BigDecimal amountBuy) {
		this.amountBuy = amountBuy;
	}


	public BigDecimal getRate() {
		return rate;
	}


	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}


	public Date getTimePlaced() {
		return timePlaced;
	}


	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}


	public String getOriginatingCountry() {
		return originatingCountry;
	}


	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

	
	

}
