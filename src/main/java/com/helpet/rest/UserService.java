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
