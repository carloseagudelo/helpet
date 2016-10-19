package com.helpet.logic.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})

public class Test 
{
	@Autowired
	CountryTest test;

	@org.junit.Test
	public void guardarCountry(){
		test.guardarCiudad("Colombia",2);
	}

}
