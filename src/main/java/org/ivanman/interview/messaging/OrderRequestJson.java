package org.ivanman.interview.messaging;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class OrderRequestJson {

	/*
	 {"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP",
	  "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471,
	  "timePlaced" : "24-JAN-18 10:27:44", "originatingCountry" : "FR"}
	 */

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("currencyFrom")
	private String currencyFrom;

	@JsonProperty("currencyTo")
	private String currencyTo;

	@JsonProperty("amountSell")
	private BigDecimal amountSell;

	@JsonProperty("amountBuy")
	private BigDecimal amountBuy;

	@JsonProperty("rate")
	private BigDecimal rate;

	@JsonProperty("timePlaced")
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	private Date timePlaced;

	@JsonProperty("originatingCountry")
	private String originatingCountry;

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
