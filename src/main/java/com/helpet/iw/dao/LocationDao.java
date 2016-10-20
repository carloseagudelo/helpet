package com.helpet.iw.dao;

import java.util.List;

import com.helpet.iw.dto.Location;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Location
 * @date 10/17/206 
 *
 */
public interface LocationDao {
	
	/**
	 * Metodo que guarda las locaciones de los donde fue visto un perro
	 * @param location, objeto de tipo Location con la informacion necesaria para ser almacenada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void guardar(Location location) throws DaoException;
	
	/**
	 * Metodo que actualiza las locaciones de los donde fue visto un perro
	 * @param location, objeto de tipo Location con la informacion necesaria para ser actualizada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void actualizar(Location location) throws DaoException;
	
	/**
	 * Metodo que busca la locaciones registradas por id
	 * @param location, Variable de int String con la informacion necesaria para la busqueda
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	Location buscarPaisPorId(int id) throws DaoException;
	
	/**
	 * Metodo que elimina las locaciones de los donde fue visto un perro
	 * @param location, objeto de tipo Location con la informacion necesaria para ser eliminada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void eliminar(Location location) throws DaoException;
	
	/**
	 * Metodo que busca las visuaizacione de mascotas perdidas
	 * @param location, objeto de tipo Location con la informacion necesaria para ser eliminada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	List<Location> listarVisualizaconesPorMacota(int idPet) throws DaoException;
}
