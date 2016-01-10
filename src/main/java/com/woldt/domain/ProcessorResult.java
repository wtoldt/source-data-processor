package com.woldt.domain;

import java.time.Duration;
import java.time.Instant;


public class ProcessorResult {

	private String processorName;
	private Instant startTime;
	private Long startTimeInMillis;
	private Instant endTime;

	private Long endTimeInMillis;

	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}

	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}

	public void setStartTimeInMillis(Long startTimeInMillis) {
		this.startTimeInMillis = startTimeInMillis;
	}

	public void setEndTime(Instant endTime) {
		this.endTime = endTime;
	}

	public void setEndTimeInMillis(Long endTimeInMillis) {
		this.endTimeInMillis = endTimeInMillis;
	}

	public Long getTotalTimeInMillis() {
		return endTimeInMillis - startTimeInMillis;
	}

	public String getTotalTime() {
		return Duration.between(startTime, endTime).toString();
	}

	@Override
	public String toString() {
		return "ProcessorResult [processorName=" + processorName
				+ ", startTime=" + startTime + ", startTimeInMillis="
				+ startTimeInMillis + ", endTime=" + endTime
				+ ", endTimeInMillis=" + endTimeInMillis
				+ ", getTotalTimeInMillis()=" + getTotalTimeInMillis()
				+ ", getTotalTime()=" + getTotalTime() + "]";
	}

}
