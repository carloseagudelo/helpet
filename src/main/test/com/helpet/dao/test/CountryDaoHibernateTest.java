package com.helpet.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.helpet.dao.CountryDao;
import com.helpet.dao.hibernate.CountryDaoHibernate;
import com.helpet.dto.Country;
import com.helpet.exception.DaoException;

public class CountryDaoHibernateTest {

	@Test
	public void guardarTest() {
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
