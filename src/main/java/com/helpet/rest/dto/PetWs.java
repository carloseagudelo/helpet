package com.helpet.rest.dto;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description DTO class that represents the DTO Pet this represent as web service
 * @date 10/17/206  
 * 
*/
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import com.helpet.iw.dto.Breed;
import com.helpet.iw.dto.User;

@XmlRootElement
public class PetWs {
	
	private Integer id;
	private String name;
	private String age;
	private Breed breed;
	private Integer state;
	private String observations;
	private User user;
	private String image;
	private Date date;
	
	public PetWs(){
		
	}

	public PetWs(Integer id, String name, String age, Breed breed, Integer state, String observations, User user,
			String image, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.state = state;
		this.observations = observations;
		this.user = user;
		this.image = image;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
