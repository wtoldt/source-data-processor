package com.woldt.domain;

public class GhcndWeatherCode {

	private String id;
	private String description;
	private String measurementFlag;
	private String measurementFlagDescription;
	private String qualityFlag;
	private String qualityFlagDescription;
	private String sourceFlag;
	private String sourceFlagDescription;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeasurementFlag() {
		return measurementFlag;
	}

	public void setMeasurementFlag(String measurementFlag) {
		this.measurementFlag = measurementFlag;
	}

	public String getMeasurementFlagDescription() {
		return measurementFlagDescription;
	}

	public void setMeasurementFlagDescription(String measurementFlagDescription) {
		this.measurementFlagDescription = measurementFlagDescription;
	}

	public String getQualityFlag() {
		return qualityFlag;
	}

	public void setQualityFlag(String qualityFlag) {
		this.qualityFlag = qualityFlag;
	}

	public String getQualityFlagDescription() {
		return qualityFlagDescription;
	}

	public void setQualityFlagDescription(String qualityFlagDescription) {
		this.qualityFlagDescription = qualityFlagDescription;
	}

	public String getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(String sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public String getSourceFlagDescription() {
		return sourceFlagDescription;
	}

	public void setSourceFlagDescription(String sourceFlagDescription) {
		this.sourceFlagDescription = sourceFlagDescription;
	}

}
