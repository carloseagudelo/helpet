package com.helpet.logic;

import java.util.List;

import com.helpet.iw.dto.Breed;
import com.helpet.iw.exception.DaoException;

public interface BreedB1 {
	
	void createBreed(String name) throws DaoException;
	
	void updateBreed(String name, int id) throws DaoException;
	
	void deleteBreed(int id) throws DaoException;
	
	List<Breed> listBreeds() throws DaoException;
	

}
