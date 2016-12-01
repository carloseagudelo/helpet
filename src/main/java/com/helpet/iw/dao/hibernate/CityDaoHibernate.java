package com.helpet.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.helpet.iw.dao.CityDao;
import com.helpet.iw.dto.Breed;
import com.helpet.iw.dto.City;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Implements methods for City
 * @date 10/17/206 
 *
 */

public class CityDaoHibernate implements CityDao 
{	
	private SessionFactory sessionFactory;
	
	public void guardar(City city) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();	
			tx = session.beginTransaction();
			session.save(city);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(City city) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(city);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public City buscarPaisPorNombre(String name) throws DaoException
	{
		Session session = null;
		City city = null;
		try
		{
			session = sessionFactory.openSession();	
			Criteria cri = session.createCriteria(City.class).add(Restrictions.eq("name",name));
			city = (City)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return city;
	}
	
	public City buscarPaisPorId(int id) throws DaoException
	{
		Session session = null;
		City city = null;
		try
		{
			session = sessionFactory.openSession();	
			Query query = session.createSQLQuery(
					"select * from city where country = :id")
					.setParameter("id", id);
			//Criteria cri = session.createCriteria(City.class).add(Restrictions.eq("id",id));
			city = (City)query.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return city;
	}
	
	public void eliminar(City city) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(city);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public List<City> ObtenerCiudades() throws DaoException
	{
		List<City> resultado;
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(City.class);
			resultado = crit.list();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return resultado;		
	}
	
	public List<City> ObtenerCiudadesPorPais(int country) throws DaoException
	{
		List<City> resultado;
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(City.class).add(Restrictions.eq("country",country));
			resultado = crit.list();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return resultado;	
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
