//import other package class methods
package com.accounts.profession;

//accounts class for each employee to create an account
//Use comparable interface to compare accounts objects 
public class Accounts implements Comparable<Accounts> {

	//data fields
	private String user;
	private String pass;
	private Person person;
	private String personType;
	
	//constructor
	public Accounts(String user, String pass, Person person) {
		super();
		this.user = user;
		this.pass = pass;
		this.person = person;
		this.personType = person.getClass().getSimpleName();
	}

	//getter and setter methods
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getPersonType() {
		return personType;
	}
	
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	
	@Override
	public String toString() {
		return   person.getPersonID() + "_" +  person.getFirstName() + "_" + 
				 person.getLastName() + "_" + 
				 person.getDateOfBirth() + "_" + 
				 person.getLocal() + "_" + 
				 person.getMembershipDate() + "_" + personType + "_" + pass + "_" + user + "_";

	}

	@Override
	public int compareTo(Accounts o) {
		if (this.getPerson().getLastName().compareToIgnoreCase(o.getPerson().getLastName()) > 0) {
			return 1;
		} else if (this.getPerson().getLastName().compareToIgnoreCase(o.getPerson().getLastName()) < 0) {
			return -1;
		} else {
			if (this.getPerson().getFirstName().compareToIgnoreCase(o.getPerson().getFirstName()) > 0) {
				return 1;
			} else if (this.getPerson().getFirstName().compareToIgnoreCase(o.getPerson().getFirstName()) < 0) {
				return -1;
			} else {
			
				if (this.getPerson().hashCode()>(o.getPerson().hashCode())) {
					return 1;
				} else if (this.getPerson().hashCode()<(o.getPerson().hashCode())) {
					return -1;
				} else
				
				return 0;
			}
		}
	}

}