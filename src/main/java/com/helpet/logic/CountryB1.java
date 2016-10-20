package com.helpet.logic;

import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;
import java.util.List;


public interface CountryB1 {

	void createCountry(String name) throws DaoException;
	
	void updateCountry(String name, int id) throws DaoException;
	
	void deleteCountry(int id) throws DaoException;
	
	List<Country> listCountry() throws DaoException;
	
}
