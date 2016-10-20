package com.helpet.logic.implement;

import java.util.List;

import com.helpet.iw.dao.CityDao;
import com.helpet.iw.dao.CountryDao;
import com.helpet.iw.dto.City;
import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;
import com.helpet.logic.CityB1;

public class CityB1Impl implements CityB1 {
	
	CityDao cityDao;
	CountryDao countryDao;
	
	public CityB1Impl(CityDao cityDao, CountryDao countryDao)
	{
		this.cityDao = cityDao;
		this.countryDao = countryDao;
	}

	public void createCity(String name, int cityId) throws DaoException 
	{
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar el nombre de la ciudad.");
        }	
		if(cityDao.buscarPaisPorNombre(name) != null)
		{
			throw new NullPointerException("La ciudad ya existe.");
		}
		Country country = countryDao.buscarPaisPorId(cityId);
		if(country == null)
		{
			throw new NullPointerException("El pais al que va asignar la ciudad no existe.");
		}
		City city = new City();
		city.setName(name);
		city.setCountry(country);
		cityDao.guardar(city);
	}

	public void updateCity(String name, int id) throws DaoException 
	{
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar el nombre de la raza.");
        }	
		if(cityDao.buscarPaisPorNombre(name) != null)
		{
			throw new NullPointerException("La raza ya existe.");
		}
		City city = cityDao.buscarPaisPorId(id);
		city.setName(name);
		cityDao.actualizar(city);
	}

	public void deleteCity(int id) throws DaoException 
	{
		City city = cityDao.buscarPaisPorId(id);
		if(city == null)
		{
			throw new NullPointerException("La ciudad que intenta eliminar no existe.");
		}		
		cityDao.eliminar(city);
	}

	public List<City> listCitys() throws DaoException
	{
		return cityDao.ObtenerCiudades();
	}

	public List<City> listCitysPerCountry(int country) throws DaoException 
	{
		return cityDao.ObtenerCiudadesPorPais(country);
	}

}
