package com.helpet.iw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.helpet.iw.dao.CountryDao;
import com.helpet.iw.dao.hibernate.CountryDaoHibernate;
import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;

public class CountryDaoHibernatePrueba {

	@Test
	public void guardarTest() 
	{
		CountryDao dao = new CountryDaoHibernate();
		Country country = new Country();
		country.setId(1);
		country.setName("Colombia");
		try
		{
			dao.guardar(country);
		}
		catch(DaoException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
