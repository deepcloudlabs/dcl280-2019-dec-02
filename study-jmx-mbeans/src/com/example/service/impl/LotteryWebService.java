package com.example.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.jws.WebService;

import com.example.jmx.MonitoringSample;
import com.example.jmx.WebServiceQualitySamplerMXBean;
import com.example.service.LotteryService;

@WebService(endpointInterface="com.example.service.LotteryService")
public class LotteryWebService
            extends Observable
            implements 
            LotteryService, WebServiceQualitySamplerMXBean {
	private int counter;
	private long totalResponseTime;

	public LotteryWebService() {
	}

	private Random random= new Random();

	@Override
	public Collection<Integer> draw(int min, int max, int size, boolean sorted){
		++counter;
		long start= System.nanoTime();
		IntStream intStream = random.ints(min,max)
				                    .distinct()
				                    .limit(size);
		if (sorted)
			intStream= intStream.sorted();
		List<Integer> numbers = 
				     intStream.boxed()
				              .collect(Collectors.toList());
		long stop= System.nanoTime();
		totalResponseTime += stop - start;
		double averageResponseTime= 
			      ((double)totalResponseTime)/counter;
		if (averageResponseTime>200_000.){
			setChanged();
			notifyObservers(getQualitySample());
		}
		return numbers;
	}

	@Override
	public MonitoringSample getQualitySample() {
		Date now= new Date();
		double averageResponseTime= 
				      ((double)totalResponseTime)/counter;
		return 
		  new MonitoringSample(now, counter, averageResponseTime);
	}

	@Override
	public void reset() {
		counter=0;
		totalResponseTime= 0L;
	}

}
