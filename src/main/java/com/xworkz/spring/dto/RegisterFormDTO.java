package com.xworkz.spring.dto;

import org.apache.log4j.Logger;

public class RegisterFormDTO {

	private static final Logger logger = Logger.getLogger(RegisterFormDTO.class);
	private int id;
	private String name;
	private String mobileNumber;
	private String address;
	private String age;
	private String emailId;
	private String password;
	private String state;

	private String date;
	private String numberOfPersons;
	private String selist;
	private String prasada;
	private String idCard;
	private String idNumber;
	private String ptList;

	public RegisterFormDTO() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(String numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public String getSelist() {
		return selist;
	}

	public void setSelist(String selist) {
		this.selist = selist;
	}

	public String getPrasada() {
		return prasada;
	}

	public void setPrasada(String prasada) {
		this.prasada = prasada;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPtList() {
		return ptList;
	}

	public void setPtList(String ptList) {
		this.ptList = ptList;
	}

	@Override
	public String toString() {
		return "RegisterFormDTO [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", age=" + age + ", emailId=" + emailId + "password=" + password + ", state=" + state
				+ ", date=" + date + ", numberOfPersons=" + numberOfPersons + ", selist=" + selist + ", prasada="
				+ prasada + ", idCard=" + idCard + ", idNumber=" + idNumber + ", ptList=" + ptList + "]";
	}

}
