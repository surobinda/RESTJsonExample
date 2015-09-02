package com.surobinda.dao;

import java.util.List;

import com.surobinda.domain.Person;

/**
 * @author surobinda
 *
 */
public interface IPersonDAO 
{

	public List<Person> getAllPerson();
	
	public Person getPersonById(long personId);
	
	public Person createPerson(Person person);
	
	public Person updatePerson(Person person);
	
	public void deletePerson(Person person);
}
