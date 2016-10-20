package com.helpet.logic;

import java.util.List;

import com.helpet.iw.dto.City;
import com.helpet.iw.exception.DaoException;

public interface CityB1 {
	
	void createCity(String name, int cityId) throws DaoException;
	
	void updateCity(String name, int id) throws DaoException;
	
	void deleteCity(int id) throws DaoException;
	
	List<City> listCitys() throws DaoException;
	
	List<City> listCitysPerCountry(int country) throws DaoException;

}
