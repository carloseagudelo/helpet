package com.helpet.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.helpet.dao.Datasource;
import com.helpet.dao.UserDao;
import com.helpet.dto.User;
import com.helpet.exception.DaoException;

public class UserDaoHibernate implements UserDao 
{	
	public void guardar(User user) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.save(user);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(User user) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.update(user);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public User buscarPaisPorNombre(String name) throws DaoException
	{
		Session session = null;
		User user = null;
		try
		{
			session = Datasource.getInstance().getSession();
			Criteria cri = session.createCriteria(User.class).add(Restrictions.eq("name",name));
			user = (User)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return user;
	}
	
	public User buscarPaisPorId(int id) throws DaoException
	{
		Session session = null;
		User user = null;
		try
		{
			session = Datasource.getInstance().getSession();
			Criteria cri = session.createCriteria(User.class).add(Restrictions.eq("id",id));
			user = (User)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return user;
	}
	
	public void eliminar(User user) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();
			session.delete(user);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
}
