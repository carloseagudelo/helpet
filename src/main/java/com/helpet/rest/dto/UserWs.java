package com.helpet.rest.dto;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description DTO class that represents the DTO User this represent as web service
 * @date 10/17/206  
 * 
*/

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import com.helpet.iw.dto.City;

@XmlRootElement
public class UserWs {
	
	private Integer id;
	private String name;	
	private String lastName;
	private City city;
	private String address;
	private String email;
	private String password;	
	private String image;
	private String document;
	private Date date;
	
	public UserWs(){
		
	}

	public UserWs(Integer id, String name, String lastName, City city, String address, String email, String password,
			String image, String document, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.city = city;
		this.address = address;
		this.email = email;
		this.password = password;
		this.image = image;
		this.document = document;
		this.date = date;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
