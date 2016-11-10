package com.helpet.rest.dto;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description DTO class that represents the DTO Country this represent as service
 * @date 10/17/206  
 * 
*/

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CountryWs {
	
	private Integer id;
	private String name;
	
	public CountryWs(){
		
	}

    public CountryWs(Integer id, String name){
		this.id = id;
		this.name = name;
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
}
