package com.helpet.logic;

import java.util.Date;
import java.util.List;

import com.helpet.iw.dto.Location;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.dto.User;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Location in lauyer of bussines
 * @date 10/17/206 
 *
 */

public interface LocationB1 {
	
	/**
	 * 
	 * @param userId
	 * @param petId
	 * @param latitude
	 * @param longitude
	 * @param address
	 * @param image
	 * @param Observations
	 * @param date
	 * @throws DaoException
	 */
	void registrationLocation(int userId, int petId, float latitude, float longitude, String address, String image, String Observations, Date  date) throws DaoException;
	
	/**
	 * 
	 * @param id
	 * @param userId
	 * @param petId
	 * @param latitude
	 * @param longitude
	 * @param address
	 * @param image
	 * @param Observations
	 * @param date
	 * @throws DaoException
	 */
	void updateLocation(int id, int userId, int petId, float latitude, float longitude, String address, String image, String Observations, Date  date) throws DaoException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	Location showLocation(int id) throws DaoException;
	
	/**
	 * 
	 * @param idPet
	 * @return
	 * @throws DaoException
	 */
	List<Location> ListLocationPet(int idPet) throws DaoException;
	
}
