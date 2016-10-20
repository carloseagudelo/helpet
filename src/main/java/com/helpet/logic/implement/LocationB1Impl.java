package com.helpet.logic.implement;

import java.util.Date;
import java.util.List;

import com.helpet.iw.dao.LocationDao;
import com.helpet.iw.dao.PetDao;
import com.helpet.iw.dao.UserDao;
import com.helpet.iw.dto.Location;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.dto.User;
import com.helpet.iw.exception.DaoException;
import com.helpet.logic.LocationB1;

public class LocationB1Impl implements LocationB1 
{

	UserDao userDao;
	PetDao petDao;
	LocationDao locationDao;
	
	public LocationB1Impl(UserDao userDao, PetDao petDao, LocationDao locationDao)
	{
		this.userDao = userDao;
		this.petDao = petDao;
		this.locationDao = locationDao;
	}
	
	public void registrationLocation(int userId, int petId, float latitude, float longitude, String address, String image,	String Observations, Date date) throws DaoException 
	{
		Location location;
		if (address == null || "".equals(address.trim()))
		{
			throw new NullPointerException("Debe especificar la direccion de la visualizacion.");
        }	
		if (image == null || "".equals(image.trim()))
		{
			throw new NullPointerException("debe especificar la url de la imagen.");
        }
		if (Observations == null || "".equals(Observations.trim()))
		{
			throw new NullPointerException("debe especificar las observaciones.");
        }
		if (date == null)
		{
			throw new NullPointerException("Debe la fecha de visualizacion.");
        }
		User user = userDao.buscarPaisPorId(userId);
		if(user == null)
		{
			throw new NullPointerException("El usuario asociado no existe.");
		}
		Pet pet = petDao.buscarPaisPorId(petId);
		if(pet == null)
		{
			throw new NullPointerException("la mascota asociada no existe.");
		}
		location =  new Location();
		location.setAddress(address);
		location.setDate(date);
		location.setImage(image);
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		location.setObservations(Observations);
		location.setPet(pet);
		location.setUser(user);
		locationDao.guardar(location);
	}

	public void updateLocation(int id, int userId, int petId, float latitude, float longitude, String address, String image, String Observations, Date date) throws DaoException 
	{
		Location location = locationDao.buscarPaisPorId(id);
		if(location == null)
		{
			throw new NullPointerException("El registro a actualizar no existe.");
		}
		if (address == null || "".equals(address.trim()))
		{
			throw new NullPointerException("Debe especificar la direccion de la visualizacion.");
        }	
		if (image == null || "".equals(image.trim()))
		{
			throw new NullPointerException("debe especificar la url de la imagen.");
        }
		if (Observations == null || "".equals(Observations.trim()))
		{
			throw new NullPointerException("debe especificar las observaciones.");
        }
		if (date == null)
		{
			throw new NullPointerException("Debe la fecha de visualizacion.");
        }
		User user = userDao.buscarPaisPorId(userId);
		if(user == null)
		{
			throw new NullPointerException("El usuario asociado no existe.");
		}
		Pet pet = petDao.buscarPaisPorId(petId);
		if(pet == null)
		{
			throw new NullPointerException("la mascota asociada no existe.");
		}
		location.setAddress(address);
		location.setDate(date);
		location.setImage(image);
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		location.setObservations(Observations);
		location.setPet(pet);
		location.setUser(user);
		locationDao.guardar(location);
	}

	public Location showLocation(int id) throws DaoException
	{
		return locationDao.buscarPaisPorId(id);
	}

	public List<Location> ListLocationPet(int idPet) throws DaoException 
	{
		return locationDao.listarVisualizaconesPorMacota(idPet);
	}

}
