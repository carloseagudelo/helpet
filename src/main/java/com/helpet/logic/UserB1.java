package com.helpet.logic;

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

public interface UserB1 {
	
	/**
	 * Metodo que crea el usuario en el sistema
	 * @param name
	 * @param lasName
	 * @param cityId
	 * @param address
	 * @param email
	 * @param password
	 * @param image
	 * @param document
	 * @param date
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void registrationUser(String name, String lasName, int cityId, String address, String email, String password, String image, String document, Date date) throws DaoException;
	
	/**
	 * Metodo que actualiza la informacion del usuario en el sistema
	 * @param name
	 * @param lasName
	 * @param cityId
	 * @param address
	 * @param email
	 * @param password
	 * @param image
	 * @param document
	 * @param date
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void updateUser(String name, String lasName, int cityId, String address, String email, String password, String image, String document, Date date) throws DaoException;
	
	/**
	 * Metodo que realiza el login en el aplicativo
	 * @param email
	 * @param password
	 * @return variable booleana indicando True indicnado que puede ingresar al aplicativo False de lo contrario
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	boolean login(String email, String password) throws DaoException;
	
	/**
	 * Metodo que realiza el login con redes sociales
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void loginSocialNtwork() throws DaoException;
}
