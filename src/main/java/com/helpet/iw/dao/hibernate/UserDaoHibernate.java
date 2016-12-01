package com.helpet.iw.dao.hibernate;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
		List<User> user = null;
		try
		{
			session = sessionFactory.openSession();
			Query query = session.createSQLQuery(
			"select * from user where email = :email and password = :password")
			.setParameter("email", email).setParameter("password", password);
			user = query.list();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		if(user.size() > 0)
		{
			return true;
		}
		else
		{
			return false;
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
