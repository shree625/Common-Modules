package com.xworkz.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "app_prop_table")
@NamedQueries({@NamedQuery(name = "fetchAllByType", query = "Select register from RegisterEntity register where register.propType=:typ")})
public class RegisterEntity implements Serializable {

	private static final Logger logger = Logger.getLogger(RegisterEntity.class);

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private int id;
	@Column(name = "prop_name")
	private String propName;
	@Column(name = "prop_value")
	private String propValue;
	@Column(name = "prop_type")
	private String propType;

	public RegisterEntity() {
		logger.info("created\t" + this.getClass().getSimpleName());
	}

	public RegisterEntity(String propName, String propValue, String propType) {
		super();
		this.propName = propName;
		this.propValue = propValue;
		this.propType = propType;
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
		return "RegisterEntity [id=" + id + ", propName=" + propName + ", propValue=" + propValue + ", propType="
				+ propType + "]";
	}

}
