package com.woldt.factories;

import org.apache.log4j.Logger;

import com.woldt.domain.GhcndElement;

public class GhcndElementFactory extends AbstractGhcndFactory {

	private final static Logger LOGGER = Logger.getLogger(GhcndElementFactory.class);

	public static GhcndElement getFromString(final String elementId, final String chunk) {
		final String value = chunk.substring(0, 5);
		final String mFlag = chunk.substring(5, 6);
		final String qFlag = chunk.substring(6, 7);
		final String sFlag = chunk.substring(7, 8);
		final GhcndElement element = getElementFromId(elementId, value);

		if (element == null) {
			LOGGER.error("Element is null! (" + elementId + ")");
		}

		if ("-9999".equalsIgnoreCase(value)) {
			return null;
		}

		element.setMeasurementFlag(mFlag);
		element.setMeasurementFlagDescription(
				getMeasurementFlagDescription(mFlag));

		element.setQualityFlag(qFlag);
		element.setQualityFlagDescription(
				getQualityFlagDescription(qFlag));

		element.setSourceFlag(sFlag);
		element.setSourceFlagDescription(
				getSourceFlagDescription(sFlag));

		return element;
	}

	protected static GhcndElement getElementFromId(final String elementId, final String stringValue) {
		final GhcndElement element = new GhcndElement();
		element.setId(elementId);
		final Double value = Double.valueOf(stringValue.trim());

		switch (elementId) {
		case "PRCP":
			element.setDescription("Precipitation (tenths of mm)");
			element.setUnit(MM);
			element.setValue(value/10);
			return element;
		case "SNOW":
			element.setDescription("Snowfall (mm)");
			element.setUnit(MM);
			element.setValue(value);
			return element;
		case "SNWD":
			element.setDescription("Snow depth (mm)");
			element.setUnit(MM);
			element.setValue(value);
			return element;
		case "TMAX":
			element.setDescription("Maximum temperature (tenths of degrees C)");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "TMIN":
			element.setDescription("Minimum temperature (tenths of degrees C)");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "ACMC":
			element.setDescription("Average cloudiness midnight to midnight from 30-second ceilometer data (percent)");
			element.setUnit(PERCENT);
			element.setValue(value);
			return element;
		case "ACMH":
			element.setDescription("Average cloudiness midnight to midnight from manual observations (percent)");
			element.setUnit(PERCENT);
			element.setValue(value);
			return element;
		case "ACSC":
			element.setDescription("Average cloudiness sunrise to sunset from 30-second ceilometer data (percent)");
			element.setUnit(PERCENT);
			element.setValue(value);
			return element;
		case "ACSH":
			element.setDescription("Average cloudiness sunrise to sunset from manual observations (percent)");
			element.setUnit(PERCENT);
			element.setValue(value);
			return element;
		case "AWDR":
			element.setDescription("Average daily wind direction (degrees)");
			element.setUnit(DEG);
			element.setValue(value);
			return element;
		case "AWND":
			element.setDescription("Average daily wind speed (tenths of meters per second)");
			element.setUnit(MPS);
			element.setValue(value/10);
			return element;
		case "DAEV":
			element.setDescription("Number of days included in the multiday evaporation total (MDEV)");
			element.setUnit(DAYS);
			element.setValue(value);
			return element;
		case "DAPR":
			element.setDescription("Number of days included in the multiday precipiation total (MDPR)");
			element.setUnit(DAYS);
			element.setValue(value);
			return element;
		case "DASF":
			element.setDescription("Number of days included in the multiday snowfall total (MDSF)");
			element.setUnit(DAYS);
			element.setValue(value);
			return element;
		case "DATN":
			element.setDescription("Number of days included in the multiday minimum temperature (MDTN)");
			element.setUnit(DAYS);
			element.setValue(value);
			return element;
		case "DATX":
			element.setDescription("Number of days included in the multiday maximum temperature (MDTX)");
			element.setUnit(DAYS);
			element.setValue(value);
			return element;
		case "DAWM":
			element.setDescription("Number of days included in the multiday wind movement (MDWM)");
			element.setUnit(DAYS);
			element.setValue(value);
			return element;
		case "DWPR":
			element.setDescription("Number of days with non-zero precipitation included in multiday precipitation total (MDPR)");
			element.setUnit(DAYS);
			element.setValue(value);
			return element;
		case "EVAP":
			element.setDescription("Evaporation of water from evaporation pan (tenths of mm)");
			element.setUnit(MM);
			element.setValue(value/10);
			return element;
		case "FMTM":
			element.setDescription("Time of fastest mile or fastest 1-minute wind (hours and minutes, i.e., HHMM)");
			element.setUnit(TIME);
			element.setValue(value);
			return element;
		case "FRGB":
			element.setDescription("Base of frozen ground layer (cm)");
			element.setUnit(CM);
			element.setValue(value);
			return element;
		case "FRGT":
			element.setDescription("Top of frozen ground layer (cm)");
			element.setUnit(CM);
			element.setValue(value);
			return element;
		case "FRTH":
			element.setDescription("Thickness of frozen ground layer (cm)");
			element.setUnit(CM);
			element.setValue(value);
			return element;
		case "GAHT":
			element.setDescription("Difference between river and gauge height (cm)");
			element.setUnit(CM);
			element.setValue(value);
			return element;
		case "MDEV":
			element.setDescription("Multiday evaporation total (tenths of mm; use with DAEV)");
			element.setUnit(MM);
			element.setValue(value/10);
			return element;
		case "MDPR":
			element.setDescription("Multiday precipitation total (tenths of mm; use with DAPR and DWPR, if available)");
			element.setUnit(MM);
			element.setValue(value/10);
			return element;
		case "MDSF":
			element.setDescription("Multiday snowfall total");
			element.setUnit(DAYS);
			element.setValue(value);
			return element;
		case "MDTN":
			element.setDescription("Multiday minimum temperature (tenths of degrees C; use with DATN)");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "MDTX":
			element.setDescription("Multiday maximum temperature (tenths of degress C; use with DATX)");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "MDWM":
			element.setDescription("Multiday wind movement (km) MNPN = Daily minimum temperature of water in an evaporation pan (tenths of degrees C)");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "MXPN":
			element.setDescription("Daily maximum temperature of water in an evaporation pan (tenths of degrees C)");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "PGTM":
			element.setDescription("Peak gust time (hours and minutes, i.e., HHMM)");
			element.setUnit(TIME);
			element.setValue(value);
			return element;
		case "PSUN":
			element.setDescription("Daily percent of possible sunshine (percent)");
			element.setUnit(PERCENT);
			element.setValue(value);
			return element;
		case "SN01":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of unknown ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN02":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of unknown ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN03":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of unknown ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN04":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of unknown ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN05":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of unknown ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN06":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of unknown ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN07":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of unknown ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN11":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN12":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN13":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN14":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN15":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN16":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN17":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN21":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of fallow ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN22":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of fallow ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN23":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of fallow ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN24":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of fallow ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN25":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of fallow ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN26":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of fallow ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN27":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of fallow ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN31":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN32":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN33":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN34":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN35":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN36":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN37":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN41":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of brome grass ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN42":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of brome grass ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN43":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of brome grass ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN44":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of brome grass ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN45":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of brome grass ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN46":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of brome grass ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN47":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of brome grass ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN51":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of sod cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN52":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of sod cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN53":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of sod cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN54":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of sod cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN55":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of sod cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN56":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of sod cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN57":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of sod cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN61":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of straw multch ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN62":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of straw multch ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN63":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of straw multch ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN64":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of straw multch ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN65":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of straw multch ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN66":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of straw multch ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN67":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of straw multch ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN71":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass muck ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN72":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass muck ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN73":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass muck ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN74":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass muck ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN75":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass muck ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN76":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass muck ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN77":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of grass muck ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN81":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare muck ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN82":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare muck ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN83":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare muck ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN84":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare muck ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN85":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare muck ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN86":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare muck ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SN87":
			element.setDescription("Minimum soil temperature (tenths of degrees C) of bare muck ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX01":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of unknown ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX02":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of unknown ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX03":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of unknown ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX04":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of unknown ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX05":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of unknown ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX06":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of unknown ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX07":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of unknown ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX11":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX12":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX13":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX14":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX15":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX16":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX17":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX21":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of fallow ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX22":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of fallow ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX23":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of fallow ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX24":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of fallow ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX25":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of fallow ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX26":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of fallow ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX27":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of fallow ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX31":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX32":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX33":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX34":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX35":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX36":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX37":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX41":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of brome grass ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX42":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of brome grass ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX43":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of brome grass ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX44":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of brome grass ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX45":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of brome grass ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX46":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of brome grass ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX47":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of brome grass ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX51":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of sod cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX52":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of sod cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX53":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of sod cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX54":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of sod cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX55":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of sod cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX56":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of sod cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX57":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of sod cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX61":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of straw multch ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX62":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of straw multch ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX63":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of straw multch ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX64":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of straw multch ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX65":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of straw multch ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX66":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of straw multch ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX67":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of straw multch ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX71":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass muck ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX72":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass muck ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX73":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass muck ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX74":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass muck ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX75":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass muck ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX76":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass muck ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX77":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of grass muck ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX81":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare muck ground cover at 5 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX82":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare muck ground cover at 10 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX83":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare muck ground cover at 20 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX84":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare muck ground cover at 50 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX85":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare muck ground cover at 100 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX86":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare muck ground cover at 150 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "SX87":
			element.setDescription("Maximum soil temperature (tenths of degrees C) of bare muck ground cover at 180 cm");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "TAVG":
			element.setDescription("Average temperature (tenths of degrees C) [Note that TAVG from source 'S' corresponds to an average for the period ending at 2400 UTC rather than local midnight]");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "THIC":
			element.setDescription("Thickness of ice on water (tenths of mm)");
			element.setUnit(MM);
			element.setValue(value/10);
			return element;
		case "TOBS":
			element.setDescription("Temperature at the time of observation (tenths of degrees C)");
			element.setUnit(C);
			element.setValue(value/10);
			return element;
		case "TSUN":
			element.setDescription("Daily total sunshine (minutes)");
			element.setUnit(MINUTES);
			element.setValue(value);
			return element;
		case "WDF1":
			element.setDescription("Direction of fastest 1-minute wind (degrees)");
			element.setUnit(DEG);
			element.setValue(value);
			return element;
		case "WDF2":
			element.setDescription("Direction of fastest 2-minute wind (degrees)");
			element.setUnit(DEG);
			element.setValue(value);
			return element;
		case "WDF5":
			element.setDescription("Direction of fastest 5-second wind (degrees)");
			element.setUnit(DEG);
			element.setValue(value);
			return element;
		case "WDFG":
			element.setDescription("Direction of peak wind gust (degrees)");
			element.setUnit(DEG);
			element.setValue(value);
			return element;
		case "WDFI":
			element.setDescription("Direction of highest instantaneous wind (degrees)");
			element.setUnit(DEG);
			element.setValue(value);
			return element;
		case "WDFM":
			element.setDescription("Fastest mile wind direction (degrees)");
			element.setUnit(DEG);
			element.setValue(value);
			return element;
		case "WDMV":
			element.setDescription("24-hour wind movement (km)");
			element.setUnit(KM);
			element.setValue(value);
			return element;
		case "WESD":
			element.setDescription("Water equivalent of snow on the ground (tenths of mm)");
			element.setUnit(MM);
			element.setValue(value/10);
			return element;
		case "WESF":
			element.setDescription("Water equivalent of snowfall (tenths of mm)");
			element.setUnit(MM);
			element.setValue(value/10);
			return element;
		case "WSF1":
			element.setDescription("Fastest 1-minute wind speed (tenths of meters per second)");
			element.setUnit(MPS);
			element.setValue(value/10);
			return element;
		case "WSF2":
			element.setDescription("Fastest 2-minute wind speed (tenths of meters per second)");
			element.setUnit(MPS);
			element.setValue(value/10);
			return element;
		case "WSF5":
			element.setDescription("Fastest 5-second wind speed (tenths of meters per second)");
			element.setUnit(MPS);
			element.setValue(value/10);
			return element;
		case "WSFG":
			element.setDescription("Peak gust wind speed (tenths of meters per second)");
			element.setUnit(MPS);
			element.setValue(value/10);
			return element;
		case "WSFI":
			element.setDescription("Highest instantaneous wind speed (tenths of meters per second)");
			element.setUnit(MPS);
			element.setValue(value/10);
			return element;
		case "WSFM":
			element.setDescription("Fastest mile wind speed (tenths of meters per second)");
			element.setUnit(MPS);
			element.setValue(value/10);
			return element;


		default :
			return null;
		}
	}
}
