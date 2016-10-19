package com.helpet.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.helpet.iw.exception.DaoException;

public class Datasource
{

	private static Datasource instancia;
	private SessionFactory sessionfactory = null;
	
	private Datasource()
	{		
	}
	
	public static Datasource getInstance()
	{
		if(instancia == null){
			instancia = new Datasource();
		}
		return instancia;
	}
	
	public Session getSession() throws DaoException
	{		
		try
		{
			if(sessionfactory == null)
			{
				Configuration config = new Configuration();			
				config.configure("hibernate.cfg.xml");			
				sessionfactory = config.buildSessionFactory();
			}		
			return sessionfactory.openSession();
		
		}
		catch (HibernateException e) 
		{
			throw new DaoException(e);
		}
	}
	
}
