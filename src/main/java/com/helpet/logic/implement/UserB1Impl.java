package com.helpet.logic.implement;

import java.util.Date;

import com.helpet.iw.dao.CityDao;
import com.helpet.iw.dao.UserDao;
import com.helpet.iw.dto.City;
import com.helpet.iw.dto.User;
import com.helpet.iw.exception.DaoException;
import com.helpet.logic.UserB1;

/**
 * Class thats define the methods for access to methods in lauyer of data in User
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Implements methods for Breed
 * @date 10/17/206 
 *
 */

public class UserB1Impl implements UserB1 {
	
	UserDao userDao;
	CityDao cityDao;
	
	public UserB1Impl(UserDao userDao, CityDao cityDao)
	{
		this.userDao = userDao;
		this.cityDao = cityDao;
	}

	public void registrationUser(String name, String lastName, int cityId, String address, String email, String password, String image, String document, Date date) throws DaoException
	{
		User user;
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar el nombre del usuario.");
        }
		if (lastName == null || "".equals(lastName.trim()))
		{
			throw new NullPointerException("Debe especificar el apellido del usuario.");
        }
		if (address == null || "".equals(address.trim()))
		{
			throw new NullPointerException("Debe especificar la direccion del usuario.");
        }
		if (email == null || "".equals(email.trim()))
		{
			throw new NullPointerException("Debe especificar el email del usuario.");
        }
		if (password == null || "".equals(password.trim()))
		{
			throw new NullPointerException("Debe especificar la contraseña del usuario.");
        }
		if (document == null || "".equals(document.trim()))
		{
			throw new NullPointerException("Debe especificar el documento del usuario.");
        }
		if (date == null)
		{
			throw new NullPointerException("Debe especificar la fecha de registro.");
        }
		if(userDao.BuscarUsuarioPorEmail(email) != null )
		{
			throw new NullPointerException("Ya existe un usuario con este correo.");
		}	
		City city = cityDao.buscarPaisPorId(cityId);
		if(city == null)
		{
			throw new NullPointerException("La ciudad del usuario no existe.");
		}
		user = new User();
		user.setName(name);
		user.setLastName(lastName);
		user.setCity(city);
		user.setAddress(address);
		user.setEmail(email);
		user.setPassword(password);
		user.setImage(image);
		user.setDocument(document);
		user.setDate(date);
		userDao.guardar(user);
	}

	public void updateUser(String name, String lastName, int cityId, String address, String email, String password, String image, String document, Date date) throws DaoException
	{
		User user = userDao.BuscarUsuarioPorEmail(email);
		if(user == null)
		{
			throw new NullPointerException("El usuario a actualizar no existe.");
		}
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar el nombre del usuario.");
        }
		if (lastName == null || "".equals(lastName.trim()))
		{
			throw new NullPointerException("Debe especificar el apellido del usuario.");
        }
		if (address == null || "".equals(address.trim()))
		{
			throw new NullPointerException("Debe especificar la direccion del usuario.");
        }
		if (email == null || "".equals(email.trim()))
		{
			throw new NullPointerException("Debe especificar el email del usuario.");
        }
		if (password == null || "".equals(password.trim()))
		{
			throw new NullPointerException("Debe especificar la contraseña del usuario.");
        }
		if (document == null || "".equals(document.trim()))
		{
			throw new NullPointerException("Debe especificar el documento del usuario.");
        }
		if (date == null)
		{
			throw new NullPointerException("Debe especificar la fecha de actualización.");
        }
		City city = cityDao.buscarPaisPorId(cityId);
		if(city == null)
		{
			throw new NullPointerException("La ciudad del usuario no existe.");
		}
		user.setName(name);
		user.setLastName(lastName);
		user.setCity(city);
		user.setAddress(address);
		user.setPassword(password);
		user.setImage(image);
		user.setDocument(document);
		user.setDate(date);
		userDao.guardar(user);		
	}

	public boolean login(String email, String password) throws DaoException 
	{
		if (email == null || "".equals(email.trim()))
		{
			throw new NullPointerException("Debe especificar el email del usuario.");
        }
		if (password == null || "".equals(password.trim()))
		{
			throw new NullPointerException("Debe especificar la contraseña del usuario.");
        }
		return userDao.autentificacion(email, password);
	}

	public void loginSocialNetwork() throws DaoException
	{
		
	}
}
