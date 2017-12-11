package com.n26.stats.transaction.stats.app;

import static org.testng.Assert.assertEquals;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.n26.stats.transaction.service.TransactionService;
import com.n26.stats.transaction.vo.NewTrasactionRequest;

public class AppTest extends BaseAppTest {
	@Autowired
	private TransactionService transactionService;

	@Test
	public void test() {
		NewTrasactionRequest transaction = new NewTrasactionRequest();
		transaction.setAmount(2.5f);
		transaction.setTimestamp(new Date().getTime());
		transactionService.addTransaction(transaction);

		assertEquals(transactionService.fetch().getSum(), (double) transaction.getAmount());
	}

	@Test
	public void test1() {
		NewTrasactionRequest transaction = new NewTrasactionRequest();
		transaction.setAmount(2.5f);
		transaction.setTimestamp(new Date().getTime());
		transactionService.addTransaction(transaction);

		assertEquals(transactionService.fetch().getMax(), (double) transaction.getAmount());
	}
}
