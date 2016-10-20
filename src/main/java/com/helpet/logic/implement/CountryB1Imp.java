package com.helpet.logic.implement;

import com.helpet.iw.dao.CountryDao;
import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;
import com.helpet.logic.CountryB1;

import java.util.List;

/**
 * Class thats define the methods for access to methods in lauyer of data in Country
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Implements methods for Breed
 * @date 10/17/206 
 *
 */

public class CountryB1Imp implements CountryB1 {

	CountryDao countryDao;
	
	public CountryB1Imp(CountryDao countryDao) 
	{
		this.countryDao = countryDao;
	}

	public void createCountry(String name) throws DaoException 
	{
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar el nombre de la ciudad.");
        }	
		if(countryDao.buscarPaisPorNombre(name) != null)
		{
			throw new NullPointerException("La ciudad ya existe.");
		}
		Country country = new Country();
		country.setName(name);
		countryDao.guardar(country);
	}
	
	public void updateCountry(String name, int id) throws DaoException 
	{
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar el nombre de la ciudad.");
        }	
		if(countryDao.buscarPaisPorNombre(name) != null)
		{
			throw new NullPointerException("La ciudad ya existe.");
		}
		Country country =countryDao.buscarPaisPorId(id);
		country.setName(name);
		countryDao.actualizar(country);
	}
	
	public void deleteCountry(int id) throws DaoException 
	{
		Country country =countryDao.buscarPaisPorId(id);
		if(country == null)
		{
			throw new NullPointerException("La ciudad que intenta eliminar no existe.");
		}		
		countryDao.actualizar(country);
	}
	
	public List<Country> listCountry() throws DaoException
	{
		return countryDao.obtenerCiudades();
	}

}
