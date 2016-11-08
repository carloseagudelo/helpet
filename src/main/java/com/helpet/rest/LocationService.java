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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helpet.logic.LocationB1;
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

}
