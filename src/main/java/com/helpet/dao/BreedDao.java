package com.helpet.dao;

import com.helpet.dto.Breed;
import com.helpet.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Breed
 * @date 10/17/206 
 *
 */

public interface BreedDao {
	
	/**
	 * Metodo que almacena la información de una raza de mascota
	 * @param breed Objeto de tipo Breed con la información a almacenar 
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void guardar(Breed breed) throws DaoException;
	
	/**
	 * Metodo que actualiza la información de una raza de mascota
	 * @param breed Objeto de tipo Breed con la información a actualizar 
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void actualizar(Breed breed) throws DaoException;
	
	/**
	 * Metodo que busca la información de una raza por nombre 
	 * @param name variable de tipo string con el valor a buscar
	 * @return Objeto de tipo Breed con la informacion encontrada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	Breed buscarPaisPorNombre(String name) throws DaoException;
	
	/**
	 * Metodo que busca la información de una raza por id 
	 * @param id variable de tipo id con el valor a buscar
	 * @return Objeto de tipo Breed con la informacion encontrada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	Breed buscarPaisPorId(int id) throws DaoException;
	
	/**
	 * Metodo que elimina la informacion de determinada Raza
	 * @param breed Objeto de tipo Breed con la información a eliminar
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void eliminar(Breed breed) throws DaoException;

}
