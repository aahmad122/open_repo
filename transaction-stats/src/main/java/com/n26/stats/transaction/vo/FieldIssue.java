package com.n26.stats.transaction.vo;

import java.io.Serializable;

public class FieldIssue implements Serializable{

	private String field;

	private String message;

	public FieldIssue(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}
}