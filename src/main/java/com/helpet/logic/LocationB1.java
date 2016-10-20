package com.helpet.logic;

import java.util.Date;
import java.util.List;

import com.helpet.iw.dto.Location;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.dto.User;
import com.helpet.iw.exception.DaoException;

public interface LocationB1 {
	
	void registrationLocation(int userId, int petId, float latitude, float longitude, String address, String image, String Observations, Date  date) throws DaoException;
	
	void updateLocation(int id, int userId, int petId, float latitude, float longitude, String address, String image, String Observations, Date  date) throws DaoException;
	
	Location showLocation(int id) throws DaoException;
	
	List<Location> ListLocationPet(int idPet) throws DaoException;
	
}
