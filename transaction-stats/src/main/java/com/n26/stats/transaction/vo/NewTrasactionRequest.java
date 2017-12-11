package com.n26.stats.transaction.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NewTrasactionRequest {

	@Min(value = 0, message = "Amount cannot be lesser than 0")
	@NotNull(message = "Amount is mandatory")
	private float amount;

	@NotNull(message = "Timestamp is mandatory")
	private Long timestamp;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
