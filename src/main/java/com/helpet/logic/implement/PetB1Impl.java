package com.helpet.logic.implement;

import java.util.Date;
import java.util.List;

import com.helpet.iw.dao.PetDao;
import com.helpet.iw.dao.UserDao;
import com.helpet.iw.dao.BreedDao;
import com.helpet.iw.dto.Breed;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.dto.User;
import com.helpet.iw.exception.DaoException;
import com.helpet.logic.PetB1;

/**
 * Class thats define the methods for access to methods in lauyer of data in Pet
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Implements methods for Breed
 * @date 10/17/206 
 *
 */

public class PetB1Impl implements PetB1 
{

	PetDao petDao;
	UserDao userDao;
	BreedDao breedDao;
	
	public PetB1Impl(PetDao petDao, UserDao userDao, BreedDao breedDao)
	{
		this.petDao = petDao;
		this.userDao = userDao;
		this.breedDao = breedDao;
	}
	
	public void registrationPet(String name, String age, int state, String observation, String image, Date date, int userId, int breedId) throws DaoException 
	{
		Pet pet;
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar el nombre de la mascota perdida.");
        }
		if (age == null || "".equals(age.trim()))
		{
			throw new NullPointerException("Debe especificar la edad de la mascota perdida.");
        }
		if (state == 0)
		{
			throw new NullPointerException("Debe especificar el estado de la mascota ['PERDIDA', 'ENCONTRADA', 'VISTA'].");
        }
		if(state < 0 || state > 2)
		{
			throw new NullPointerException("Debe especificar el estado valido.");
		}
		if (date == null)
		{
			throw new NullPointerException("Debe especificar la fecha de desaparecida.");
        }
		if (image == null || "".equals(image.trim()))
		{
			throw new NullPointerException("Debe especificar la ruta de la imagen de la mascota.");
        }
		User user = userDao.buscarPaisPorId(userId);
		if(user == null)
		{
			throw new NullPointerException("El usuario asociado no existe.");
		}
		Breed breed = breedDao.buscarRazaPorId(breedId);
		if(breed == null)
		{
			throw new NullPointerException("La raza asociada no existe.");
		}
		pet = new Pet();
		pet.setAge(age);
		pet.setBreed(breed);
		pet.setDate(date);
		pet.setImage(image);
		pet.setName(name);
		pet.setObservations(observation);
		pet.setState(state);
		pet.setUser(user);
		petDao.guardar(pet);
		
	}

	public void updatePet(int id, String name, String age, int state, String observation, String image, Date date, int userId, int breedId) throws DaoException 
	{
		Pet pet = petDao.buscarPaisPorId(id);
		if(pet == null)
		{
			throw new NullPointerException("La mascota a actualizar no existe.");
		}
		if (name == null || "".equals(name.trim()))
		{
			throw new NullPointerException("Debe especificar el nombre de la mascota perdida.");
        }
		if (age == null || "".equals(age.trim()))
		{
			throw new NullPointerException("Debe especificar la edad de la mascota perdida.");
        }
		if (state == 0)
		{
			throw new NullPointerException("Debe especificar el estado de la mascota ['PERDIDA', 'ENCONTRADA', 'VISTA'].");
        }
		if(state < 0 || state > 2)
		{
			throw new NullPointerException("Debe especificar el estado valido.");
		}
		if (date == null)
		{
			throw new NullPointerException("Debe especificar la fecha de desaparecida.");
        }
		if (image == null || "".equals(image.trim()))
		{
			throw new NullPointerException("Debe especificar la ruta de la imagen de la mascota.");
        }
		User user = userDao.buscarPaisPorId(userId);
		if(user == null)
		{
			throw new NullPointerException("El usuario asociado no existe.");
		}
		Breed breed = breedDao.buscarRazaPorId(breedId);
		if(breed == null)
		{
			throw new NullPointerException("La raza asociada no existe.");
		}
		pet.setAge(age);
		pet.setBreed(breed);
		pet.setDate(date);
		pet.setImage(image);
		pet.setName(name);
		pet.setObservations(observation);
		pet.setState(state);
		pet.setUser(user);
		petDao.actualizar(pet);
	}

	public Pet showPetInfotmation(int id) throws DaoException 
	{
		return petDao.buscarPaisPorId(id);
	}

	public List<Pet> listPet() throws DaoException 
	{
		return petDao.ListarMascotas();
	}

}
