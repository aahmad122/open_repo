package com.n26.stats.transaction.vo;

import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.util.concurrent.AtomicDouble;

public class SecondStats {

	private AtomicDouble time;

	private AtomicDouble sum;
	private AtomicInteger count;
	private AtomicDouble min;
	private AtomicDouble max;

	public SecondStats() {
		sum = new AtomicDouble();
		count = new AtomicInteger();
		min = new AtomicDouble(Double.MAX_VALUE);
		max = new AtomicDouble(0);
		time = new AtomicDouble();
	}

	public AtomicDouble getTime() {
		return time;
	}

	public void setTime(AtomicDouble time) {
		this.time = time;
	}

	public AtomicInteger getCount() {
		return count;
	}

	public void setCount(AtomicInteger count) {
		this.count = count;
	}

	public AtomicDouble getMin() {
		return min;
	}

	public void setMin(AtomicDouble min) {
		this.min = min;
	}

	public AtomicDouble getMax() {
		return max;
	}

	public void setMax(AtomicDouble max) {
		this.max = max;
	}

	public AtomicDouble getSum() {
		return sum;
	}

	public void setSum(AtomicDouble sum) {
		this.sum = sum;
	}

}
