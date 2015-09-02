package com.surobinda.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author surobinda
 *
 */
@Entity
@Table(name="ENTITY")
@XmlRootElement
public class Person implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
	@Column(name="ENTITY_ID")
	private long personId;
	
	@Column(name="FIRST_NAME", nullable=false) 
	private String firstName;
	
	@Column(name="LAST_NAME",  nullable=false) 
	private String lastName;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="person",cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Address> addresses;
	
	
	/**
	 * @return the personId
	 */
	public long getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(long personId) {
		this.personId = personId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the addresses
	 */
	public Set<Address> getAddresses() {
		
		if (addresses == null )
		{
			addresses = new HashSet<Address>();
		}
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	
}
