package com.woldt.factories;

import com.woldt.domain.GhcndWeatherCode;

public class GhcndWeatherCodeFactory extends AbstractGhcndFactory {

	public static GhcndWeatherCode getFromString(final String elementId, final String chunk) {
		final GhcndWeatherCode weatherCode = new GhcndWeatherCode();
		final String value = chunk.substring(0, 5);
		final String mFlag = chunk.substring(5, 6);
		final String qFlag = chunk.substring(6, 7);
		final String sFlag = chunk.substring(7, 8);

		if ("-9999".equalsIgnoreCase(value)) {
			return null;
		}

		weatherCode.setMeasurementFlag(mFlag);
		weatherCode.setMeasurementFlagDescription(
				getMeasurementFlagDescription(mFlag));

		weatherCode.setQualityFlag(qFlag);
		weatherCode.setQualityFlagDescription(
				getQualityFlagDescription(qFlag));

		weatherCode.setSourceFlag(sFlag);
		weatherCode.setSourceFlagDescription(
				getSourceFlagDescription(sFlag));

		switch (elementId) {
		case "WT01":
			weatherCode.setDescription("Fog, ice fog, or freezing fog (may include heavy fog)");
			break;
		case "WT02":
			weatherCode.setDescription("Heavy fog or heaving freezing fog (not always distinquished from fog)");
			break;
		case "WT03":
			weatherCode.setDescription("Thunder");
			break;
		case "WT04":
			weatherCode.setDescription("Ice pellets, sleet, snow pellets, or small hail");
			break;
		case "WT05":
			weatherCode.setDescription("Hail (may include small hail)");
			break;
		case "WT06":
			weatherCode.setDescription("Glaze or rime");
			break;
		case "WT07":
			weatherCode.setDescription("Dust, volcanic ash, blowing dust, blowing sand, or blowing obstruction");
			break;
		case "WT08":
			weatherCode.setDescription("Smoke or haze");
			break;
		case "WT09":
			weatherCode.setDescription("Blowing or drifting snow");
			break;
		case "WT10":
			weatherCode.setDescription("Tornado, waterspout, or funnel cloud");
			break;
		case "WT11":
			weatherCode.setDescription("High or damaging winds");
			break;
		case "WT12":
			weatherCode.setDescription("Blowing spray");
			break;
		case "WT13":
			weatherCode.setDescription("Mist");
			break;
		case "WT14":
			weatherCode.setDescription("Drizzle");
			break;
		case "WT15":
			weatherCode.setDescription("Freezing drizzle");
			break;
		case "WT16":
			weatherCode.setDescription("Rain (may include freezing rain, drizzle, and freezing drizzle)");
			break;
		case "WT17":
			weatherCode.setDescription("Freezing rain");
			break;
		case "WT18":
			weatherCode.setDescription("Snow, snow pellets, snow grains, or ice crystals");
			break;
		case "WT19":
			weatherCode.setDescription("Unknown source of precipitation");
			break;
		case "WT21":
			weatherCode.setDescription("Ground fog");
			break;
		case "WT22":
			weatherCode.setDescription("Ice fog or freezing fog");
			break;

		case "WV01":
			weatherCode.setDescription("Weather in the Vicinity: Fog, ice fog, or freezing fog (may include heavy fog)");
			break;
		case "WV03":
			weatherCode.setDescription("Weather in the Vicinity: Thunder");
			break;
		case "WV07":
			weatherCode.setDescription("Weather in the Vicinity: Ash, dust, sand, or other blowing obstruction");
			break;
		case "WV18":
			weatherCode.setDescription("Weather in the Vicinity: Snow or ice crystals");
			break;
		case "WV20":
			weatherCode.setDescription("Weather in the Vicinity: Rain or snow shower");
			break;
		}


		return weatherCode;
	}
}
