package com.helpet.iw.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.helpet.iw.dao.Datasource;
import com.helpet.iw.dao.LocationDao;
import com.helpet.iw.dto.Location;
import com.helpet.iw.exception.DaoException;

public class LocationDaoHibernate implements LocationDao {
	
	public void guardar(Location location) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.save(location);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(Location location) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.update(location);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public Location buscarPaisPorId(int id) throws DaoException
	{
		Session session = null;
		Location location = null;
		try
		{
			session = Datasource.getInstance().getSession();
			Criteria cri = session.createCriteria(Location.class).add(Restrictions.eq("id",id));
			location = (Location)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return location;
	}
	
	public void eliminar(Location location) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();
			session.delete(location);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}

}
