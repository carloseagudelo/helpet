package com.helpet.logic;

import java.util.List;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.exception.DaoException;
import java.util.Date;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Pet in lauyer of bussines
 * @date 10/17/206 
 *
 */

public interface PetB1 {
	
	/**
	 * 
	 * @param name
	 * @param age
	 * @param state
	 * @param observation
	 * @param image
	 * @param date
	 * @param userId
	 * @param breedId
	 * @throws DaoException
	 */
	void registrationPet(String name, String age, int state, String observation, String image,  Date date, int userId, int breedId) throws DaoException;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param age
	 * @param state
	 * @param observation
	 * @param image
	 * @param date
	 * @param userId
	 * @param breedId
	 * @throws DaoException
	 */
	void updatePet(int id, String name, String age, int state, String observation, String image,  Date date, int userId, int breedId) throws DaoException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	Pet showPetInfotmation(int id) throws DaoException;
	
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	List<Pet> listPet() throws DaoException;

}
