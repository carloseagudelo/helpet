package com.helpet.logic;

import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;
import java.util.List;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Country in lauyer of bussines
 * @date 10/17/206 
 *
 */

public interface CountryB1 {

	/**
	 * 
	 * @param name
	 * @throws DaoException
	 */
	void createCountry(String name) throws DaoException;
	
	/**
	 * 
	 * @param name
	 * @param id
	 * @throws DaoException
	 */
	void updateCountry(String name, int id) throws DaoException;
	
	/**
	 * 
	 * @param id
	 * @throws DaoException
	 */
	void deleteCountry(int id) throws DaoException;
	
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	List<Country> listCountry() throws DaoException;
	
}
