package com.accounts.profession;

//professions are subclasses of Person class
public class Doctor extends Person{

	private String appointment;
	private String prescription;
	
	//super constructor to Person class
	public Doctor(){
		super();
	}
	
	public Doctor(long personID,String firstName,String lastName,
		String dateOfBirth,String local,String appointment,String prescription){
		setPersonID(personID);
		setFirstName(firstName);
		setLastName(lastName);
		setDateOfBirth(dateOfBirth);
		setLocal(local);
		this.appointment= appointment;
		this.prescription= prescription;
	}
	
	//setter methods
	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}
	public void setPrescription(String prescription) {
		this.prescription= prescription;
	}
	
	//getter methods
	public String getAppointment() {
		return appointment;
	}
	public String getPrescription() {
		return prescription;
	}
	
	@Override
	public String toString() { 
        return appointment + "_"  + prescription;
    }
}
