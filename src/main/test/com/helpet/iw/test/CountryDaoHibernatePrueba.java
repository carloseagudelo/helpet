package com.helpet.iw.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.helpet.iw.dao.CountryDao;
import com.helpet.iw.dao.hibernate.CountryDaoHibernate;
import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})
public class CountryDaoHibernatePrueba {
	
	@Autowired
	CountryDao dao;
	
	@Test
	public void testObtenerCiudades(){
		
		List<Country> countries;
		try {
			countries = dao.obtenerCiudades();
			assertTrue(countries.size() > 0);
		} catch (DaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	 
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
