package com.xworkz.spring.dto;

import org.apache.log4j.Logger;

public class RegisterDTO {

	private static final Logger logger = Logger.getLogger(RegisterDTO.class);

	private int id;
	private String propName;
	private String propValue;
	private String propType;

	public RegisterDTO() {
		logger.info("created\t RegisterDTO object" + this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropValue() {
		return propValue;
	}

	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}

	public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

	@Override
	public String toString() {
		return "RegisterDTO [id=" + id + ", propName=" + propName + ", propValue=" + propValue + ", propType="
				+ propType + "]";
	}

}