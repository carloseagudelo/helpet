package com.helpet.iw.dao.hibernate;

import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.helpet.iw.dao.UserDao;
import com.helpet.iw.dto.User;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Implements methods for User
 * @date 10/17/206 
 *
 */

public class UserDaoHibernate implements UserDao 
{	
	
	private SessionFactory sessionFactory;
	
	public void guardar(User user) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();	
			tx = session.beginTransaction();			
			session.save(user);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(User user) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();	
			tx = session.beginTransaction();			
			session.update(user);
			tx.commit();
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
			session = sessionFactory.openSession();
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
			session = sessionFactory.openSession();
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
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();	
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}

	public User BuscarUsuarioPorEmail(String email) throws DaoException
	{
		Session session = null;
		User user = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria cri = session.createCriteria(User.class).add(Restrictions.eq("email",email));
			user = (User)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return user;
	}
	
	public boolean autentificacion(String email, String password) throws DaoException
	{
		Session session = null;
		User user = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria cri = session.createCriteria(User.class);
			cri.add(Restrictions.eq("email",email));
			cri.add(Restrictions.eq("password",password));
			user = (User)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		if(user != null)
		{
			return false;
		}
		else
		{
			return true;
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
