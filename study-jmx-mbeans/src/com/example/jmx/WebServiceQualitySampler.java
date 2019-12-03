package com.example.jmx;

import java.util.Observable;
import java.util.Observer;

import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class WebServiceQualitySampler 
              extends NotificationBroadcasterSupport
              implements WebServiceQualitySamplerMXBean,Observer {
	private static final String QOS_VIOLATION_EVENT = 
			"com.example.jmx.WebServiceQualitySampler.QOS_VIOLATION_EVENT";
	private WebServiceQualitySamplerMXBean service;
	private int sequence;
	
	public WebServiceQualitySampler(WebServiceQualitySamplerMXBean service) {
		this.service = service;
	}

	@Override
	public MonitoringSample getQualitySample() {
		return service.getQualitySample();
	}

	@Override
	public void reset() {
		this.service.reset();
	}

	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		
		String []types= {QOS_VIOLATION_EVENT};
		String name= Notification.class.getName();
		String description= "Poor QoS";
		MBeanNotificationInfo info= 
				new MBeanNotificationInfo(types,name,description);
		return new MBeanNotificationInfo[] { info };
	}

	@Override
	public void update(Observable o, Object arg) {
		MonitoringSample sample= (MonitoringSample) arg;
		sequence++;
		Notification notification= 
				new Notification(
					"QoS is violated!", 
					sequence,
					System.currentTimeMillis(), 
					"Poor average response time: "
					    +sample.getAverageResponseTime());
		sendNotification(notification);
	}

}
