package com.surobinda.api;

import java.util.List;

import com.surobinda.domain.Person;

/**
 * @author surobinda
 *
 */
public interface IPersonServiceAPI 
{
	/**
	 * @return
	 */
	public List<Person> getAllPerson();
	
	/**
	 * @param personId
	 * @return
	 */
	public Person getPersonById(long personId);
	
	/**
	 * @param person
	 * @return
	 */
	public Person createPerson(Person person);
	
	/**
	 * @param person
	 * @return
	 */
	public Person updatePerson(Person person);
	
	/**
	 * @param person
	 */
	public void deletePerson(Person person);
}
