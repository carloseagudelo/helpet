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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

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

}
