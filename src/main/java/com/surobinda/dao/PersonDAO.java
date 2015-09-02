package com.surobinda.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.surobinda.domain.Person;

@Component
public class PersonDAO implements IPersonDAO
{
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Person> getAllPerson() 
	{
		Session session = sessionFactory.getCurrentSession();
		List<Person> persons = session.createQuery("from Person").list();
		return persons;
	}

	@Override
	public Person getPersonById(long personId) 
	{
		Session session = sessionFactory.getCurrentSession();
		Person person = (Person)session.get(Person.class, personId);
		return person;
	}

	@Override
	@Transactional
	public Person createPerson(Person person) 
	{
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			Long personId = (Long)session.save(person);
			person.setPersonId(personId);
		}
		finally
		{
			if (session != null)
			{
				//session.close();
			}
		}
		return person;
	}

	@Override
	public Person updatePerson(Person person) 
	{
		throw new UnsupportedOperationException("Update operation is not supported");
	}

	@Override
	public void deletePerson(Person person) 
	{
		throw new UnsupportedOperationException("Delete operation is not supported");
		
	}

}
