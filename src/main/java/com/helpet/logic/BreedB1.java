package com.helpet.logic;

import java.util.List;

import com.helpet.iw.dto.Breed;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo, Laura Martinez Londoño
 * @email carloskikea@gmail.com, laumarlon@gmail.com
 * @description Interface for Breed in lauyer of bussines
 * @date 10/17/206 
 *
 */

public interface BreedB1 {
	
	/**
	 * Metodo que guarda la informacion de una raza
	 * @param name variable de tipo String con el valor a guardar
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void createBreed(String name) throws DaoException;
	
	/**
	 * Metodo que actualiza la informacion de una raza
	 * @param name Variable de tipo String con el valor del nimbre que se va actualizar
	 * @param id variable de tipo int con el id de la raza que se desea modificar
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void updateBreed(String name, int id) throws DaoException;
	
	/**
	 * Metodo que elimina ua raza
	 * @param id id del registro que se desea eliminar
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void deleteBreed(int id) throws DaoException;
	
	/**
	 * MEtodo que lista todas las razas registradas
	 * @return lista con la informacion de las razas
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	List<Breed> listBreeds() throws DaoException;
	

}
