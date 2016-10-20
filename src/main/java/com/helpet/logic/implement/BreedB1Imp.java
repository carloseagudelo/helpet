package com.helpet.logic.implement;

import com.helpet.iw.dao.BreedDao;
import com.helpet.iw.dto.Breed;
import com.helpet.iw.dto.Country;
import com.helpet.iw.exception.DaoException;
import com.helpet.logic.BreedB1;
import java.util.List;

public class BreedB1Imp implements BreedB1 {

	BreedDao breedDao;
	
	public BreedB1Imp(BreedDao breedDao)
	{
		this.breedDao = breedDao;
	}
	
	public void createBreed(String name) throws DaoException
	{
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar el nombre de la raza.");
        }	
		if(breedDao.buscarRazaPorNombre(name) != null)
		{
			throw new NullPointerException("La ciudad ya existe.");
		}
		Breed breed = new Breed();
		breed.setName(name);
		breedDao.guardar(breed);
	}

	public void updateBreed(String name, int id) throws DaoException
	{
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar el nombre de la raza.");
        }	
		if(breedDao.buscarRazaPorNombre(name) != null)
		{
			throw new NullPointerException("La raza ya existe.");
		}
		Breed breed = breedDao.buscarRazaPorId(id);
		breed.setName(name);
		breedDao.actualizar(breed);
	}

	public void deleteBreed(int id) throws DaoException
	{
		Breed breed = breedDao.buscarRazaPorId(id);
		if(breed == null)
		{
			throw new NullPointerException("La raza que intenta eliminar no existe.");
		}		
		breedDao.eliminar(breed);
	}
	
	public List<Breed> listBreeds() throws DaoException
	{		
		return breedDao.obtenerRazas();
	}

}
