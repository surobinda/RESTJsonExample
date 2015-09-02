package com.surobinda.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surobinda.dao.IAddressDAO;
import com.surobinda.dao.IPersonDAO;
import com.surobinda.domain.Address;
import com.surobinda.domain.Person;

/**
 * Note: Annotating this class or operation with @Transactional makes spring AOP proxies work with declared txManager.
 * Also what I noticed that scope of the session finishes here, session is not visibale to upper layer, 
 * which is a Jersey servlet for this application.
 * 
 * @author surobind1
 *
 */
@Service
public class PersonService implements IPersonService
{
	
	@Autowired
	@Qualifier("personDAO")
	private IPersonDAO personDAO;
	
	@Autowired
	@Qualifier("addressDAO")
	private IAddressDAO addressDAO;

	@Override
	/*@Transactional*/
	public List<Person> getAllPerson() 
	{
		List<Person> persons = personDAO.getAllPerson();
		return persons;
	}

	@Override
	/*@Transactional*/
	public Person getPersonById(long personId) 
	{
		return personDAO.getPersonById(personId);
	}

	@Override
	@Transactional
	public Person createPerson(Person person) 
	{
		Set<Address> addresses = person.getAddresses();
		//person.setAddresses(null);
		
		Address address = addresses.iterator().next();
		address.setPerson(person);
		
		//Create the Person
		person = personDAO.createPerson(person);
		
		//exceptionalMethod();
		
		//Create another address and link it to above Person
		Address anotherAddress = new Address();
		anotherAddress.setAddressLine1("Another Address Line1");
		anotherAddress.setAddressLine2("Another Address Line2");
		anotherAddress.setCity("Another City");
		anotherAddress.setProvince("Another province");
		anotherAddress.setCountry("Another Country");
		
		anotherAddress.setPerson(person);
		
		addressDAO.createAddress(anotherAddress);
		
		//This code is transaction (check if this method is annotated with @Transactional)
		//And as this code is calling some DAO with hibernate session open, hence session will remain open in ths method as well.
		//So if you change anyuthing with above person or another address object hibernate session will persist them in the DB.
		//conclusion above person and anotheraddress object is in persistance state in this point, not detached.
		
		
		return person;
	}

	@Override
	/*@Transactional*/
	public Person updatePerson(Person person) 
	{
		throw new UnsupportedOperationException("Update person not suppoerted yet");
	}

	@Override
	/*@Transactional*/
	public void deletePerson(Person person) 
	{
		throw new UnsupportedOperationException("Update person not suppoerted yet");
		
	}
	
	private void exceptionalMethod()
	{
		throw new RuntimeException("Some runtime exception");
	}

}
