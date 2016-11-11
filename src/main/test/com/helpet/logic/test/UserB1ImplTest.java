package com.helpet.logic.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.helpet.iw.exception.DaoException;
import com.helpet.logic.UserB1;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})
public class UserB1ImplTest {

	@Autowired
	UserB1 userB1;
	
	@Test
	public void testRegistrationUser() throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String name = "Marcela";
			String lastName = "Londono";
			int cityId = 1;
			String address = "Cra 72 # 25B-19";
			String email = "mlondono@gmail.com";
			String password = "mlondono12345"; 
			String image = "MarcelaL.jpg";
			String document = "1234567890";
			Date date = sdf.parse("1989-05-03");
			
			userB1.registrationUser(name, lastName, cityId, address, email, password, image, document, date);
			
		}catch(DaoException e){
			fail(e.getMessage());
		}
	}
}
