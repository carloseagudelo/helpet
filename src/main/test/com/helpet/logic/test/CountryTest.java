package com.helpet.logic.test;

import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.helpet.iw.dao.CountryDao;
import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})

public class CountryTest {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	CountryDao dao;

	public void guardarCiudad(String name, int id)
	{
		try
		{
			Country country = new Country();
			country.setId(id);
			country.setName(name);
			dao.guardar(country);			
		}
		catch (DaoException e)
		{
			e.printStackTrace();
		}
	}

}