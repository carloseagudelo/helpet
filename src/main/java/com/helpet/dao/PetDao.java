package com.helpet.dao;

import com.helpet.dto.Pet;
import com.helpet.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Pet
 * @date 10/17/206 
 *
 */
public interface PetDao {

	void guardar(Pet pet) throws DaoException;
	
	void actualizar(Pet pet) throws DaoException;
	
	Pet buscarPaisPorNombre(String name) throws DaoException;
	
	Pet buscarPaisPorId(int id) throws DaoException;
	
	void eliminar(Pet pet) throws DaoException;
	
}
