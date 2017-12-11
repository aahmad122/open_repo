package com.n26.stats.transaction.vo;

public class Stats {

	private double max;
	private double min;
	private double avg;
	private double sum;
	private int count;

	public Stats(double sum, double avg, double min, double max, int count) {
		this.sum = sum;
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.count = count;
	}

	public double getMax() {
		return Math.round(max * 100D) / 100D;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return Math.round(min * 100D) / 100D;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getAvg() {
		return Math.round(avg * 100D) / 100D;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getSum() {
		return Math.round(sum * 100D) / 100D;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
