package com.surobinda.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.surobinda.service.IAddressService;
import com.surobinda.domain.Address;

/**
 * @author surobinda
 *
 */
@Path("api/address")
public class AddressServiceRESTImpl implements IAddressServiceAPI
{
	@Autowired
	@Qualifier("addressService")
	IAddressService addressService;

	/* (non-Javadoc)
	 * @see com.surobinda.api.IAddressServiceAPI#getAllAddresses()
	 */
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Address> getAllAddresses() 
	{
		return addressService.getAllAddresses();
	}

	/* (non-Javadoc)
	 * @see com.surobinda.api.IAddressServiceAPI#getAddressById(long)
	 */
	@Override
	@GET
	@Path("/{addressId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Address getAddressById(@PathParam("addressId") long addressId) 
	{
		return addressService.getAddressById(addressId);
	}

}
