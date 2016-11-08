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

import com.helpet.logic.CityB1;
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<City> listCity() throws RemoteException {
		List<City> lista = null;		
		try{
			lista =  cityB1.listCitys();
		}
		catch(DaoException e){
			throw new RemoteException(e.getMessage(), e);
		}	
		return lista;
	}

}
