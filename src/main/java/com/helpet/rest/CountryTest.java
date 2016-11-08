package com.helpet.rest;

/*
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Marcela MArtinez
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description class for open services for Country in route /rest/CountryService
 * @date 11/08/2016 
 *
 */

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

	/*
	 * Metodo que lista los registros de paises registrados en formato JSON 
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	*/
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
