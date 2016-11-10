package com.helpet.rest;

/*
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Marcela MArtinez
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description class for open services for City in route /rest/CityService
 * @date 11/08/2016 
 *
 */


import java.rmi.RemoteException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helpet.logic.CityB1;
import com.helpet.rest.dto.CityWs;
import com.helpet.iw.dto.City;
import com.helpet.iw.exception.DaoException;

@Path("CityService")
@Component
public class CityService {
	
	@Autowired
	CityB1 cityB1;

	public CityB1 getCityB1() {
		return cityB1;
	}

	public void setCityB1(CityB1 cityB1) {
		this.cityB1 = cityB1;
	}

	/*
	 * Metodo que lista los registros de paises registrados en formato JSON 
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return lista de los registros en formato JSON
	*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<CityWs> listCity() throws RemoteException {
		List<City> lista = null;
		List<CityWs> resultado = new ArrayList<CityWs>();		
		try{
			lista =  cityB1.listCitys();
			for(City city : lista){
				CityWs cityw = new CityWs(city.getId(), city.getName(), city.getCountry());
				resultado.add(cityw);
			}
		}
		catch(DaoException e){
			throw new RemoteException(e.getMessage(), e);
		}	
		return resultado;
	}
	
	/*
	 * Metodo que lista los registros de las ciudades discriminados por ciudad registrados en formato JSON 
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return lista de los registros en formato JSON
	*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list/id/{param}")
	public List<City> listCityPerCountry(@PathParam("param") Integer id) throws RemoteException {
		List<City> lista = null;
		List<CityWs> resultado = new ArrayList<CityWs>();
		try{
			lista =  cityB1.listCitysPerCountry(id);
			for(City city : lista){
				CityWs cityw = new CityWs(city.getId(), city.getName(), city.getCountry());
				resultado.add(cityw);
			}
		}
		catch(DaoException e){
			throw new RemoteException(e.getMessage(), e);
		}	
		return lista;
	}
	
	/*
	 * Metodo que actualiza la informacion de un registro  
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@PUT	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/name/{param}/id/{param1}")
	public String updateCity(@PathParam("param") String name, @PathParam("param1") Integer id) throws RemoteException{
		String resultado = "";
		try{
			cityB1.updateCity(name, id);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return resultado;
	}
	
	/*
	 * Metodo que elimina la informacion de un registro  
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@DELETE	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/id/{param}")
	public String deleteCity(@PathParam("param") Integer id) throws RemoteException{
		String resultado = "";
		try{
			cityB1.deleteCity(id);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
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
	@Path("/create/name/{param}/id/{param1}")	
	public String CreateCity(@PathParam("param") String name, @PathParam("param1") Integer id) throws RemoteException{
		String resultado = "";
		try{
			cityB1.createCity(name, id);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return resultado;
	}
	

}
