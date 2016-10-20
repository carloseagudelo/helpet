package com.helpet.iw.dao;

import com.helpet.iw.dto.Pet;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Pet
 * @date 10/17/206 
 *
 */
public interface PetDao {

	/**
	 * Metodo que guarda la informacion de las mascotas perdidas
	 * @param pet, objeto de Pet con la informacion necesaria para ser almacenada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void guardar(Pet pet) throws DaoException;
	
	/**
	 * Metodo que actualiza la informacion de las mascotas perdidas
	 * @param pet, objeto de Pet con la informacion necesaria para ser actualizada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void actualizar(Pet pet) throws DaoException;
	
	/**
	 * Metodo que busca la informacion de la mascota perdida por nombre de la misma
	 * @param name, Variable de tipo String con la informacion necesaria para la busqueda
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	Pet buscarPaisPorNombre(String name) throws DaoException;
	
	/**
	 * Metodo que busca la informacion de la mascota perdida por el id de registro de la misma
	 * @param id, Variable de tipo int con la informacion necesaria para la busqueda
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	Pet buscarPaisPorId(int id) throws DaoException;
	
	/**
	 * Metodo que elimina la informacion de las mascotas perdidas
	 * @param pet, objeto de Pet con la informacion necesaria para ser eliminada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void eliminar(Pet pet) throws DaoException;
	
}
