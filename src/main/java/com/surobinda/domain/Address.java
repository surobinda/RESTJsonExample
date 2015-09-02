package com.surobinda.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author surobinda
 *
 */
@Entity
@Table(name="ADDRESS")
public class Address implements Serializable
{
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	@Column(name="ADDRESS_ID")
	private long addressId;
	
	@Column(name="ADDRESS_LINE1", nullable=false)
	private String addressLine1;
	
	@Column(name="ADDRESS_LINE2", nullable=false)
	private String addressLine2;
	
	@Column(name="CITY", nullable=false)
	private String city;
	
	@Column(name="PROVINCE", nullable=false)
	private String province;
	
	@Column(name="COUNTRY", nullable=false)
	private String country;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ENTITY_ID", nullable = false)
	private Person person;

	/**
	 * @return the addressId
	 */
	public long getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	
}

