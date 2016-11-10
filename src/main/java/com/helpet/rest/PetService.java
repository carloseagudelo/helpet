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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helpet.logic.PetB1;
import com.helpet.rest.dto.BreedWs;
import com.helpet.rest.dto.PetWs;
import com.helpet.iw.dto.Breed;
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

}
