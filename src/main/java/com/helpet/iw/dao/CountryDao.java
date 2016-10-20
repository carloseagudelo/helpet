package com.helpet.iw.dao;

import java.util.List;

import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Country
 * @date 10/17/206 
 *
 */

public interface CountryDao {

	/**
	 * Metodo que guarda los paises
	 * @param country, objeto de tipo Country con la informacion necesaria para ser almacenada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void guardar(Country country) throws DaoException;
	
	/**
	 *  Metodo que actuliza la informacion de un determinado pais
	 * @param country objeto de tipo Country con la información que se desea actualizar 
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void actualizar(Country country) throws DaoException;
	
	/**
	 * Metodo que busca la infromación de un deteminado pais por nombre
	 * @param name variable de tipo string que lleva el nombre por el cual se quiere buscar el pais
	 * @return Objeto de tipo Country con la infromacion del pais encontrado
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	Country buscarPaisPorNombre(String name) throws DaoException;

	/**
	 * Metodo que busca la infromación de un deteminado pais por id
	 * @param id variable de tipo int que lleva el id por el cual se quiere buscar el pais
	 * @return Objeto de tipo Country con la infromacion del pais encontrado
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	Country buscarPaisPorId(int id) throws DaoException;

	/**
	 *  Metodo que elimina la informacion de un determinado pais
	 * @param country objeto de tipo Country con la información que se desea eliminar 
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void eliminar(Country country) throws DaoException;
	
	/**
	 * Metodo que retorna una lista con la informacion de todas los paises
	 * @return ista con la informacion de todas los paises
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	List<Country> obtenerCiudades() throws DaoException;
}
