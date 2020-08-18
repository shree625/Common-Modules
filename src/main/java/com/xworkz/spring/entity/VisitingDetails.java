package com.xworkz.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "visiting_details")
public class VisitingDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private String date;

	@Column(name = "selist")
	private String selist;

	@Column(name = "prasada")
	private String prasada;

	@Column(name = "id_card")
	private String idCard;

	@Column(name = "id_number")
	private String idNumber;

	@Column(name = "ptlist")
	private String ptList;

	@Column(name = "no_of_persons")
	private String numberOfPersons;

	@ManyToOne
	@JoinColumn(name = "personalInfo_id")
	private PersonalInfo personalInfo;

	private static final Logger logger = Logger.getLogger(VisitingDetails.class);

	public VisitingDetails() {
		logger.info("created\t" + this.getClass().getSimpleName());
	}

	public VisitingDetails(int id, String date, String selist, String prasada, String idCard, String idNumber,
			String ptList, String numberOfPersons, PersonalInfo personalInfo) {
		super();
		this.id = id;
		this.date = date;
		this.selist = selist;
		this.prasada = prasada;
		this.idCard = idCard;
		this.idNumber = idNumber;
		this.ptList = ptList;
		this.numberOfPersons = numberOfPersons;
		this.personalInfo = personalInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(String numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	@Override
	public String toString() {
		return "VisitingDetails [id=" + id + ", date=" + date + ", selist=" + selist + ", prasada=" + prasada
				+ ", idCard=" + idCard + ", idNumber=" + idNumber + ", ptList=" + ptList + ", numberOfPersons="
				+ numberOfPersons + ", personalInfo=" + personalInfo + "]";
	}

}