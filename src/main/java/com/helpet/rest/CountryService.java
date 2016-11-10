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
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;
import com.helpet.logic.CountryB1;
import com.helpet.rest.dto.CountryWs;

@Path("CountryService")
@Component
public class CountryService {
	
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
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return lista en formato JSON con la información de los registros de la tabla Country
	*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<CountryWs> listCountry() throws RemoteException {
		List<Country> lista = null;
		List<CountryWs> resultado = new ArrayList<CountryWs>();
		try{
			lista =  countryB1.listCountry();
			for (Country country : lista){
				CountryWs countryw = new CountryWs(country.getId(), country.getName());
				resultado.add(countryw);
			}
		}
		catch(DaoException e){
			throw new RemoteException(e.getMessage(), e);
		}	
		return resultado;
	}
	
	/*
	 * Metodo que hace la inserción de informacion de un pais donde el nombre del pais entra como parametro a travez de la URL 
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@POST	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create/name/{param}")	
	public Response CreateCountry(@PathParam("param") String name) throws RemoteException{
		String resultado = "";
		try{
			countryB1.createCountry(name);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return Response.status(201).entity(resultado).build();
	}
	
	/*
	 * Metodo que actualiza la informacion de un registro  
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@PUT	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/name/{param}/id/{param1}")
	public Response updateCountry(@PathParam("param") String name, @PathParam("param1") Integer id) throws RemoteException{
		String resultado = "";
		try{
			countryB1.updateCountry(name, id);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return Response.status(201).entity(resultado).build();
	}
	
	/*
	 * Metodo que elimina la informacion de un registro  
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@DELETE	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/id/{param}")
	public Response deleteCountry(@PathParam("param") Integer id) throws RemoteException{
		String resultado = "";
		try{
			countryB1.deleteCountry(id);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return Response.status(201).entity(resultado).build();
	}
	
	
	
	
}
