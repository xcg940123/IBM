package com.ibm.mics.entity.util;

public class MedicalCare {
	String kind;
	String range;
	String payment;
	String patientName;
	
	public MedicalCare(String kind, String range, String payment, String patientName) {
		this.kind = kind;
		this.range = range;
		this.payment = payment;
		this.patientName = patientName;
	}
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

}
