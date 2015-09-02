package com.surobinda.dao;

import java.util.List;

import com.surobinda.domain.Address;

/**
 * @author surobinda
 *
 */
public interface IAddressDAO 
{
	public List<Address> getAllAddresses();
	
	public Address getAddressById(long addressId);
	
	public Address createAddress(Address address);
	
	public Address updateAddress(Address address);
	
	public void deleteAddress(Address address);
}
