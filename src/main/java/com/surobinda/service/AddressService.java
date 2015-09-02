package com.surobinda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surobinda.dao.IAddressDAO;
import com.surobinda.domain.Address;

@Service
public class AddressService implements IAddressService 
{

	@Autowired
	@Qualifier("addressDAO")
	private IAddressDAO addressDAO;
	
	@Override
	@Transactional
	public List<Address> getAllAddresses() 
	{
		return addressDAO.getAllAddresses();
	}

	@Override
	@Transactional
	public Address getAddressById(long addressId) 
	{
		return addressDAO.getAddressById(addressId);
	}

}
