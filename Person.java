package com.accounts.profession;

import java.util.*;

public class Person {
	
	private long personID;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String local;
	private String membershipDate;
	private String email;	
	
	
	public Person() {
		super();
	}
   
	public Person(long personID, String firstName, String lastName, String dateOfBirth, String local ) { 
		super(); 
		this.personID = personID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.local = local;  
		
		this.membershipDate = new java.text.SimpleDateFormat("MM/yy @ hh:mm am").format(new java.util.Date()); 
		this.email=firstName+"."+lastName+"@"+ this.getClass().
		getPackageName().substring(this.getClass().
				getPackageName().lastIndexOf('.')+1)+".com";
	}
   
	//Used to generate a random ID number
	private long getRan() {
		long hi=243609999L;
		long lo=243601000L;
		int diff=(int) (hi-lo);
		long num = (long)(rand() * diff +lo);
		return num;
	}
	
	//generic random number generator
	private double rand() {
		double random=0;
		Random r = new Random();
		random=r.nextDouble();
		r = new Random();
		return random;
	}
	
	public long getPersonID() {
		return personID;
	}

	public void setPersonID(long personID) {
		this.personID = personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
 
	public void setMembershipDate(String membershipDate) {
		this.membershipDate = membershipDate;
	}
 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getMembershipDate() {
		return membershipDate;
	}   
	@Override
	public String toString() {
		return "Person \n{ \n   personID = " + personID + ", "
		+ "\n   firstName = " + firstName + ", "
		+ "\n   lastName = " + lastName + ", "
		+ "\n   dateOfBirth = "	+ dateOfBirth + ", "
		+ "\n   local = " + local + "\n }";
	} 
}
