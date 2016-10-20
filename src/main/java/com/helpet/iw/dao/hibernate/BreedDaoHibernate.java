package com.helpet.iw.dao.hibernate;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Implements methods for Breed
 * @date 10/17/206 
 *
 */

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.helpet.iw.dao.BreedDao;
import com.helpet.iw.dto.Breed;
import com.helpet.iw.exception.DaoException;
import java.util.List;

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
	
	public Breed buscarRazaPorNombre(String name) throws DaoException
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
	
	public Breed buscarRazaPorId(int id) throws DaoException
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
	
	public List<Breed> obtenerRazas() throws DaoException
	{
		List<Breed> resultado;
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Breed.class);
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
