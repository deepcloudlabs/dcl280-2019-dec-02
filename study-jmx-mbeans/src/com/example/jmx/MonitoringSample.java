package com.example.jmx;

import java.beans.ConstructorProperties;
import java.util.Date;

// Immutable
public class MonitoringSample {
	private final Date date;
	private final int counter;
	private final double averageResponseTime;
	
	@ConstructorProperties({"date","counter","averageResponseTime"})
	public MonitoringSample(Date date, int counter, double averageResponseTime) {
		this.date = date;
		this.counter = counter;
		this.averageResponseTime = averageResponseTime;
	}

	public Date getDate() {
		return date;
	}

	public int getCounter() {
		return counter;
	}

	public double getAverageResponseTime() {
		return averageResponseTime;
	}

	@Override
	public String toString() {
		return "MonitoringSample [date=" + date + ", counter=" + counter + ", averageResponseTime="
				+ averageResponseTime + "]";
	}
	
	
}
