package com.helpet.rest;

/*
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Marcela MArtinez
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description class for open services for User in route /rest/UserService
 * @date 11/08/2016 
 *
 */

import java.rmi.RemoteException;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helpet.logic.UserB1;
import com.helpet.iw.dto.User;
import com.helpet.iw.exception.DaoException;

@Path("UserService")
@Component
public class UserService {
	
	@Autowired
	UserB1 userB1;

	public UserB1 getUserB1() {
		return userB1;
	}

	public void setUserB1(UserB1 userB1) {
		this.userB1 = userB1;
	}
	
	/*
	 * Metodo que realiza la insercion de la informacion del usuario
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create/name/{param}/lasname/{param1}/cityId/{param2}/addres/{param3}/email/{param4}/password/{param5}/image/{param6}/document/{param7}/date/{param8}")
	public String CreateUser(@PathParam("param") String name, @PathParam("param1") String lastName, 
			@PathParam("param2") Integer id, @PathParam("param3") String address,
			@PathParam("param4") String email, @PathParam("param5") String password,
			@PathParam("param6") String image, @PathParam("param7") String document,
			@PathParam("param8") Date date) throws RemoteException {
		String resultado = "";
		try{
			userB1.registrationUser(name, lastName, id, address, email, password, image, document, date);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return resultado;	
	}
	
	/*
	 * Metodo que realiza la actualizacion de la informacion del usuario
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/name/{param}/lasname/{param1}/cityId/{param2}/addres/{param3}/email/{param4}/password/{param5}/image/{param6}/document/{param7}/date/{param8}")
	public String updateUser(@PathParam("param") String name, @PathParam("param1") String lastName, 
			@PathParam("param2") Integer id, @PathParam("param3") String address,
			@PathParam("param4") String email, @PathParam("param5") String password,
			@PathParam("param6") String image, @PathParam("param7") String document,
			@PathParam("param8") Date date) throws RemoteException {		
		String resultado = "";
		try{
			userB1.updateUser(name, lastName, id, address, email, password, image, document, date);
			resultado = "sucessfull";
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		return resultado;	
	}
	
	/*
	 * Metodo que realiza la autentificacion de usuario
	 * @throws RemoteException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 * @return mensaje indicando el estado del proceso
	*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login/user/{param}/password/{param1}")
	public String login(@PathParam("param") String email, @PathParam("param1") String password) throws RemoteException {
		boolean log = false;
		String resultado = "";
		try{
			log = userB1.login(email, password);
		}
		catch(DaoException e){
			resultado = "Failed";
			throw new RemoteException(e.getMessage(), e);
		}		
		if(log == true)
		{
			return "sucessfull";
		}
		else
		{
			return "failed";
		}
	}

}
