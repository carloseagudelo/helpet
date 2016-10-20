package com.helpet.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.helpet.iw.dao.PetDao;
import com.helpet.iw.dto.City;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.exception.DaoException;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Implements methods for Pet
 * @date 10/17/206 
 *
 */

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
	
	public List<Pet> ListarMascotas() throws DaoException
	{
		List<Pet> resultado;
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Pet.class);
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
