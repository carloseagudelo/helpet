package com.helpet.logic.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.helpet.iw.dao.CountryDao;
import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;
import com.helpet.logic.CountryB1;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})

public class CountryPrueba {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	CountryB1 dao;

	public void guardarPais(String name)
	{
		try
		{
			dao.createCountry(name);			
		}
		catch (DaoException e)
		{
			e.printStackTrace();
		}
	}
	
	public int listarCountry()
	{
		List<Country> lista = null;
		try{
			lista = dao.listCountry();
		}
		catch(DaoException e){
			e.printStackTrace();
		}
		
		return lista.size();
	}

}
