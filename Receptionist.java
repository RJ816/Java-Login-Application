package com.accounts.profession;

public class Receptionist extends Person{

	String transaction;
	
	public Receptionist (){
	}
	public Receptionist (long personID,String firstName,String lastName,
		String dateOfBirth,String local,String transaction){
		setPersonID(personID);
		setFirstName(firstName);
		setLastName(lastName);
		setDateOfBirth(dateOfBirth);
		setLocal(local);
		this.transaction=transaction;
	}
	
	//setter methods
	public void setTransaction(String transaction) {
		this.transaction=transaction;
	}
	
	//getter methods
	public String getTransaction() {
		return transaction;
	}
	
	@Override
	public String toString() { 
		//removed super.toString(),contradicted instruction requirements
        return transaction;
    }
}
