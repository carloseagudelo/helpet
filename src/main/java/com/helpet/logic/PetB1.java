package com.helpet.logic;

import java.util.List;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.exception.DaoException;
import java.util.Date;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Martinez Londoño
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description Interface for Pet in lauyer of bussines
 * @date 10/17/206 
 *
 */

public interface PetB1 {
	
	/**
	 * Metodo que realiza el registro de una mascota perdida
	 * @param name
	 * @param age
	 * @param state
	 * @param observation
	 * @param image
	 * @param date
	 * @param userId
	 * @param breedId
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void registrationPet(String name, String age, int state, String observation, String image,  Date date, int userId, int breedId) throws DaoException;
	
	/**
	 * Metodo que realiza la actualizacion de la informacion para una mascota perdida
	 * @param id
	 * @param name
	 * @param age
	 * @param state
	 * @param observation
	 * @param image
	 * @param date
	 * @param userId
	 * @param breedId
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void updatePet(int id, String name, String age, int state, String observation, String image,  Date date, int userId, int breedId) throws DaoException;
	
	/**
	 * Metodo que realiza una busqueda de mascota perdia por por id de registro
	 * @param id
	 * @return
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	Pet showPetInfotmation(int id) throws DaoException;
	
	/**
	 * Metodo que lista la informacion de las mascotas registradas
	 * @return
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	List<Pet> listPet() throws DaoException;

}
