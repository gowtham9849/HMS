package com.Medical.MEmergency.dto;

import java.time.LocalDateTime;

public class EmergencyDto {
	
	private String phoneNumber;
	private String diseaseType;
	private LocalDateTime reportedAt = LocalDateTime.now();
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDiseaseType() {
		return diseaseType;
	}
	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}
	public LocalDateTime getReportedAt() {
		return reportedAt;
	}
	public void setReportedAt(LocalDateTime reportedAt) {
		this.reportedAt = reportedAt;
	}

	
}
