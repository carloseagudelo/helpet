package com.helpet.iw.dao.hibernate;

import com.helpet.iw.exception.DaoException;

import org.hibernate.Transaction;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.helpet.iw.dao.CountryDao;
import com.helpet.iw.dto.Country;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Implements methods for Country
 * @date 10/17/206 
 *
 */

public class CountryDaoHibernate implements CountryDao 
{
	
	private SessionFactory sessionFactory;
	
	public void guardar(Country country) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();	
			tx = session.beginTransaction();
			session.save(country);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(Country country) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(country);
			tx.commit();
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
			session = sessionFactory.openSession();
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
			session = sessionFactory.openSession();
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
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(country);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}	
}
