package com.surobinda.api;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.surobinda.domain.Address;
import com.surobinda.domain.Person;
import com.surobinda.service.IPersonService;


/**
 * Note: Annotating this class or methods with @Transactional does not help much.
 * As this class is maintained by separate Jersey servlet container.
 * Hence had to introduce another Service Layer to perform coarse grain operation 
 * 
 * @author surobinda
 * 
 *
 */
@Service
@Path("api/person")
public class PersonServiceRESTImpl implements IPersonServiceAPI
{
	@Autowired
	@Qualifier("personService")
	IPersonService personService; 
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Person> getAllPerson() 
	{
		List<Person> persons = personService.getAllPerson();
		
		//Following null set is basically a hack as while JSON mershalling JSON can not handle cyclic dependency
		//Person -> address -> person
		//Need to find a fix
		if (persons != null && !persons.isEmpty())
		{
			for (Person person: persons)
			{
				Set<Address> addresses = person.getAddresses();//.iterator().next().setPerson(null);
				for (Address address : addresses)
				{
					address.setPerson(null);
				}
			}
		}
		
		return persons;
	}

	@GET
	@Path("/{personId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Person getPersonById(@PathParam("personId") long personId) 
	{
		return personService.getPersonById(personId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Person createPerson(Person person) 
	{
		//person.setAddresses(null);
		person  = personService.createPerson(person);
		
		//JSON process can not handle cyclic object dependency hence following null set
		person.getAddresses().iterator().next().setPerson(null);
		return person;
	}

	@Override
	public Person updatePerson(Person person) 
	{
		throw new UnsupportedOperationException("Update person not suppoerted yet");
	}

	@Override
	public void deletePerson(Person person) 
	{
		throw new UnsupportedOperationException("Update person not suppoerted yet");
	}
	
	/**
	 * this hello method is for purely testing purpose, to check if the end-point
	 * is deployed properly or not
	 * @return
	 */
	@GET
	@Path("/hello")
	@Produces(MediaType.APPLICATION_JSON)
	public Person hello() 
	{
		Person person = new Person();
		person.setPersonId(123);
		person.setFirstName("Surobinda");
		person.setLastName("Mallick");
		
		Address address = new Address();
		address.setAddressId(321);
		address.setAddressLine1("Bull House");
		address.setAddressLine2("Madox Street");
		address.setCountry("Canada");
		address.setCity("NDBT");
		address.setProvince("Some Province");
		//Following null set is basically a hack as while JSON mershalling JSON can not handle cyclic dependency
		//Person -> address -> person
		//Need to find a fix
		//address.setPerson(person);
		
		person.getAddresses().add(address);
		
		return person;
	}
}

