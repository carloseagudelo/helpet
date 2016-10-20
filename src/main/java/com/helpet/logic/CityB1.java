package com.helpet.logic;

import java.util.List;

import com.helpet.iw.dto.City;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for City in lauyer of bussines
 * @date 10/17/206 
 *
 */


public interface CityB1 {
	
	/**
	 * 
	 * @param name
	 * @param cityId
	 * @throws DaoException
	 */
	void createCity(String name, int cityId) throws DaoException;
	
	/**
	 * 
	 * @param name
	 * @param id
	 * @throws DaoException
	 */
	void updateCity(String name, int id) throws DaoException;
	
	/**
	 * 
	 * @param id
	 * @throws DaoException
	 */
	void deleteCity(int id) throws DaoException;
	
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	List<City> listCitys() throws DaoException;
	
	/**
	 * 
	 * @param country
	 * @return
	 * @throws DaoException
	 */
	List<City> listCitysPerCountry(int country) throws DaoException;

}
