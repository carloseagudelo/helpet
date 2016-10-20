package com.helpet.logic;

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

public interface UserB1 {
	
	/**
	 * 
	 * @param name
	 * @param lasName
	 * @param cityId
	 * @param address
	 * @param email
	 * @param password
	 * @param image
	 * @param document
	 * @param date
	 * @throws DaoException
	 */
	void registrationUser(String name, String lasName, int cityId, String address, String email, String password, String image, String document, Date date) throws DaoException;
	
	/**
	 * 
	 * @param name
	 * @param lasName
	 * @param cityId
	 * @param address
	 * @param email
	 * @param password
	 * @param image
	 * @param document
	 * @param date
	 * @throws DaoException
	 */
	void updateUser(String name, String lasName, int cityId, String address, String email, String password, String image, String document, Date date) throws DaoException;
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws DaoException
	 */
	boolean login(String email, String password) throws DaoException;
	
	/**
	 * 
	 * @throws DaoException
	 */
	void loginSocialNtwork() throws DaoException;
}
