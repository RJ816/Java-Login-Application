package com.login;

import java.util.*;
import java.io.*;
import java.text.*;
import com.accounts.profession.*;

public class MainProgram {
	static File f = new File("userDataStored.txt");
	public static void main (String [] args) throws Exception {
		MainProgram main = new MainProgram();
		main.introFlow1(); 
	}
	
	 private void introFlow1() { 
		Scanner so=new Scanner(System.in);
		System.out.println("This program will allow a doctor, patient,"
				+ " or receptionist to login or sign up for a hospital"
				+ " account.\nThe user will then provide relevant information"
				+ " so the account can be created or updated.");
		loopMainMenu_Flow2(so);
	}
	
	 private void loopMainMenu_Flow2(Scanner so) { 
		boolean inputCheck=true;
		System.out.println("Execute Program? Enter 1 for yes, 2 for no.");
		
		do {
			try {
				switch (so.nextInt()) {
					case 1: mainMenu_Flow3(so);
						break;
					case 2: System.exit(0);
						break;
					default: System.out.println("Invalid input. Please enter correct format.");
						loopMainMenu_Flow2(so);
						break;
				}
				
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				//consume empty token in buffer from nextInt().
				so.nextLine();
			}
		} while (inputCheck);
	} 
	
	//main menu options
	 private void mainMenu_Flow3(Scanner so) {
		boolean inputCheck=true;
		System.out.println("Enter 1 to Sign up, 2 to Log in, 3 to Exit.");
		
		/**Try catch block to make sure user only enters options available.
		 * Will keep displaying exception until user inputs correctly.
		 * Blocks used in subsequent code to catch similar exceptions.
		 */
		do {
			try {
				switch (so.nextInt()) {
					case 1: signMenuLoop_Flow4(so);
						break;
					case 2: logInMenuLoop_View8(so);
						break;
					case 3: exitMenu_View10(so);
						break;
					default: System.out.println("Invalid input. Please enter correct format.");
					mainMenu_Flow3(so);
						break;
				}
				
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				//consume empty token in buffer from nextInt().
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	private void signMenuLoop_Flow4(Scanner so) { 
		signMenu_Flow5(so);
	}
	
	//options for user to either manually or randomly generate user information.
	private void signMenu_Flow5(Scanner so) {
		boolean inputCheck=true;
		
		System.out.println("Enter 1 to input your information,"
				+ " 2 to autogenerate random information, or"
				+ " 3 to go back.");

		do {
			try {
				switch (so.nextInt()) {
					case 1: signUserInput_Flow6(so);
						break;
					case 2: signRandomInput_View7(so);
						break;
					case 3:  mainMenu_Flow3(so);
						break;
					default: System.out.println("Invalid input. Please enter correct format.");
					signMenu_Flow5(so);
						break;
				}
				
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	/**Manual user input option. Variables created for non-Person 
	 * specific object fields to allow for specific questions.
	 */
	private void signUserInput_Flow6(Scanner so) {
		int role=0;
		boolean inputCheck=true;
		Person person=new Person();
		String appointment="";
		String prescription="";
		double funds=0.0;
		String symptom="";
		String transaction="";
		
		do {
			try {
				System.out.println("Enter 1 if you're a doctor,"
						+" 2 if you're a patient,"
						+" or 3 if you're a receptionist.");
				role=so.nextInt();
				so.nextLine();
				
				if (role==1 | role==2 | role==3) {
				//Same questions for all person objects.
					System.out.println("What is your first name?");
					person.setFirstName(so.nextLine());
					System.out.println("What is your last name?");
					person.setLastName(so.nextLine());
					System.out.println("What is your DOB? Please enter in"
						+ " MM/DD/YYYY format.");
					person.setDateOfBirth(so.nextLine());
					System.out.println("What city do you live in?");
					person.setLocal(so.nextLine());
				} else {
					System.out.println("Invalid input. Please enter correct format.");
					signUserInput_Flow6(so);
				}
				//switch block for each person subclass input.
				switch (role) { 
					case 1: System.out.println("What is your provider ID?");
						person.setPersonID(so.nextLong());
						so.nextLine();
						
						do {
							try {
								if (person.getPersonID()<1572201110 || person.getPersonID()>1572209990) {
								System.out.println("Invalid input. Please enter "
										+ "an ID number between 1572201110 and 1572209990,");
								System.out.println("What is your provider ID?");
								person.setPersonID(so.nextLong());
								so.nextLine();
								}
								else inputCheck=false;
							} catch (Exception e) {
								System.out.println("Please enter correct format.");
								so.nextLine();
							}
						} while (inputCheck);
						
						System.out.println("What is the appointment date? "
						+ "Please enter in MM/DD/YYYY format.");
						appointment=so.nextLine();
						System.out.println("What prescription is being filled?");
						prescription=so.nextLine();
						
						//Doctor object created and overridden toString method called.
						Person doctor=new Doctor(person.getPersonID(),
								person.getFirstName(),person.getLastName(),
								person.getDateOfBirth(),person.getLocal(),
								appointment,prescription);
						
						String [] selectedDoctor = {String.valueOf(doctor.getPersonID()),
								doctor.getFirstName(),doctor.getLastName(),
								doctor.getDateOfBirth(),doctor.getLocal(),
								((Doctor) doctor).getAppointment(),
								((Doctor) doctor).getPrescription()};
						
						System.out.println(doctor.toString());
						//Ask user to confirm input is correct, re-enter if needed.
						System.out.println("Is the information correct? Enter "
								+ "1 for yes, 2 for no.");
						inputCheck=true;
						do {
							try {
								switch (so.nextInt()) {
									case 1: signController_View8(so,selectedDoctor);
										break;
									case 2: signUserInput_Flow6(so);
										break;
									default: System.out.println("Invalid input. Please enter correct format.");
										break;
								}
								
								inputCheck=false;
							} catch (Exception e) {
								System.out.println("Invalid input. Please enter correct format.");
								so.nextLine();
							}
						} while (inputCheck);
							break;
					case 2: System.out.println("What is your MRN number?");
						person.setPersonID(so.nextLong());
						
						do {
							try {
								if (person.getPersonID()<1572201110 || person.getPersonID()>1572209990) {
								System.out.println("Invalid input. Please enter"
										+ "an ID number between 1572201110 and 1572209990,");
								System.out.println("What is your provider ID?");
								person.setPersonID(so.nextLong());
								so.nextLine();
								}
								else inputCheck=false;
							} catch (Exception e) {
								System.out.println("Please enter correct format.");
								so.nextLine();
							}
						} while (inputCheck);
						
						System.out.println("What is your deductible?");
						funds=so.nextDouble();
						so.nextLine();
						System.out.println("What is your symptom?");
						symptom=so.nextLine();
	
						Person patient=new Patient(person.getPersonID(),
								person.getFirstName(),person.getLastName(),
								person.getDateOfBirth(),person.getLocal(),
								funds,symptom);
						String [] selectedPatient = {String.valueOf(patient.getPersonID()),
								patient.getFirstName(),patient.getLastName(),
								patient.getDateOfBirth(),patient.getLocal(),
								String.valueOf(((Patient) patient).getFunds()),
								((Patient) patient).getSymptoms()};
						
						System.out.println(patient.toString());
						System.out.println("Is the information correct? Enter "
								+ "1 for yes, 2 for no.");
						inputCheck=true;
						do {
							try {
								switch (so.nextInt()) {
									case 1: signController_View8(so,selectedPatient);;
										break;
									case 2: signUserInput_Flow6(so);
										break;
									default: System.out.println("Invalid input. Please enter correct format.");
										break;
								}
								
								inputCheck=false;
							} catch (Exception e) {
								System.out.println("Invalid input. Please enter correct format.");
								//consume empty token in buffer from nextInt().
								so.nextLine();
							}
						} while (inputCheck);
							break;
					case 3: System.out.println("What is your Employee ID?");
						person.setPersonID(so.nextLong());
						so.nextLine();
						
						do {
							try {
								if (person.getPersonID()<1572201110 || person.getPersonID()>1572209990) {
								System.out.println("Invalid input. Please enter"
										+ "an ID number between 1572201110 and 1572209990,");
								System.out.println("What is your provider ID?");
								person.setPersonID(so.nextLong());
								so.nextLine();
								}
								else inputCheck=false;
							} catch (Exception e) {
								System.out.println("Please enter correct format.");
								so.nextLine();
							}
						} while (inputCheck);
						
						System.out.println("What is the transaction ID?");
						transaction=so.nextLine();
						
						Person receptionist=new Receptionist(person.getPersonID(),
								person.getFirstName(),person.getLastName(),
								person.getDateOfBirth(),person.getLocal(),
								transaction);
						
						String [] selectedReceptionist = {String.valueOf(receptionist.getPersonID()),
								receptionist.getFirstName(),receptionist.getLastName(),
								receptionist.getDateOfBirth(),receptionist.getLocal(),
								((Receptionist) receptionist).getTransaction()};
						System.out.println(receptionist.toString());
						System.out.println("Is the information correct? Enter "
								+ "1 for yes, 2 for no.");
						inputCheck=true;
						do {
							try {
								switch (so.nextInt()) {
									case 1: signController_View8(so,selectedReceptionist);
										break;
									case 2: signUserInput_Flow6(so);
										break;
									default: System.out.println("Invalid input. Please enter correct format.");
										break;
								}
								
								inputCheck=false;
							} catch (Exception e) {
								System.out.println("Invalid input. Please enter correct format.");
								//consume empty token in buffer from nextInt().
								so.nextLine();
							}
						} while (inputCheck);
					default: System.out.println("Invalid input. Please enter correct format.");
					signUserInput_Flow6(so);
						break; 
				}
				
				inputCheck=false;		
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	//Random user input option
	private void signRandomInput_View7(Scanner so) { 
		int role=0;
		boolean inputCheck=true;
		Person person=new Person();
		String appointment="";
		String prescription="";
		double funds=0.0;
		String symptom="";
		String transaction="";
		
		do {
			try {
				System.out.println("Enter 1 if you're a doctor,"
					+" 2 if you're a patient,"
					+" or 3 if you're a receptionist.");
				role=so.nextInt();
				so.nextLine();

				if (!(role==1 | role==2 | role ==3))
					System.out.println("Invalid input. Please enter correct format.");

				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
		
		/**Will display questions then answers, creates the specific 
		 * subclass object, then displays all fields with values
		 * for user to double check the information. Generates non specific
		 * Person object fields first, then generates specific subclass fields
		 * based on user choice.
		 */
		System.out.println("What is your first name?");
		person.setFirstName(GeneratedRandomFieldValues.randomFirstName());
		System.out.println(person.getFirstName());
		System.out.println("What is your last name?");
		person.setLastName(GeneratedRandomFieldValues.randomLastName());
		System.out.println(person.getLastName());
		System.out.println("What is your DOB? Please enter in"
		+ " MM/DD/YYYY format.");
		person.setDateOfBirth(GeneratedRandomFieldValues.randomDate());
		System.out.println(person.getDateOfBirth());
		System.out.println("What city do you live in?");
		person.setLocal(GeneratedRandomFieldValues.randomLocal());
		System.out.println(person.getLocal());
			
		switch (role) { 
			case 1: System.out.println("What is your provider ID?");
					person.setPersonID(GeneratedRandomFieldValues.randomID());
					System.out.println(person.getPersonID());
					System.out.println("What is the appointment date? "
							+ "Please enter in MM/DD/YYYY format.");
					appointment=GeneratedRandomFieldValues.randomDate();
					System.out.println(appointment);
					System.out.println("What prescription is being filled?");
					prescription=GeneratedRandomFieldValues.randomPrescription();
					System.out.println(prescription);	
					
					Person doctor=new Doctor(person.getPersonID(),
							person.getFirstName(),person.getLastName(),
							person.getDateOfBirth(),person.getLocal(),
							appointment,prescription);
						
					String [] selectedDoctor = {String.valueOf(doctor.getPersonID()),
							doctor.getFirstName(),doctor.getLastName(),
							doctor.getDateOfBirth(),doctor.getLocal(),
							((Doctor) doctor).getAppointment(),
							((Doctor) doctor).getPrescription()};
						
					System.out.println(doctor.toString());
					signController_View8(so,selectedDoctor);
						break;
					case 2: System.out.println("What is your MRN number?");
						person.setPersonID(GeneratedRandomFieldValues.randomID());
						System.out.println(person.getPersonID());
						System.out.println("What is your deductible?");
						funds=GeneratedRandomFieldValues.ranNum2(0,10000);
						System.out.println(String.valueOf(funds));
						System.out.println("What is your symptom?");
						symptom=GeneratedRandomFieldValues.randomSymptom();
						System.out.println(symptom);
	
						Person patient=new Patient(person.getPersonID(),
								person.getFirstName(),person.getLastName(),
								person.getDateOfBirth(),person.getLocal(),
								funds,symptom);
						String [] selectedPatient = {String.valueOf(patient.getPersonID()),
								patient.getFirstName(),patient.getLastName(),
								patient.getDateOfBirth(),patient.getLocal(),
								String.valueOf(((Patient) patient).getFunds()),
								((Patient) patient).getSymptoms()};
						
						System.out.println(patient.toString());
						signController_View8(so,selectedPatient);
							break;
					case 3: System.out.println("What is your Employee ID?");
						person.setPersonID(GeneratedRandomFieldValues.randomID());
						System.out.println(person.getPersonID());
						System.out.println("What is the transaction ID?");
						transaction=String.valueOf(GeneratedRandomFieldValues.ranNum2(0,1000));
						System.out.println(transaction);
						
						Person receptionist=new Receptionist(person.getPersonID(),
								person.getFirstName(),person.getLastName(),
								person.getDateOfBirth(),person.getLocal(),
								transaction);
						
						String [] selectedReceptionist = {String.valueOf(receptionist.getPersonID()),
							receptionist.getFirstName(),receptionist.getLastName(),
							receptionist.getDateOfBirth(),receptionist.getLocal(),
							((Receptionist) receptionist).getTransaction()};

						System.out.println(receptionist.toString());
						signController_View8(so,selectedReceptionist);
		}
	}
	
	/** Adds person or person subclass objects and date/time created to
	 * an ArrayList in the Static file declared in the first line of MainProgram.
	 * Displays messages to determine if objects written to file successfully
	 * or not, then loops back to main menu.
	 */
	private void signController_View8(Scanner so, String [] selectedPerson) {
		ArrayList <String> personTypeListFiled=new ArrayList<>(Arrays.asList(selectedPerson));
		Date date = new Date();
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
		String currentDateTime="";
		currentDateTime = (formatter.format(date));
		
		//add date and to ArrayList.
		personTypeListFiled.add(0,currentDateTime);		
		
		if (f.exists()) {
			try {
				FileWriter fw = new FileWriter(f,true);
				for (String s : personTypeListFiled)
					fw.write(s+"\n");
				fw.close();
				System.out.println("Complete!");
			} catch (Exception e) {
				System.out.println("Something went wrong!");
			}
		} else {
			try {
				PrintWriter pw=new PrintWriter(f);
				for (String s:personTypeListFiled)
					pw.print(s+"\n");
				pw.close();
				System.out.println("Complete!");
			}
			catch (Exception e) {
				System.out.println("Something went wrong!");
			}
		}
		mainMenu_Flow3(so);
	}
	
	private void logInMenuLoop_View8(Scanner so) { 
		logInMenu_View9(so);
		mainMenu_Flow3(so);
	}
	
	//Login with ID number, catches invalid numbers
	private List logInMenu_View9(Scanner so) { 
		System.out.println("Enter ID number");
		String idNumber=so.next();
		int num=0;
		String str="";
		
		try {
			num=Integer.parseInt(idNumber);
		} catch (Exception e) {
			System.out.println("not id number");
			str="/\\/\\ - error";
		}

		final int hi=1572209990;
		final int lo=1572201110;

		try {
			if(num>=lo && num<=hi) {
				System.out.println("\nvalid id number\n");
			} else {
				System.out.println(num/0);
			}
		} catch (Exception e) {
			System.out.println("invalid id number");
			str="/\\/\\ - error";
		}
		
		List<String>list=new ArrayList<String>(); 
		idNumber = idNumber.trim();
		
		try {
			Scanner read=new Scanner(f);
			while (read.hasNextLine()) {
				list.add(read.nextLine());
			}
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int firstIndex=-1,lastIndex=-1;
		List<String> personList=new ArrayList<String>(); 

		for (int i=0;i<list.size();i++) {
			if (list.get(i).equalsIgnoreCase(idNumber)) {
				firstIndex=i-1;
				lastIndex=i+7;
			}
		}
		for (int j=firstIndex;j<lastIndex;j++) { 
			personList.add(list.get(j));
		}
		return personList;
	} 
	
	//displays end of program
	private void exitMenu_View10(Scanner so) {
		System.out.println("Program executed and closing.");
		so.close();
		System.exit(0);
	}
}