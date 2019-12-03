package com.example.ui;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.xml.ws.Endpoint;

import com.example.jmx.WebServiceQualitySampler;
import com.example.service.impl.LotteryWebService;

public class LotteryApp {

	public static void main(String[] args) throws Exception {
		MBeanServer mBeanServer= 
				ManagementFactory.getPlatformMBeanServer();
		LotteryWebService lotteryService= new LotteryWebService();
		WebServiceQualitySampler wsqs= 
				new WebServiceQualitySampler(lotteryService);
		ObjectName mbeanName= new ObjectName(
				"com.example.jmx:type=WebServiceQualitySampler"
		);
		lotteryService.addObserver(wsqs);
		mBeanServer.registerMBean(wsqs, mbeanName);
		String endpointUrl = "http://localhost:9002/lottery";
		Endpoint.publish(endpointUrl, lotteryService);
		System.out.println("Server is running on port 9001...");
	}

}
