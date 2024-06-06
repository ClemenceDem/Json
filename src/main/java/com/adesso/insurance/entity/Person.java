package com.adesso.insurance.entity;

import javax.persistence.Entity;


@Entity
public class Person {

    private int id;
	private String lastname;
	private String firstname;
	private String gender;
	private String city;
	private String street;
	private String birthDate;
	private int postalcode;

    public Person(int id, String lastname, String firstname, String gender, String city, String street, int postalcode,
            String birthDate) {
        this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		this.city = city;
		this.street = street;
		this.postalcode = postalcode;
		this.birthDate = birthDate;
	}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}

	@Override
	public String toString() {
        return "Person [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", gender=" + gender + ", city=" + city
				+ ", street=" + street + ", postalcode=" + postalcode + ", birthDate=" + birthDate + "]";
	}

	
	

	public boolean compareTo(Person pers) {
        if (this == pers) 
        	return true; // Vérifie si les objets sont identiques
        if (pers == null || getClass() != pers.getClass())
        	return false; // Vérifie si l'objet est du même type
        return getId() == (pers.id) &&
                getLastname().equals(pers.lastname) &&
               getFirstname().equals(pers.firstname) &&
               getGender().equals(pers.gender) &&
               getCity().equals(city) &&
               getStreet().equals(street) &&
               getPostalcode() == postalcode &&
               getBirthDate().equals(birthDate) ;
    }
 
	}
	
	
	
	        
	    

		
	

		 
	    
	    

