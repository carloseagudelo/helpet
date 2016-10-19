package com.helpet.dao;

import com.helpet.dto.Location;
import com.helpet.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Location
 * @date 10/17/206 
 *
 */
public interface LocationDao {
	
	void guardar(Location location) throws DaoException;
	
	void actualizar(Location location) throws DaoException;
	
	Location buscarPaisPorId(int id) throws DaoException;
	
	void eliminar(Location location) throws DaoException;
}
