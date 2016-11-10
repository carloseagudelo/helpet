package com.helpet.logic;

import java.util.Date;
import java.util.List;

import com.helpet.iw.dto.Location;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.dto.User;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Martinez Londoño
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description Interface for Location in lauyer of bussines
 * @date 10/17/206 
 *
 */

public interface LocationB1 {
	
	/**
	 * Metodo que registra la visualizacion de una mascota
	 * @param userId
	 * @param petId
	 * @param latitude
	 * @param longitude
	 * @param address
	 * @param image
	 * @param Observations
	 * @param date
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void registrationLocation(int userId, int petId, float latitude, float longitude, String address, String image, String Observations, Date  date) throws DaoException;
	
	/**
	 * Metodo realiza la actualización de la informacion de una mascota visualizada
	 * @param id
	 * @param userId
	 * @param petId
	 * @param latitude
	 * @param longitude
	 * @param address
	 * @param image
	 * @param Observations
	 * @param date
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void updateLocation(int id, int userId, int petId, float latitude, float longitude, String address, String image, String Observations, Date  date) throws DaoException;
	
	/**
	 * Metodo que muetsra la informacion registrada en la visualizacion de una mascota seleccionada
	 * @param id
	 * @return
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	Location showLocation(int id) throws DaoException;
	
	/**
	 * MEtodo que lista los registros de una mascota visualizada
	 * @param idPet
	 * @return
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	List<Location> ListLocationPet(int idPet) throws DaoException;
	
}
