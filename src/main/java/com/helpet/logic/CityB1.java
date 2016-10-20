package com.helpet.logic;

import java.util.List;

import com.helpet.iw.dto.City;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Martinez Londoño
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description Interface for City in lauyer of bussines
 * @date 10/17/206 
 *
 */


public interface CityB1 {
	
	/**
	 * Metodo que registra la informacion de una ciudad en el sistema
	 * @param name
	 * @param cityId
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void createCity(String name, int cityId) throws DaoException;
	
	/**
	 * Metodo que actualiza la informacion de una ciudad en el sistema
	 * @param name
	 * @param id
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void updateCity(String name, int id) throws DaoException;
	
	/**
	 * Metodo que elimina una ciudad
	 * @param id
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void deleteCity(int id) throws DaoException;
	
	/**
	 * MEetodo que lista todas las ciudades registradas
	 * @return
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	List<City> listCitys() throws DaoException;
	
	/**
	 * metodo que lista todas las ciudaddes registradas discriminadas por pais
	 * @param country
	 * @return
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	List<City> listCitysPerCountry(int country) throws DaoException;

}
