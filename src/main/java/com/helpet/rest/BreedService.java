package com.helpet.rest;

/*
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Marcela MArtinez
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description class for open services for Breed in route /rest/BreedService
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

import com.helpet.logic.BreedB1;
import com.helpet.iw.dto.Breed;
import com.helpet.iw.exception.DaoException;

@Path("BreedService")
@Component
public class BreedService {
	
	@Autowired
	BreedB1 breedB1;

	public BreedB1 getBreedB1() {
		return breedB1;
	}

	public void setBreedB1(BreedB1 breedB1) {
		this.breedB1 = breedB1;
	}

}
