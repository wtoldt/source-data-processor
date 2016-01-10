package com.woldt.factories;

public class AbstractGhcndFactory {

	protected final static String C = "celcius";
	protected final static String CM = "centimeters";
	protected final static String DAYS = "days";
	protected final static String DEG = "degrees";
	protected final static String KM = "kilometers";
	protected final static String MINUTES = "minutes";
	protected final static String MM = "millimeters";
	protected final static String MPS = "meters per second";
	protected final static String PERCENT = "percent";
	protected final static String TIME = "time";

	protected static String getMeasurementFlagDescription(final String measurementFlag) {
		switch (measurementFlag) {
		case " ":
			return "no measurement information applicable";
		case "B":
			return "precipitation total formed from two 12-hour totals";
		case "D":
			return "precipitation total formed from four six-hour totals";
		case "H":
			return "represents highest or lowest hourly temperature (TMAX or TMIN) or the average of hourly values (TAVG)";
		case "K":
			return "converted from knots";
		case "L":
			return "temperature appears to be lagged with respect to reported hour of observation";
		case "O":
			return "converted from oktas";
		case "P":
			return "identified as \"missing presumed zero\" in DSI 3200 and 3206";
		case "T":
			return "trace of precipitation, snowfall, or snow depth";
		case "W":
			return "converted from 16-point WBAN code (for wind direction)";
		default:
			return null;
		}
	}

	protected static String getQualityFlagDescription(final String qualityFlag) {
		switch (qualityFlag) {
		case " ":
			return "did not fail any quality assurance check";
		case "G":
			return "failed gap check";
		case "I":
			return "failed internal consistency check";
		case "K":
			return "failed streak/frequent-value check";
		case "L":
			return "failed check on length of multiday period ";
		case "M":
			return "failed megaconsistency check";
		case "N":
			return "failed naught check";
		case "O":
			return "failed climatological outlier check";
		case "R":
			return "failed lagged range check";
		case "S":
			return "failed spatial consistency check";
		case "T":
			return "failed temporal consistency check";
		case "W":
			return "temperature too warm for snow";
		case "X":
			return "failed bounds check";
		case "Z":
			return "flagged as a result of an official Datzilla investigation";
		default:
			return null;
		}
	}

	protected static String getSourceFlagDescription(final String sourceFlag) {
		switch(sourceFlag) {
		case " ":
			return "No source (i.e., data value missing)";
		case "0":
			return "U.S. Cooperative Summary of the Day (NCDC DSI-3200)";
		case "6":
			return "CDMP Cooperative Summary of the Day (NCDC DSI-3206)";
		case "7":
			return "U.S. Cooperative Summary of the Day -- Transmitted via WxCoder3 (NCDC DSI-3207)";
		case "A":
			return "U.S. Automated Surface Observing System (ASOS) real-time data (since January 1, 2006)";
		case "a":
			return "Australian data from the Australian Bureau of Meteorology";
		case "B":
			return "U.S. ASOS data for October 2000-December 2005 (NCDC DSI-3211)";
		case "b":
			return "Belarus update";
		case "C":
			return "Environment Canada";
		case "E":
			return "European Climate Assessment and Dataset (Klein Tank et al., 2002)";
		case "F":
			return "U.S. Fort data";
		case "G":
			return "Official Global Climate Observing System (GCOS) or other government-supplied data";
		case "H":
			return "High Plains Regional Climate Center real-time data";
		case "I":
			return "International collection (non U.S. data received through personal contacts)";
		case "K":
			return "U.S. Cooperative Summary of the Day data digitized from paper observer forms (from 2011 to present)";
		case "M":
			return "Monthly METAR Extract (additional ASOS data)";
		case "N":
			return "Community Collaborative Rain, Hail,and Snow (CoCoRaHS)";
		case "Q":
			return "Data from several African countries that had been \"quarantined\", that is, withheld from public release until permission was granted from the respective meteorological services";
		case "R":
			return "NCEI Reference Network Database (Climate Reference Network and Regional Climate Reference Network)";
		case "r":
			return "All-Russian Research Institute of Hydrometeorological Information-World Data Center";
		case "S":
			return "Global Summary of the Day (NCDC DSI-9618) NOTE: \"S\" values are derived from hourly synoptic reports exchanged on the Global Telecommunications System (GTS). Daily values derived in this fashion may differ significantly from \"true\" daily data, particularly for precipitation (i.e., use with caution).";
		case "s":
			return "China Meteorological Administration/National Meteorological Information Center Climatic Data Center";
		case "T":
			return "SNOwpack TELemtry (SNOTEL) data obtained from the U.S. Department of Agriculture's Natural Resources Conservation Service";
		case "U":
			return "Remote Automatic Weather Station (RAWS) data obtained from the Western Regional Climate Center";
		case "u":
			return "Ukraine update";
		case "W":
			return "WBAN/ASOS Summary of the Day from NCDC's Integrated Surface Data (ISD).";
		case "X":
			return "U.S. First-Order Summary of the Day (NCDC DSI-3210)";
		case "Z":
			return "Datzilla official additions or replacements";
		case "z":
			return "Uzbekistan update";
		default:
			return null;
		}
	}
}
