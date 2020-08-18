package com.xworkz.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "personal_info")
@NamedQueries({
		@NamedQuery(name = "fetchEntityByEmailId", query = "select personalInfo from PersonalInfo personalInfo where personalInfo.emailId=:emailId"),
		@NamedQuery(name = "fetchCountByEmail", query = "select count(*) from PersonalInfo personalInfo where personalInfo.emailId=:emailId"),
		@NamedQuery(name = "fetchCountByNumber", query = "select count(*) from PersonalInfo personalInfo where personalInfo.mobileNumber=:mobileNumber"),
		@NamedQuery(name = "fetchVisitDetailsByEmail", query = "select details from VisitingDetails details where id=(select id from PersonalInfo where emailId=:emailId)"),
		@NamedQuery(name = "fetchPersonalDetailsByEmailId", query = "select personalInfo from PersonalInfo personalInfo where personalInfo.emailId=:emailId"),
		@NamedQuery(name = "fetchVisitingDetailsByEmailId", query = "select details from VisitingDetails details where id=(select id from PersonalInfo where emailId=:emailId)"),
		@NamedQuery(name = "updatePersonalInfoDetails", query = "update PersonalInfo set password=:password where emailId=:emailId"),
		@NamedQuery(name = "fetchPersonDetailsByEmailIdAndPassword", query = "select personalInfo from PersonalInfo personalInfo where personalInfo=(select id from PersonalInfo where emailId=:emailId and password=:password)"),
		@NamedQuery(name = "fetchVisitingDetailsByEmailIdAndPassword", query = "select details from VisitingDetails details where id=(select id from PersonalInfo where emailId=:emailId and password=:password)"),
		@NamedQuery(name = "fetchNumberOfLoginCountsByEmail", query = "select countLogin from PersonalInfo where emailId=:emailId"),
		@NamedQuery(name = "updateCountLoginByEmail", query = "update PersonalInfo set countLogin=:loginCounts where emailId=:emailId"),
		@NamedQuery(name = "fetchPasswordByEmail", query = "select password from PersonalInfo personalInfo where personalInfo.emailId=:emailId") })
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

	@Column(name = "password")
	private String password;

	@Column(name = "state")
	private String state;

	@Column(name = "count_login")
	private int countLogin;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personalInfo")
	private List<VisitingDetails> visitingDetails;

	private static final Logger logger = Logger.getLogger(PersonalInfo.class);

	public PersonalInfo() {
		logger.info("created\t" + this.getClass().getSimpleName());
	}

	public PersonalInfo(int id, String name, String mobileNumber, String address, String age, String emailId,
			String password, String state, int countLogin, List<VisitingDetails> visitingDetails) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.age = age;
		this.emailId = emailId;
		this.password = password;
		this.state = state;
		this.countLogin = countLogin;
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

	public int getCountLogin() {
		return countLogin;
	}

	public void setCountLogin(int countLogin) {
		this.countLogin = countLogin;
	}

	public List<VisitingDetails> getVisitingDetails() {
		return visitingDetails;
	}

	public void setVisitingDetails(List<VisitingDetails> visitingDetails) {
		this.visitingDetails = visitingDetails;
	}

	@Override
	public String toString() {
		return "PersonalInfo [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address=" + address
				+ ", age=" + age + ", emailId=" + emailId + ", password=" + password + ", state=" + state
				+ ", countLogin=" + countLogin + ", visitingDetails=" + visitingDetails + "]";
	}

}