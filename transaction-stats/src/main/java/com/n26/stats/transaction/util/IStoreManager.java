package com.n26.stats.transaction.util;

import com.n26.stats.transaction.vo.NewTrasactionRequest;
import com.n26.stats.transaction.vo.Stats;

public interface IStoreManager {
	public void init();

	public void store(NewTrasactionRequest transaction);

	public Stats fetch();
}
