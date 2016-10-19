package com.helpet.iw.dao;

import com.helpet.iw.dto.City;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Interface for Country
 * @date 10/17/206 
 *
 */
public interface CityDao {
	
	/**
	 * Metodo que guarda la informaciòn de determinada ciudad
	 * @param city Objeto de tipo Ciudad con la informaciòn a almacenar 
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void guardar(City city) throws DaoException;
	
	/**
	 * Metodo que actualiza la informaciòn de determinada ciudad
	 * @param city bjeto de tipo Ciudad con la informaciòn a almacenar
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void actualizar(City city) throws DaoException;
	
	/**
	 * Metodo que busca la información de una ciudad por nombre
	 * @param name Variable de tipo String con el valor del nombre que se desea buscar la ciudad
	 * @return Objeto de tipo Ciudad con la información encontrada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	City buscarPaisPorNombre(String name) throws DaoException;
	
	/**
	 * Metodo que busca la información de una ciudad por id
	 * @param id Variable de tipo Integer con el valor del id que se desea buscar la ciudad
	 * @return Objeto de tipo Ciudad con la información encontrada
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	City buscarPaisPorId(int id) throws DaoException;
	
	/**
	 * Metodo que elimina la información de determinada ciudad
	 * @param city Objeto de tipo Ciudad con la información que se desea eliminar
	 * @throws DaoException manejo de excepciones a partir de clase personalida, donde se lleva el error a un log de auditoria
	 */
	void eliminar(City city) throws DaoException;
	
}
