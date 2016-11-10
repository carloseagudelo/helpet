package com.helpet.rest.dto;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description DTO class that represents the DTO Breed this represent as web service
 * @date 10/17/206  
 * 
*/

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BreedWs {
	
	private Integer id;
	private String name;
	private String observations;
	
	public BreedWs(){
		
	}
	
	public BreedWs(Integer id, String name, String observations){
		this.id = id;
		this.name = name;
		this.observations = observations;
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
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	

}
