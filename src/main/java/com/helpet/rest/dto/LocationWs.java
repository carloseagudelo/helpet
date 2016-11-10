package com.helpet.rest.dto;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description DTO class that represents the DTO Location this represent as web service
 * @date 10/17/206  
 * 
*/
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

import com.helpet.iw.dto.Pet;
import com.helpet.iw.dto.User;

@XmlRootElement
public class LocationWs {
	
	private Integer id;	
	private User user;
	private Pet pet;
	private Float latitude;
	private Float longitude;
	private String address;
	private String image;
	private String observations;
	private Date date;
	
	public LocationWs(){
		
	}
	
	public LocationWs(Integer id, User user, Pet pet, Float latitude, Float longitude, String address, String image,
			String observations, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.pet = pet;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
		this.image = image;
		this.observations = observations;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
