package com.n26.stats.transaction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.n26.stats.transaction.annotation.TimeRangeValidator;
import com.n26.stats.transaction.service.TransactionService;
import com.n26.stats.transaction.vo.NewTrasactionRequest;
import com.n26.stats.transaction.vo.Stats;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private TimeRangeValidator timeRangeValidator;

	@RequestMapping(method = RequestMethod.POST, value = "/transactions")
	public ResponseEntity<Object> addTransaction(@Valid @RequestBody NewTrasactionRequest transaction) {

		/*
		 * Should be moved to filter to directly return call to caller by just
		 * looking at the timestamp
		 * 
		 */
		if (timeRangeValidator.isValid(transaction.getTimestamp())) {
			transactionService.addTransaction(transaction);
			return ResponseEntity.status(201).build();
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/statistics")
	public ResponseEntity<Stats> fetchTransactionStats() {
		return ResponseEntity.status(201).body(transactionService.fetch());
	}
}
