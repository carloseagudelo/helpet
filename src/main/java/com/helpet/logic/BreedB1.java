package com.helpet.logic;

import java.util.List;

import com.helpet.iw.dto.Breed;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Breed in lauyer of bussines
 * @date 10/17/206 
 *
 */

public interface BreedB1 {
	
	/**
	 * 
	 * @param name
	 * @throws DaoException
	 */
	void createBreed(String name) throws DaoException;
	
	/**
	 * 
	 * @param name
	 * @param id
	 * @throws DaoException
	 */
	void updateBreed(String name, int id) throws DaoException;
	
	/**
	 * 
	 * @param id
	 * @throws DaoException
	 */
	void deleteBreed(int id) throws DaoException;
	
	/**
	 * 
	 * @return
	 * @throws DaoException
	 */
	List<Breed> listBreeds() throws DaoException;
	

}
