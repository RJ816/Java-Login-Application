package com.accounts.profession;

public class Patient extends Person{

	private double funds;
	private String symptoms;
	
	//default constructor
	public Patient (){
	}
	
	public Patient (long personID,String firstName,String lastName,
		String dateOfBirth,String local,double funds,String symptoms){
		setPersonID(personID);
		setFirstName(firstName);
		setLastName(lastName);
		setDateOfBirth(dateOfBirth);
		setLocal(local);
		this.funds= funds;
		this.symptoms= symptoms;
	}
	
	//setter methods
	public void setFunds(double funds) {
		this.funds= funds;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms= symptoms;
	}
	
	//getter methods
	public double getFunds() {
		return funds;
	}
	public String getSymptoms() {
		return symptoms;
	}
	
	@Override
	//removed super.toString(),contradicted instruction requirements
	public String toString() { 
		return  +funds + "_"  + symptoms;
    }
}