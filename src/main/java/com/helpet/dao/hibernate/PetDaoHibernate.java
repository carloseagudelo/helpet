package com.helpet.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.helpet.dao.Datasource;
import com.helpet.dao.PetDao;
import com.helpet.dto.Pet;
import com.helpet.exception.DaoException;

public class PetDaoHibernate implements PetDao 
{
	public void guardar(Pet pet) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.save(pet);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(Pet pet) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.update(pet);
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
			session = Datasource.getInstance().getSession();
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
			session = Datasource.getInstance().getSession();
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
		try
		{
			session = Datasource.getInstance().getSession();
			session.delete(pet);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
}
