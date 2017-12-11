package com.n26.stats.transaction.service;

import com.n26.stats.transaction.vo.NewTrasactionRequest;

public interface ITransactionService {

	public void addTransaction(NewTrasactionRequest transaction);
}
