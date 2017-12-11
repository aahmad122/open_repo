package com.n26.stats.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.stats.transaction.util.StatsManager;
import com.n26.stats.transaction.vo.NewTrasactionRequest;
import com.n26.stats.transaction.vo.Stats;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private StatsManager statsManager;

	public void addTransaction(NewTrasactionRequest transaction) {
		statsManager.store(transaction);
	}

	public Stats fetch() {
		return statsManager.fetch();
	}

}
