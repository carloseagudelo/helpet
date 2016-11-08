package com.helpet.rest;

import java.rmi.RemoteException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;
import com.helpet.logic.CountryB1;;

@Path("CountryService")
@Component
public class CountryTest {
	
	@Autowired
	CountryB1 countryB1;

	public CountryB1 getCountryB1() {
		return countryB1;
	}

	public void setCountryB1(CountryB1 countryB1) {
		this.countryB1 = countryB1;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<Country> listCountry() throws RemoteException {
		List<Country> lista = null;		
		try{
			lista =  countryB1.listCountry();
		}
		catch(DaoException e){
			throw new RemoteException(e.getMessage(), e);
		}	
		return lista;
	}
	
}
