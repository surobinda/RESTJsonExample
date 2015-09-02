package com.surobinda.api;

import java.util.List;

import com.surobinda.domain.Address;

/**
 * @author surobinda
 *
 */
public interface IAddressServiceAPI 
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
