package com.n26.stats.transaction.util;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.LongStream;

import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.AtomicDouble;
import com.n26.stats.transaction.vo.NewTrasactionRequest;
import com.n26.stats.transaction.vo.SecondStats;
import com.n26.stats.transaction.vo.Stats;

@Component
public class StatsManager implements IStoreManager {

	private Map<Long, SecondStats> stats = new ConcurrentHashMap<>();

	private Integer seconds = 60;

	public StatsManager() {
		init();
	}

	public void init() {
		long d = new Date().getTime() / 1000;
		LongStream.range(0, seconds).forEach(i -> {
			SecondStats value = new SecondStats();
			value.getTime().set(d);
			stats.put(i, value);
		});
	}

	public void store(NewTrasactionRequest transaction) {
		clearOld();
		long curTime = new Date().getTime() / 1000;
		Long timestamp = transaction.getTimestamp() / 1000;

		Integer sec = (int) (curTime - timestamp);
		if (sec < seconds) {
			if (stats.containsKey(timestamp)) {
				SecondStats e = stats.get(timestamp);
				e.getCount().incrementAndGet();
				e.getSum().addAndGet(transaction.getAmount());
				e.getMin().compareAndSet(
						e.getMin().get() > transaction.getAmount() ? e.getMin().get() : transaction.getAmount(),
						transaction.getAmount());
				e.getMax().compareAndSet(
						e.getMin().get() < transaction.getAmount() ? e.getMin().get() : transaction.getAmount(),
						transaction.getAmount());

				stats.put(timestamp, e);
			} else {
				SecondStats e = new SecondStats();
				e.setTime(new AtomicDouble(timestamp));
				e.getCount().set(1);
				e.getSum().set(transaction.getAmount());
				e.getMin().set(transaction.getAmount());
				e.getMax().set(transaction.getAmount());
				stats.put(timestamp, e);
			}
		}
	}

	private void clearOld() {
		stats.entrySet().removeIf(i -> (i.getKey() + seconds) < (new Date().getTime() / 1000));
	}

	@Override
	public Stats fetch() {
		clearOld();
		double sum = 0;
		double avg = 0;
		double min = Double.MAX_VALUE;
		double max = 0;
		int count = 0;
		boolean flag = false;
		for (Entry<Long, SecondStats> stat : stats.entrySet()) {
			sum = sum + stat.getValue().getSum().get();
			count = count + stat.getValue().getCount().get();
			if (min > stat.getValue().getMin().get()) {
				flag = true;
				min = stat.getValue().getMin().get();
			}
			if (max < stat.getValue().getMax().get()) {
				max = stat.getValue().getMax().get();
			}
		}
		if (!flag)
			min = 0;
		int count1 = count == 0 ? 1 : count;
		avg = sum / count1;
		return new Stats(sum, avg, min, max, count);

	}
}
