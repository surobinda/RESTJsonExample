package com.surobinda.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.surobinda.domain.Address;

/**
 * @author surobinda
 *
 */
@Component
public class AddressDAO implements IAddressDAO 
{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	public List<Address> getAllAddresses() 
	{
		Session session = sessionFactory.getCurrentSession();
		List<Address> addresses = session.createQuery("from Address").list();
		//session.close();
		return addresses;
	}

	@Override
	public Address getAddressById(long addressId) 
	{
		Session session = sessionFactory.getCurrentSession();
		Address address = (Address)session.get(Address.class, addressId);
		//session.close();
		return address;
	}

	@Override
	@Transactional
	public Address createAddress(Address address) 
	{
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			Long addressId = (Long) session.save(address);
			address.setAddressId(addressId);
			//someExceptionalMethod();
		}
		finally
		{
			if (session != null)
			{
				//session.close();
			}
		}
		
		return address;
	}
	
	private void someExceptionalMethod()
	{
		throw new RuntimeException("Just throwing exception to test transaction");
	}

	@Override
	public Address updateAddress(Address address) 
	{
		throw new UnsupportedOperationException("Update address not yet implemented");
	}

	@Override
	public void deleteAddress(Address address) 
	{
		throw new UnsupportedOperationException("Update address not yet implemented");
	}

}
