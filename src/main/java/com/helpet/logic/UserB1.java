package com.helpet.logic;

import com.helpet.iw.exception.DaoException;
import java.util.Date;

public interface UserB1 {
	
	void registrationUser(String name, String lasName, int cityId, String address, String email, String password, String image, String document, Date date) throws DaoException;
	
	void updateUser(String name, String lasName, int cityId, String address, String email, String password, String image, String document, Date date) throws DaoException;
	
	boolean login(String email, String password) throws DaoException;
	
	void loginSocialNtwork() throws DaoException;
}
