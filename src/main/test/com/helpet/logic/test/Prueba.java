package com.helpet.logic.test;


import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})

public class Prueba 
{
	@Autowired
	CountryPrueba test;

	@Test
	public void guardarCountry(){
		test.guardarPais("Ecuador");
	}
	
	@Test
	public void listarCountry(){
		assertEquals(test.listarCountry(), 3);
	}

}