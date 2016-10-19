package com.helpet.iw.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.helpet.iw.dao.CityDao;
import com.helpet.iw.dao.Datasource;
import com.helpet.iw.dto.City;
import com.helpet.iw.exception.DaoException;

public class CityDaoHibernate implements CityDao {
	
	public void guardar(City city) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.save(city);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(City city) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.update(city);
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
			session = Datasource.getInstance().getSession();
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
			session = Datasource.getInstance().getSession();
			Criteria cri = session.createCriteria(City.class).add(Restrictions.eq("id",id));
			city = (City)cri.uniqueResult();
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
		try
		{
			session = Datasource.getInstance().getSession();
			session.delete(city);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}

}
