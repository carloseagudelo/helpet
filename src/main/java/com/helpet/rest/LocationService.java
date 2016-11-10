package com.helpet.rest;

/*
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Marcela MArtinez
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description class for open services for Location in route /rest/LocationService
 * @date 11/08/2016 
 *
 */

import java.rmi.RemoteException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helpet.logic.LocationB1;
import com.helpet.rest.dto.BreedWs;
import com.helpet.rest.dto.LocationWs;
import com.helpet.iw.dto.Breed;
import com.helpet.iw.dto.Location;
import com.helpet.iw.exception.DaoException;

@Path("LocationService")
@Component
public class LocationService {
	
	@Autowired
	LocationB1 locationB1;

	public LocationB1 getLocationB1() {
		return locationB1;
	}

	public void setLocationB1(LocationB1 locationB1) {
		this.locationB1 = locationB1;
	}
	
	@POST	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create/userId/{param}/petId/{param1}/latitude/{param2}/longitude/{param3}/address/{param4}/image/{param5}/observations/{param6}/date/{param7}")	
	public Response createLocation(@PathParam("param") Integer userId, @PathParam("param1") Integer petId, @PathParam("param2") Float latitude,
			@PathParam("param3") Float longitude, @PathParam("param4") String address, @PathParam("param5") String image,
			@PathParam("param6") String observation, @PathParam("param7") Date date) throws RemoteException{
		String resultado = "";
		try{
			locationB1.registrationLocation(userId, petId, latitude, longitude, address, image, observation, date);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return Response.status(201).entity(resultado).build();
	}
	
	@PUT	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create/id/{param8}/userId/{param}/petId/{param1}/latitude/{param2}/longitude/{param3}/address/{param4}/image/{param5}/observations/{param6}/date/{param7}")	
	public Response updateLocation(@PathParam("param") Integer userId, @PathParam("param1") Integer petId, @PathParam("param2") Float latitude,
			@PathParam("param3") Float longitude, @PathParam("param4") String address, @PathParam("param5") String image,
			@PathParam("param6") String observation, @PathParam("param7") Date date, @PathParam("param8") Integer id) throws RemoteException{
		String resultado = "";
		try{
			locationB1.updateLocation(id, userId, petId, latitude, longitude, address, image, observation, date);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return Response.status(201).entity(resultado).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show/id/{param}")
	public LocationWs showLocation(@PathParam("param") Integer id) throws RemoteException{
		Location loc = null;
		LocationWs locationw = null;
		try{
			loc =  locationB1.showLocation(id);
			locationw = new LocationWs(loc.getId(), loc.getUser(), loc.getPet(), loc.getLatitude(), loc.getLongitude(),
					loc.getAddress(), loc.getImage(), loc.getObservations(), loc.getDate());
		}
		catch(DaoException e){
			throw new RemoteException(e.getMessage(), e);
		}	
		return locationw;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show/idPet/{param}")
	public List<LocationWs> listLocationPet(@PathParam("param") Integer idPet) throws RemoteException{
		List<Location> lista = null;	
		List<LocationWs> resultado = new ArrayList<LocationWs>();
		try{
			lista =  locationB1.ListLocationPet(idPet);
			for(Location loc : lista){
				LocationWs location = new LocationWs(loc.getId(), loc.getUser(), loc.getPet(), loc.getLatitude(), loc.getLongitude(),
						loc.getAddress(), loc.getImage(), loc.getObservations(), loc.getDate());
				resultado.add(location);
			}
		}
		catch(DaoException e){
			throw new RemoteException(e.getMessage(), e);
		}	
		return resultado;
	}

}
