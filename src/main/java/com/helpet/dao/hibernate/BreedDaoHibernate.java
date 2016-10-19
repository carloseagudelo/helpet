package com.helpet.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.helpet.dao.BreedDao;
import com.helpet.dao.Datasource;
import com.helpet.dto.Breed;
import com.helpet.exception.DaoException;

public class BreedDaoHibernate implements BreedDao {
	
	public void guardar(Breed breed) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.save(breed);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}
	
	public void actualizar(Breed breed) throws DaoException
	{
		Session session = null;
		try
		{
			session = Datasource.getInstance().getSession();			
			session.update(breed);
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
			session = Datasource.getInstance().getSession();
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
			session = Datasource.getInstance().getSession();
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
		try
		{
			session = Datasource.getInstance().getSession();
			session.delete(breed);
		}
		catch(HibernateException e)
		{
			throw new DaoException(e);
		}
	}

}
