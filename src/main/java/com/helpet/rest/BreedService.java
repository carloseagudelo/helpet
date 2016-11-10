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

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helpet.logic.BreedB1;
import com.helpet.rest.dto.BreedWs;
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
	
	/*
	 * Metodo que lista los registros de las razas registrados en formato JSON 
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return lista en formato JSON con la información de los registros de la tabla Country
	*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<BreedWs> listBreed() throws RemoteException {
		List<Breed> lista = null;	
		List<BreedWs> resultado = new ArrayList<BreedWs>();
		try{
			lista =  breedB1.listBreeds();
			for(Breed breed : lista){
				BreedWs breedw = new BreedWs(breed.getId(), breed.getName(), breed.getName());
				resultado.add(breedw);
			}
		}
		catch(DaoException e){
			throw new RemoteException(e.getMessage(), e);
		}	
		return resultado;
	}
	
	/*
	 * Metodo que hace la inserción de informacion de una raza donde el nombre de la raza entra como parametro a travez de la URL 
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@POST	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create/name/{param}")	
	public Response CreateBreed(@PathParam("param") String name) throws RemoteException{
		String resultado = "";
		try{
			breedB1.createBreed(name);
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
	public Response updateBreed(@PathParam("param") String name, @PathParam("param1") Integer id) throws RemoteException{
		String resultado = "";
		try{
			breedB1.updateBreed(name, id);
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
	public Response deleteBreed(@PathParam("param") Integer id) throws RemoteException{
		String resultado = "";
		try{
			breedB1.deleteBreed(id);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return Response.status(201).entity(resultado).build();
	}

}
