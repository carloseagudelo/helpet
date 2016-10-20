package com.helpet.logic;

import java.util.List;
import com.helpet.iw.dto.Pet;
import com.helpet.iw.exception.DaoException;
import java.util.Date;

public interface PetB1 {
	
	void registrationPet(String name, String age, int state, String observation, String image,  Date date, int userId, int breedId) throws DaoException;
	
	void updatePet(int id, String name, String age, int state, String observation, String image,  Date date, int userId, int breedId) throws DaoException;
	
	Pet showPetInfotmation(int id) throws DaoException;
	
	List<Pet> listPet() throws DaoException;

}
