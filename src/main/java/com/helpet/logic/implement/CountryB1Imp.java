package com.helpet.logic.implement;
import com.helpet.iw.dao.CountryDao;
import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;
import com.helpet.logic.CountryB1;

public class CountryB1Imp implements CountryB1 {

	CountryDao countryDao;
	
	public CountryB1Imp(CountryDao countryDao) 
	{
		this.countryDao = countryDao;
	}

	public void createCountry(String name, int id) throws DaoException 
	{
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar la cedula del cliente.");
        }		
		Country country = new Country();
		country.setId(id);
		country.setName(name);
		countryDao.guardar(country);
	}

}
