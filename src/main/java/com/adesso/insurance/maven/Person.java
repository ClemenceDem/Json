package com.adesso.insurance.maven;

public class Person {

	private	String lastname ;
	private String firstname ;
	private	String sex ;
	private	String city ;
	private	String address;
	private	int postalcode;
	
	
	
	
	
	public Person(String lastname, String firstname, String sex, String city, String address, int postalcode) {
		
		this.lastname = lastname;
		this.firstname = firstname;
		this.sex = sex;
		this.city = city;
		this.address = address;
		this.postalcode = postalcode;
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
		
		
		


}
