package com.example.jmx;

public interface WebServiceQualitySamplerMXBean {
	public MonitoringSample getQualitySample();
	public void reset();
}
