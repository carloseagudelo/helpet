package com.helpet.iw.dao.hibernate;

import com.helpet.iw.exception.DaoException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.helpet.iw.dao.CountryDao;
import com.helpet.iw.dao.Datasource;
import com.helpet.iw.dto.Country;

public class CountryDaoHibernate implements CountryDao 
{

	public void guardar(Country country) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.save(country);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(Country country) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.update(country);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public Country buscarPaisPorNombre(String name) throws DaoException
	{
		Session session = null;
		Country country = null;
		try
		{
			session = Datasource.getInstance().getSession();
			Criteria cri = session.createCriteria(Country.class).add(Restrictions.eq("name",name));
			country = (Country)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return country;
	}
	
	public Country buscarPaisPorId(int id) throws DaoException
	{
		Session session = null;
		Country country = null;
		try
		{
			session = Datasource.getInstance().getSession();
			Criteria cri = session.createCriteria(Country.class).add(Restrictions.eq("id",id));
			country = (Country)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return country;
	}
	
	public void eliminar(Country country) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();
			session.delete(country);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
}
