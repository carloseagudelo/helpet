package com.helpet.rest;

/*
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Marcela MArtinez
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description class for open services for Pet in route /rest/PetService
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

import com.helpet.logic.PetB1;
import com.helpet.rest.dto.BreedWs;
import com.helpet.rest.dto.PetWs;
import com.helpet.iw.dto.Breed;
import com.helpet.iw.dto.Location;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.exception.DaoException;

@Path("PetService")
@Component
public class PetService {
	
	@Autowired
	PetB1 petB1;

	public PetB1 getPetB1() {
		return petB1;
	}

	public void setPetB1(PetB1 petB1) {
		this.petB1 = petB1;
	}
	
	/*
	 * Metodo que lista los registros de las mascotas registrados en formato JSON 
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return lista en formato JSON con la información de los registros de la tabla Pet
	*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<PetWs> ListPet() throws RemoteException{
		List<Pet> lista = null;
		List<PetWs> resultado = new ArrayList<PetWs>();
		try{
			lista =  petB1.listPet();
			for(Pet pet : lista){
				PetWs petw = new PetWs(pet.getId(), pet.getName(), pet.getAge(), pet.getBreed(), pet.getState(), pet.getObservations(), 
						pet.getUser(), pet.getImage(), pet.getDate());
				resultado.add(petw);
			}
		}
		catch(DaoException e){
			throw new RemoteException(e.getMessage(), e);
		}
		return resultado;
	}
	
	/*
	 * Metodo que realiza la insercion de la informacion de la mascota
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create/name/{param}/age/{param1}/state/{param2}/observation/{param3}/email/{param4}/date/{param5}/userId/{param6}/breedId/{param7}")
	public Response registerPet(@PathParam("param") String name, @PathParam("param1") String age, 
			@PathParam("param2") Integer state, @PathParam("param3") String observation,
			@PathParam("param4") String image, @PathParam("param5") Date date,
			@PathParam("param6") Integer userId, @PathParam("param7") Integer breedId) throws RemoteException {
		String resultado = "";
		try{
			petB1.registrationPet(name, age, state, observation, image, date, userId, breedId);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return Response.status(201).entity(resultado).build();	
	}
	
	/*
	 * Metodo que realiza la actualizacion de la informacion de la mascota
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/id/{params8}/name/{param}/age/{param1}/state/{param2}/observation/{param3}/email/{param4}/date/{param5}/userId/{param6}/breedId/{param7}")
	public Response updateUser(@PathParam("param") String name, @PathParam("param1") String age, 
			@PathParam("param2") Integer state, @PathParam("param3") String observation,
			@PathParam("param4") String image, @PathParam("param5") Date date,
			@PathParam("param6") Integer userId, @PathParam("param7") Integer breedId, @PathParam("param8") Integer id) throws RemoteException {		
		String resultado = "";
		try{
			petB1.updatePet(id, name, age, state, observation, image, date, userId, breedId);
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
	public PetWs showPet(@PathParam("param") Integer id) throws RemoteException{
		Pet pet = null;
		PetWs petW = null;
		try{
			pet =  petB1.showPetInfotmation(id);
			petW = new PetWs(pet.getId(), pet.getName(), pet.getAge(), pet.getBreed(), pet.getState(),
					pet.getObservations(), pet.getUser(), pet.getImage(), pet.getDate());
		}
		catch(DaoException e){
			throw new RemoteException(e.getMessage(), e);
		}	
		return petW;
	}

}
