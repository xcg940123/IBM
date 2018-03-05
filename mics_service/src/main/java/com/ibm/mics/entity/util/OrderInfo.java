package com.ibm.mics.entity.util;

public class OrderInfo {
	
	String orderName;
	String certifitype;
	String certifiNumber;
	String sex;
	String birthday;
	String phonenumber;
	String email;
	
	public OrderInfo(String orderName, String certifitype, String certifiNumber, String sex, String birthday,
			String phonenumber, String email) {
		this.orderName = orderName;
		this.certifitype = certifitype;
		this.certifiNumber = certifiNumber;
		this.sex = sex;
		this.birthday = birthday;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getCertifitype() {
		return certifitype;
	}
	public void setCertifitype(String certifitype) {
		this.certifitype = certifitype;
	}
	public String getCertifiNumber() {
		return certifiNumber;
	}
	public void setCertifiNumber(String certifiNumber) {
		this.certifiNumber = certifiNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
