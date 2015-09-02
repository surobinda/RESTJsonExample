package com.surobinda.service;

import java.util.List;

import com.surobinda.domain.Address;

public interface IAddressService 
{
	/**
	 * @return
	 */
	public List<Address> getAllAddresses();
	
	/**
	 * @param addressId
	 * @return
	 */
	public Address getAddressById(long addressId);
}
