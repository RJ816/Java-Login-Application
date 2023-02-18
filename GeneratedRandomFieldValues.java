package com.login;
import java.util.Random;
import com.accounts.profession.*;

//class used to generate random accounts/profession objects to test the java program
public class GeneratedRandomFieldValues {

	static int rnum;

	private static void ranNum(int length) {
		int hi = length;
		int lo = 0;
		int range = hi - lo;
		double rand = new Random().nextDouble();
		rnum = 0;
		rnum = (int) (rand * range + lo);
	}

	// RANDOM INT NUMBER
	public static int ranNum2(int lo, int hi) {
		int range = hi - lo;
		double rand = new Random().nextDouble();
		return (int) (rand * range + lo);
	}

	// RandomValue for field - ID NUMBER
	public static int randomID() {
		final int hi = 1572209990;
		final int lo = 1572201110;
		int range = hi - lo;
		double rand = new Random().nextDouble();
		return (int) (rand * range + lo);
	}

	// RandomValue for field - FIRSTNAME
	public static String randomFirstName() {
		String[] names = { "Bob", "Erica", "Porsha", "Josh", "Sara", "Nelly", "Dave", "Jessie", "Reba", "Sue", "Lizzy",
				"Billy", "Thony", "Rick", "Bill", "Jason", "Diane", "Zendaya", "Sierra", "Alicia", "Kathy" };
		rnum = 0;
		ranNum(names.length);
		return names[rnum];
	}

	// RandomValue for field - LASTNAME
	public static String randomLastName() {
		String[] names = { "Williams", "Marcias", "Morales", "Johnson", "Smith", "Tate", "Barron", "Chen", "Shah",
				"Cha", "Nguyen", "Marco", "Pham", "Terry", "Crosby", "Jackson", "Moss", "Wall", "Rogers", "Brady",
				"Boston", };
		rnum = 0;
		ranNum(names.length);
		return names[rnum];
	}

	// RandomValue for field - DATE OF BIRTH/APPOINTMENT
	public static String randomDate() {
		String date = "";

		// 01-12
		int month = ranNum2(1, 12);
		// 01-30
		int day = ranNum2(1, 30);
		// 1960-2004
		int year = ranNum2(1960, 2004);

		if (month < 10) {
			date = "0" + month + "/";
		} else {
			date = month + "/";
		}
		if (day < 10) {
			date += "0" + day + "/";
		} else {
			date += day + "/";
		}
		date += year;
		return date;
	}

	// RandomValue for field - LOCAL
	public static String randomLocal() {
		String[] names = { "Houston", "Austin", "Chicago", "Los Angeles", "San Diego", "Denver", "New York City",
				"Atlanta", "Miami", "Dallas", "St. Louis", "San Antonio", "Philly", "Seattle", "Boston", "New Orleans",
				"Minneapolis", "Washington D.C.", "Charlotte", "Lake Charles", "San Franscico" };
		rnum = 0;
		ranNum(names.length);
		return names[rnum];
	}

	// RandomValue for field - PRESCRIPTION
	public static String randomPrescription() {
		String[] prescription = { "methotrexate", "vancomycin", "tobramycin", "amikacin", "calprotectin", 		"lamotrigine", "leveteriacetam", "mycophenolic acid", "zonisomide", "oxcarbazepine", "phynetoin",
		"testosterone", "phenobarbitol", "beta hydroxybutyrate", "gentamycin", "valproic acid", "procalcitonin", 
		"troponin", "parathyroid harmone", "VB12", "vitamin hydroxid" };
		rnum = 0;
		ranNum(prescription.length);
		return prescription[rnum];
	}

	// RandomValue for field - SYMPTOM
	public static String randomSymptom() {
		String[] symptom = { "abdominal pain", "broken bone", "cough", "headache", "knee pain", 		"lamotrigine", "leveteriacetam", "mycophenolic acid", "zonisomide", "oxcarbazepine", "phynetoin",
		"chest pain", "stool blood", "constipation", "diarrhea", "difficulty swallowing", "dizziness", 
		"eye disconfort", "fever", "ear pain", "back pain" };
		rnum = 0;
		ranNum(symptom.length);
		return symptom[rnum];
	}
	
	//method to generate a random password. 66 chars:(66!)=a lot of password combinations.
	public static String randomPassword (int length) {
			String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
	          +"jklmnopqrstuvwxyz!@#$%&";
			Random randomNumber = new Random();
			StringBuilder sb = new StringBuilder(length);
			for (int i = 0; i < length; i++)
				sb.append(chars.charAt(randomNumber.nextInt(chars.length())));
			return sb.toString();
	}
	
	/** Method to generate a random Person subclass,fill the class fields
	 * with random values, and create an account for that person with their
	 * Person class generated email and a random number for the password.
	 * @return account with user name (email) and password.
	 */
	public static Accounts randomPerson() {
		int role=ranNum2(1,4);
		Accounts account=null;
		
		switch (role) {
		case 1: 
			Person doctor=new Doctor(randomID(),randomFirstName(),randomLastName()
					,randomDate(),randomLocal(),randomDate(), randomPrescription());
			account=new Accounts(doctor.getEmail(),randomPassword(8),doctor);
			break;
		case 2:
			Person patient=new Patient(randomID(),randomFirstName(),randomLastName()
					,randomDate(),randomLocal(),ranNum2(0,10000), randomSymptom());
			account=new Accounts(patient.getEmail(),randomPassword(8),patient);
			break;
		case 3:
			Person receptionist=new Receptionist(randomID(),randomFirstName(),randomLastName()
					,randomDate(),randomLocal(),String.valueOf(ranNum2(0,1000)));
			account=new Accounts(receptionist.getEmail(),randomPassword(8),receptionist);
			break;
		default:
			System.out.println("Error, Program exiting.");
			System.exit(0);
			break;
		}
		return account;
	}
}
