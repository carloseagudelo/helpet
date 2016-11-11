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
import com.helpet.logic.PetB1;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})
public class PetB1ImplTest {

	@Autowired
	PetB1 petB1;
	
	@Test
	public void testRegistrationPet() throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String name = "Chimuelo";
			String age = "3 años";
			int state = 4;
			String observation = "Negro con ojos amarillos";
			String image = "Chimuelo.jpg";
			Date date = sdf.parse("2013-05-10"); 
			int userId = 1; 
			int breedId = 4;
			
			petB1.registrationPet(name, age, state, observation, image, date, userId, breedId);
		
		}catch(DaoException e){
			fail(e.getMessage());
		}
	}
}
