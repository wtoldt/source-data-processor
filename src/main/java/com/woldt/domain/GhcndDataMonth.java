package com.woldt.domain;

import java.util.HashMap;
import java.util.Map;

public class GhcndDataMonth {

	private String stationId;
	private String date; //yyyy-mm
	private Map<String, GhcndDataDay> days;

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Map<String, GhcndDataDay> getDays() {
		if (days == null) {
			days = new HashMap<String, GhcndDataDay>();
		}
		return days;
	}

	public void setDays(Map<String, GhcndDataDay> days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "GhcndDataMonth [stationId=" + stationId + ", date=" + date
				+ ", days=" + days + "]";
	}
}
