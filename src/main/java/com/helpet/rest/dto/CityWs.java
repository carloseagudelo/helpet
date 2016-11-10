package com.helpet.rest.dto;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description DTO class that represents the DTO City this represent as web service
 * @date 10/17/206  
 * 
*/

import javax.xml.bind.annotation.XmlRootElement;

import com.helpet.iw.dto.Country;

@XmlRootElement
public class CityWs {
	
	private Integer id;
	private String name;
	private Country country;
	
	public CityWs(){
		
	}

	public CityWs(Integer id, String name, Country country) {
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	

}
