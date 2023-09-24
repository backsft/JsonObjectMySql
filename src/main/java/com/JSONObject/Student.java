package com.JSONObject;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(columnDefinition = "JSON")
    @Convert(converter = InterestAndHobbiesConverter.class)
    private InterestAndHobbies interestAndHobbies;
    
    List<String> address;
    
    

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InterestAndHobbies getInterestAndHobbies() {
		return interestAndHobbies;
	}

	public void setInterestAndHobbies(InterestAndHobbies interestAndHobbies) {
		this.interestAndHobbies = interestAndHobbies;
	}

    
    
    
    
    
}