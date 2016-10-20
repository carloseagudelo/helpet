package com.helpet.iw.dao;

import com.helpet.iw.dto.User;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for User
 * @date 10/17/206 
 *
 */
public interface UserDao {
	
	/**
	 * Metodo que guarda la informacion de las usuarios en el sistema
	 * @param user, objeto de User con la informacion necesaria para ser almacenada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void guardar(User user) throws DaoException;
	
	/**
	 * Metodo que actualiza la informacion de las usuarios en el sistema
	 * @param user, objeto de User con la informacion necesaria para ser actualizada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void actualizar(User user) throws DaoException;
	
	/**
	 * Metodo que busca la informacion de un usuario por su nombre
	 * @param name, variable de tipo string con el valor del nombre a buscar
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	User buscarPaisPorNombre(String name) throws DaoException;
	
	/**
	 * Metodo que busca la informacion de un usuario por su id de registro
	 * @param name, variable de tipo int con el valor del id a buscar
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	User buscarPaisPorId(int id) throws DaoException;	
	
	/**
	 * Metodo que elimina la informacion de las usuarios en el sistema
	 * @param user, objeto de User con la informacion necesaria para ser eliminada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void eliminar(User user) throws DaoException;

}
