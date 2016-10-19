package com.helpet.iw.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.helpet.iw.dao.PetDao;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.exception.DaoException;

public class PetDaoHibernate implements PetDao 
{
	
	private SessionFactory sessionFactory;
	
	public void guardar(Pet pet) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();	
			tx = session.beginTransaction();
			session.save(pet);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(Pet pet) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();		
			tx = session.beginTransaction();
			session.update(pet);
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public Pet buscarPaisPorNombre(String name) throws DaoException
	{
		Session session = null;
		Pet pet = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria cri = session.createCriteria(Pet.class).add(Restrictions.eq("name",name));
			pet = (Pet)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return pet;
	}
	
	public Pet buscarPaisPorId(int id) throws DaoException
	{
		Session session = null;
		Pet pet = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria cri = session.createCriteria(Pet.class).add(Restrictions.eq("id",id));
			pet = (Pet)cri.uniqueResult();
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
		return pet;
	}
	
	public void eliminar(Pet pet) throws DaoException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = sessionFactory.openSession();	
			tx = session.beginTransaction();
			session.delete(pet);
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
