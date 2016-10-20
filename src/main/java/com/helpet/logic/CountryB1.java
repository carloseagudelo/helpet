package com.helpet.logic;

import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;
import java.util.List;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Martinez Londoño
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description Interface for Country in lauyer of bussines
 * @date 10/17/206 
 *
 */

public interface CountryB1 {

	/**
	 * Metodo que regista la informacion de un pais
	 * @param name
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void createCountry(String name) throws DaoException;
	
	/**
	 *  Metodo que actualiza la informacion de un pais ya registrado en el sistema
	 * @param name
	 * @param id
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void updateCountry(String name, int id) throws DaoException;
	
	/**
	 * Metodo que elimina un pais ya registrado en el sistema
	 * @param id
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void deleteCountry(int id) throws DaoException;
	
	/**
	 * Metodo que lista todos los paises registrados en el sistema
	 * @return
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	List<Country> listCountry() throws DaoException;
	
}
