package com.login;

import java.io.*;
import java.util.*;
import com.accounts.profession.*;

public class DataStructuresProgram {
	
	public static void main (String [] args) throws Exception {
		DataStructuresProgram main=new DataStructuresProgram();
		main.Menu1();
	}
	
	/**Creates a set that generates random person subclass types and their
	 * respective accounts, then converts the set to a list.
	 * @param numOfPersons size of set/list
	 * @return List of random accounts
	 */
	public List<Accounts> createRandomPersons (int numOfPersons) {
		Set <Accounts> accountsSet=new HashSet<Accounts>(numOfPersons);
		for (int i=0;i<numOfPersons;i++) {
			accountsSet.add(GeneratedRandomFieldValues.randomPerson());
		}
		List <Accounts> accountsList=new ArrayList<Accounts>(accountsSet);
		return accountsList;
	}
	
	/**Creates 3 files to hold each Person sub-type created from 
	 * createRandomPersons respectively
	 * @param 3 files for doctor, patient and receptionist accounts separately.
	 */
	public void storeSetFile (List<Accounts> list) {
		File doctor = new File("doctorAccountList.txt");
		File patient = new File("patientAccountList.txt");
		File receptionist = new File("receptionistAccountList.txt");
		
		for (Accounts account:list) {
			if (account.getPerson().getClass().getSimpleName().equals("Doctor")) {
				if (doctor.exists()) {
					try {
						FileWriter fw = new FileWriter(doctor,true);
							fw.write(account+"\n");
						fw.close();
						System.out.println("doctorAccountList Complete!");
					} catch (Exception e) {
						System.out.println("Something went wrong!");
					}
				} else {
					try {
						PrintWriter pw=new PrintWriter(doctor);
							pw.print(account+"\n");
						pw.close();
						System.out.println("doctorAccountList Complete!");
					}
					catch (Exception e) {
						System.out.println("Something went wrong!");
					}
				}
			}
			else if (account.getPerson().getClass().getSimpleName().equals("Patient")) {
				if (patient.exists()) {
					try {
						FileWriter fw = new FileWriter(patient,true);
							fw.write(account+"\n");
						fw.close();
						System.out.println("patientAccountList Complete!");
					} catch (Exception e) {
						System.out.println("Something went wrong!");
					}
				} else {
					try {
						PrintWriter pw=new PrintWriter(patient);
							pw.print(account+"\n");
						pw.close();
						System.out.println("patientAccountList Complete!");
					}
					catch (Exception e) {
						System.out.println("Something went wrong!");
					}
				}
			}
			else if (account.getPerson().getClass().getSimpleName().equals("Receptionist")) {
				if (receptionist.exists()) {
					try {
						FileWriter fw = new FileWriter(receptionist,true);
							fw.write(account+"\n");
						fw.close();
						System.out.println("receptionistAccountList Complete!");
					} catch (Exception e) {
						System.out.println("Something went wrong!");
					}
				} else {
					try {
						PrintWriter pw=new PrintWriter(receptionist);
							pw.print(account+"\n");
						pw.close();
						System.out.println("receptionistAccountList Complete!");
					}
					catch (Exception e) {
						System.out.println("Something went wrong!");
					}
				}
			}
		}
	}
	private void Menu1() {
		Scanner so=new Scanner(System.in);
		boolean inputCheck=true;
		List <Accounts> acct=new ArrayList<Accounts>();
		System.out.println("Enter 1 for Data Structures\n2-Exit.");
		
		do {
			try {
				switch (so.nextInt()) {
					case 1: dataStructures(so,inputCheck,acct);
						break;
					case 2: exit(so,inputCheck);
						break;
					default: System.out.println("Invalid input. Please enter correct format.");
					Menu1();
						break;
				}
						
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	//Overloaded method to call login method
	private void Menu1(List <Accounts> acct) {
		Scanner so=new Scanner(System.in);
		boolean inputCheck=true;
		System.out.println("Enter 0 to Login\n1-Data Structures\n2-Exit.");

		do {
			try {
				switch (so.nextInt()) {
					case 0: login(so,inputCheck,acct);
						break;
					case 1: dataStructures(so,inputCheck,acct);
						break;
					case 2: exit(so,inputCheck);
						break;
					default: System.out.println("Invalid input. Please enter correct format.");
					Menu1();
						break;
				}
						
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	//Creates a random list of persons with accounts, stores them in 
	//files based on subclass types, then takes the user to the 
	//dataStructuresMenu
	public void dataStructures(Scanner so, boolean inputCheck,List <Accounts> list) {
		inputCheck=true;
		System.out.println("How many random Persons/Accounts do you want to generate?");
		do {
			try {
				List <Accounts> acct=createRandomPersons(so.nextInt());
				storeSetFile(acct);
				dataStructuresMenu(so,inputCheck,acct);
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				//consume empty token in buffer from nextInt().
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	public void dataStructuresMenu (Scanner so, boolean inputCheck,List <Accounts> acct) {
		inputCheck=true;
		System.out.println("3-Vectors & Stacks & Queues(acct)"
				+ "\n4-Sets(acct)\n5-Maps(acct)"
				+ "\n6-Return to Main MenuEJP4\n7-Exit");
		do {
			try {
				switch (so.nextInt()) {
					case 3: 
						vectorStackQueue(so,inputCheck,acct);
						break;
					case 4: 
						sets(so,inputCheck,acct);
						break;
					case 5: 
						maps(so,inputCheck,acct);
						break;
					case 6: 
						Menu1(acct);
						break;
					case 7:
						exit(so,inputCheck);
						break;
					default: System.out.println("Invalid input. Please enter correct format.");
					dataStructuresMenu(so,inputCheck,acct);
						break;
				}	
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				System.out.println(e.getMessage());
				//consume empty token in buffer from nextInt().
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	public void vectorStackQueue(Scanner so,boolean inputCheck,List <Accounts> acct) {
		inputCheck=true;
		Vector<Accounts> vector=new Vector<Accounts>(acct);
		//stack default no arg constructor, use addAll to create stack "list".
		Stack<Accounts> stack=new Stack<Accounts>();
		stack.addAll(acct);
		//acct converted to LinkedList in order to use queue interface.
		Queue<Accounts> queue=new LinkedList<Accounts>(acct);
		System.out.println("8-Vectors (first element)"
				+ "\n9-Vectors (last element)"
				+ "\n10-Stack (peek)"
				+ "\n11-Queues (peek)"
				+ "\n12-Return to Data Structures"
				+ "\n13-Exit");
		do {
			try {
				switch (so.nextInt()) {
					case 8: 
						System.out.println("Accounts in Vector - First Element => " + vector.firstElement());
						vectorStackQueue(so,inputCheck,acct);
						break;
					case 9:
						System.out.println("Accounts in Vector - Last Element => " + vector.lastElement());
						vectorStackQueue(so,inputCheck,acct);
						break;
					case 10: 
						System.out.println("Accounts in Stack  - Element at Top => " + stack.peek());
						vectorStackQueue(so,inputCheck,acct);
						break;
					case 11: 
						System.out.println("Accounts in Queues - First in Line => " + queue.peek());
						vectorStackQueue(so,inputCheck,acct);
						break;
					case 12:
						dataStructuresMenu(so,inputCheck,acct);
						break;
					case 13:
						exit(so,inputCheck);
						break;
					default: System.out.println("Invalid input. Please enter correct format.");
					vectorStackQueue(so,inputCheck,acct);
						break;
				}	
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	//implied purpose is to display different element orderings depending on
	//type of set, not first element. Therefore I will display whole sets for
	//this exercise.
	public void sets (Scanner so, boolean inputCheck, List<Accounts>acct) {
		inputCheck=true;
		//use addAll method to create hashSet from arrayList
		Set<Accounts> hashSet=new HashSet<Accounts>();
		hashSet.addAll(acct);
		//recast hashSet as treeSet, added hashCode and equals override methods
		//to respective classes
		Set<Accounts> treeSet=new TreeSet<Accounts>(hashSet);
		//recast hashSet as linkedHashSet
		Set<Accounts> linkedHashSet=new LinkedHashSet<Accounts>(hashSet);
	
		System.out.println("14-HashSet"
				+ "\n15-TreeSet"
				+ "\n16-LinkedHashSet"
				+ "\n17-Return to Data Structures"
				+ "\n18-Exit");
		do {
			try {
				switch (so.nextInt()) {
					case 14: 
						System.out.println("Accounts in HashSet"+hashSet);
						sets(so,inputCheck,acct);
						break;
					case 15:
						System.out.println("Accounts in TreeSet"+treeSet);
						sets(so,inputCheck,acct);
						break;
					case 16: 
						System.out.println("Accounts in LinkedHashSet"+linkedHashSet);
						sets(so,inputCheck,acct);
						break;
					case 17: 
						dataStructuresMenu (so,inputCheck,acct);
						sets(so,inputCheck,acct);
						break;
					case 18:
						exit(so,inputCheck);
						break;
					default: System.out.println("Invalid input. Please enter correct format.");
					sets(so,inputCheck,acct);
						break;
				}	
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	public void maps (Scanner so, boolean inputCheck, List<Accounts>acct) {
		inputCheck=true;
		//Create an empty hashMap first, then iterate through acct ArrayList
		//with a for each loop to add each key/value pair to the new hashMap. 
		Map<Long,Accounts> hashMap=new HashMap<Long,Accounts>();
		for (Accounts accounts : acct) {
			hashMap.put(accounts.getPerson().getPersonID(), accounts);
		}
		//recast hashMap as treeMap
		Map<Long,Accounts> treeMap=new TreeMap<Long,Accounts>(hashMap);
		//recast hashMap as linkedHashMap
		Map<Long,Accounts> linkedHashMap=new LinkedHashMap<Long,Accounts>(hashMap);
		
		System.out.println("19-HashMap"
				+ "\n20-TreeMap"
				+ "\n21-LinkedMap"
				+ "\n22-Return to Data Structures"
				+ "\n23-Exit Program");
		do {
			try {
				switch (so.nextInt()) {
					case 19: 
						System.out.println("Accounts in HashMap"+hashMap);
						maps(so,inputCheck,acct);
						break;
					case 20:
						System.out.println("Accounts in TreeMap"+treeMap);
						maps(so,inputCheck,acct);
						break;
					case 21: 
						System.out.println("Accounts in LinkedHashMap"+linkedHashMap);
						maps(so,inputCheck,acct);
						break;
					case 22: 
						dataStructuresMenu (so,inputCheck,acct);
						maps(so,inputCheck,acct);
						break;
					case 23:
						exit(so,inputCheck);
						break;
					default: System.out.println("Invalid input. Please enter correct format.");
					maps(so,inputCheck,acct);
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
	
	
	public void exit(Scanner so,boolean inputCheck) {
		inputCheck=true;

		System.out.println("24-Return to Main Menu\n25-Exit Program");
		do {
			try {
				switch (so.nextInt()) {
					case 24: 
						Menu1();
						break;
					case 25:
						exitProgram(so);
						break;
					default: System.out.println("Invalid input. Please enter correct format.");
					exit(so,inputCheck);
						break;
				}	
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	//displays end of program
	private void exitProgram(Scanner so) {
		System.out.println("Program executed and closing.");
		so.close();
		System.exit(0);
	}
	
	//login method
	private void login(Scanner so,boolean inputCheck,List<Accounts>acct) {
		inputCheck=true;
		String user="";
		String pass="";
		System.out.println("Enter username");
		do {
			try {
				user=so.nextLine();
				for (Accounts userName:acct) {
					if (user.equals(userName.getUser()))
						System.out.print("");
					else
						System.out.println("Access Denied: Provided username not found.");
				} 
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
		
		inputCheck=true;
		System.out.println("Enter password");
		do {
			try {
				pass=so.nextLine();
				for (Accounts password:acct) {
					if (pass.equals(password.getPass()))
						System.out.print("");
					else
						System.out.println("Access Denied: Password does not match.");
				}	
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
}