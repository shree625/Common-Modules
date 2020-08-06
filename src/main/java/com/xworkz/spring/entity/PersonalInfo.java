package com.xworkz.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "personal_info")
@NamedQueries({
		@NamedQuery(name = "fetchCountByEmail", query = "select count(*) from PersonalInfo personalInfo where personalInfo.emailId=:emailId"),
		@NamedQuery(name = "fetchCountByNumber", query = "select count(*) from PersonalInfo personalInfo where personalInfo.mobileNumber=:mobileNumber"),
		@NamedQuery(name = "fetchVisitDetailsByEmail", query = "select  details from VisitingDetails details where id=(select id from PersonalInfo where emailId=:email)") })
public class PersonalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "age")
	private String age;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "state")
	private String state;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "visiting_details_id")
	private VisitingDetails visitingDetails;

	private static final Logger logger = Logger.getLogger(PersonalInfo.class);

	public PersonalInfo() {
		logger.info("created\t" + this.getClass().getSimpleName());
	}

	public PersonalInfo(int id, String name, String mobileNumber, String address, String age, String emailId,
			String state, VisitingDetails visitingDetails) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.age = age;
		this.emailId = emailId;
		this.state = state;
		this.visitingDetails = visitingDetails;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public VisitingDetails getVisitingDetails() {
		return visitingDetails;
	}

	public void setVisitingDetails(VisitingDetails visitingDetails) {
		this.visitingDetails = visitingDetails;
	}

	@Override
	public String toString() {
		return "PersonalInfo [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address=" + address
				+ ", age=" + age + ", emailId=" + emailId + ", state=" + state + ", visitingDetails=" + visitingDetails
				+ "]";
	}

}
