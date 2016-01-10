package com.woldt.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GhcndDataDay {

	private String date; //yyyy-mm-dd
	private List<String> observedElements;
	private List<String> observedWeatherCodes;
	private Map<String, GhcndElement> elements;

	private Map<String, GhcndWeatherCode> weatherCodes;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getObservedElements() {
		if (observedElements == null) {
			observedElements = new ArrayList<>();
		}
		return observedElements;
	}

	public List<String> getObservedWeatherCodes() {
		if (observedWeatherCodes == null) {
			observedWeatherCodes = new ArrayList<>();
		}
		return observedWeatherCodes;
	}

	public Map<String, GhcndElement> getElements() {
		if (elements == null) {
			elements = new HashMap<>();
		}
		return elements;
	}

	public Map<String, GhcndWeatherCode> getWeatherCodes() {
		if (weatherCodes == null) {
			weatherCodes = new HashMap<>();
		}
		return weatherCodes;
	}

	@Override
	public String toString() {
		return "GhcndDataDay [date=" + date + ", observedElements="
				+ observedElements + ", observedWeatherCodes="
				+ observedWeatherCodes + ", elements=" + elements
				+ ", weatherCodes=" + weatherCodes + "]";
	}

}
