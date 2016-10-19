package com.helpet.iw.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.helpet.iw.dao.BreedDao;
import com.helpet.iw.dto.Breed;
import com.helpet.iw.exception.DaoException;

public class BreedDaoHibernate implements BreedDao 
{
	
	private SessionFactory sessionFactory;
	
	public void guardar(Breed breed) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();	
			tx = session.beginTransaction();
			session.save(breed);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(Breed breed) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(breed);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public Breed buscarPaisPorNombre(String name) throws DaoException
	{
		Session session = null;
		Breed breed = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria cri = session.createCriteria(Breed.class).add(Restrictions.eq("name",name));
			breed = (Breed)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return breed;
	}
	
	public Breed buscarPaisPorId(int id) throws DaoException
	{
		Session session = null;
		Breed country = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria cri = session.createCriteria(Breed.class).add(Restrictions.eq("id",id));
			country = (Breed)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return country;
	}
	
	public void eliminar(Breed breed) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(breed);
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
