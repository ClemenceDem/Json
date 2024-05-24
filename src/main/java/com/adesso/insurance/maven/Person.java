package com.adesso.insurance.maven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// IDENTITY = AUTO-INCREMENT
	// TABLE = CREATE TABLE "hibernate-sequences" for id's
	// SEQUENCE = use a created sequence
	// AUTO = choose automatically a strategy: SEQ,TABLE

	private String lastname;
	private String firstname;
	private String sex;
	private String city;
	private String address;
	private int postalcode;
	private String birthDate;
	

	public Person(String lastname, String firstname, String sex, String city, String address, int postalcode, String birthDate) {

		this.lastname = lastname;
		this.firstname = firstname;
		this.sex = sex;
		this.city = city;
		this.address = address;
		this.postalcode = postalcode;
		this.birthDate = birthDate;
	}

	 
    public Person() {}
    
	public Person(String lastname, String firstname) {
		this.lastname = lastname;
		this.firstname = firstname;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

}
