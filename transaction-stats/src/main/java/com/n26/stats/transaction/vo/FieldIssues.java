package com.n26.stats.transaction.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FieldIssues implements Serializable{

	private List<FieldIssue> fieldIssues = new ArrayList<>();


	public void addFieldIssue(String path, String message) {
		FieldIssue issue = new FieldIssue(path, message);
		fieldIssues.add(issue);
	}
	
	public List<FieldIssue> getFieldIssues() {
		return fieldIssues;
	}
	
}
