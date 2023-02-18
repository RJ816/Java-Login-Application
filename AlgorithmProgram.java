package com.login;

import java.io.*;
import java.util.*;
import com.accounts.profession.*;

public class AlgorithmProgram {

	public static void main (String [] args) throws Exception {
		List <Accounts> acct=new ArrayList<Accounts>();
		AlgorithmProgram main=new AlgorithmProgram();
		main.startMenu(acct);
	}
	
	//Method used to check tail of a data structure while debugging
	private void reverseRecursivePrintList(List<Accounts> acct){
		for (int i=acct.size()-1;i>=0;i--) {
			System.out.println(acct.get(i));
		}
	}
	
	private void startMenu(List<Accounts> acct) {
		Scanner so=new Scanner(System.in);
		boolean inputCheck=true;
		System.out.println("Start Menu\n1-Algorithm Program\n2-Exit Program.");

		do {
			try {
				switch (so.nextInt()) {
					case 1: listMenu(so,inputCheck,acct);
						break;
					case 2: exitProgram(so);
						break;
					default: System.out.println("Invalid numerical input. Please enter correct format.");
					startMenu(acct);
						break;
				}			
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Not a number. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	private void listMenu(Scanner so,boolean inputCheck,List<Accounts> acct) {
		inputCheck=true;
		System.out.println("List Menu\n1-Generate Members\n2-Back to Start Menu\n3-Exit Program.");

		do {
			try {
				switch (so.nextInt()) {
					case 1: generateMembersMenu(so,inputCheck,acct);
						break;
					case 2: startMenu(acct);
						break;
					case 3: exitProgram(so);
						break;
					default: System.out.println("Invalid numerical input. Please enter correct format.");
					listMenu(so,inputCheck,acct);
						break;
				}
						
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Not a number. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	public List<Accounts> generateMembers(int listSize) {
		DataStructuresProgram main=new DataStructuresProgram();
		List<Accounts> list=main.createRandomPersons(listSize);
		recursivePrintList(list,list.size());
		return list;
	}
	
	private int recursivePrintList(List<Accounts> acct,int listSize) {
		if (listSize<=0)
			return 0;
		else
			for (Accounts account:acct) {
				System.out.println(account);
			}
			return listSize;
	}
	
	//Sorting done by last name, then first name ascending
	private void sortMenu(Scanner so,boolean inputCheck,List<Accounts> acct) {
		inputCheck=true;
		System.out.println("Sort Menu\n1-Bubble Sort\n2-Insertion Sort\n3-Merge Sort\n4-Quick Sort");

		do {
			try {
				switch (so.nextInt()) {
					case 1: bubbleSort(acct,acct.size());
						reverseRecursivePrintList(acct);
						generateMembersMenu(so,inputCheck,acct);
						break;
					case 2: insertionSort(acct,acct.size());
						recursivePrintList(acct,acct.size());
						generateMembersMenu(so,inputCheck,acct);
						break;
					case 3: mergeSort(acct);
						recursivePrintList(acct,acct.size());
						generateMembersMenu(so,inputCheck,acct);
						break;
					case 4: quickSort(acct);
						recursivePrintList(acct,acct.size());
						generateMembersMenu(so,inputCheck,acct);
						break;
					default: System.out.println("Invalid numerical input. Please enter correct format.");
					sortMenu(so,inputCheck,acct);
						break;
				}		
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Not a number. Please enter correct format");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	public void bubbleSort(List<Accounts> acct,int listSize) {
        int i, j;
        Accounts temp;
        boolean swapped;
        for (i = 0; i < listSize - 1; i++)
        {
        	swapped = false;
            for (j = 0; j < listSize - i - 1; j++) {
            	if (acct.get(j).compareTo(acct.get(j+1))>0) {
            		// swap acct.get(j) and acct.get(j+1)
                    temp = acct.get(j);
                    acct.set(j,acct.get(j+1));
                    acct.set(j+1,temp);
                    swapped = true;
                }
            }
 
            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
	
	public void insertionSort (List<Accounts> acct,int listSize){
		for (int i = 1; i < listSize; ++i) {
			Accounts key = acct.get(i);
	            int j = i - 1;
	            /* Move elements of acct[0..i-1], that are
	               greater than key, to one position ahead
	               of their current position */
	            while (j >= 0 && acct.get(j).compareTo(key)>0) {
	            	acct.set(j+1,acct.get(j));
	                j = j - 1;
	            }
	            acct.set(j+1,key);
	    }
	}
	
	public void mergeSort(List<Accounts> acct) {
	    if (acct.size() > 1) {
	    	// Merge sort the first half
	    	List<Accounts>firstHalf = new ArrayList<Accounts>(acct.size()/2);
	    	for (int i=0;i<acct.size()/2;i++)
	    		firstHalf.add(acct.get(i));
	    	mergeSort(firstHalf);
	    	// Merge sort the second half
	    	int secondHalfLength = acct.size() - acct.size() / 2;
	    	List<Accounts>secondHalf = new ArrayList<Accounts>(secondHalfLength);
	    	for (int j=acct.size()-secondHalfLength;j<acct.size();j++)
	    		secondHalf.add(acct.get(j)); 
	    	mergeSort(secondHalf);
	    	// Merge firstHalf with secondHalf into list
	    	merge(firstHalf, secondHalf, acct);
	    }
	}
	// Merge two sorted lists for mergeSort method
	private void merge(List<Accounts> list1, List<Accounts> list2,List<Accounts> temp) {
	    int current1 = 0; // Current index in list1
	    int current2 = 0; // Current index in list2
	    int current3 = 0; // Current index in temp

	    while (current1 < list1.size() && current2 < list2.size()) {
	      if (list1.get(current1).compareTo(list2.get(current2))<0)
	        temp.set(current3++, list1.get(current1++));
	      else
	    	temp.set(current3++, list2.get(current2++));
	    }
	    while (current1 < list1.size())
	    	temp.set(current3++, list1.get(current1++));
	    while (current2 < list2.size())
	    	temp.set(current3++, list2.get(current2++));
	  }
	
	public void quickSort(List<Accounts> acct) {
	    quickSort(acct,0,acct.size() - 1);
	  }
	private void quickSort(List<Accounts> acct, int first, int last) {
	    if (last > first) {
	      int pivotIndex = partition(acct, first, last);
	      quickSort(acct, first, pivotIndex - 1);
	      quickSort(acct, pivotIndex + 1, last);
	    }
	  }
	  //Partition the array list[first..last]
	private int partition(List<Accounts> acct, int first, int last) {
	    Accounts pivot = acct.get(first); // Choose the first element as the pivot
	    int low = first + 1; // Index for forward search
	    int high = last; // Index for backward search

	    while (high > low) {
	      // Search forward from left
	      while (low <= high && acct.get(low).compareTo(pivot) <= 0)
	        low++;

	      // Search backward from right
	      while (low <= high && acct.get(high).compareTo(pivot) > 0)
	        high--;

	      // Swap two elements in the list
	      if (high > low) {
	        Accounts temp = acct.get(high);
	        acct.set(high,acct.get(low));
	        acct.set(low,temp);
	      }
	    }
	    while (high > first && acct.get(high).compareTo(pivot) >= 0)
	      high--;
	    // Swap pivot with list[high]
	    if (pivot.compareTo(acct.get(high)) > 0) {
	      acct.set(first,acct.get(high));
	      acct.set(high,pivot);
	      return high;
	    }
	    else {
	      return first;
	    }
	}
	
	private void generateMembersMenu(Scanner so,boolean inputCheck,List<Accounts> acct) {
		inputCheck=true;
		System.out.println("Generate Members\n1-Generate x Members\n"
				+ "2-Sorting Algorithms from Generate Members\n"
				+ "3-Searching Algorithms from Sorting Algorithms\n"
				+ "4-Sort Race Program\n"
				+ "5-Exit Program");

		do {
			try {
				switch (so.nextInt()) {
					case 1: int x=5000;
							acct=generateMembers(x);
							System.out.print("5000 members generated in a list.\n");
							generateMembersMenu(so,inputCheck,acct);
						break;
					case 2: if (acct.size()<=0) {
								System.out.println("No list, generate list first.");
								generateMembersMenu(so,inputCheck,acct);
							}else sortMenu(so,inputCheck,acct);
						break;
					case 3: if (acct.get(0).compareTo(acct.get(acct.size()-1))>0) {
								System.out.println("List not sorted, select sorting algorithm first.");
								generateMembersMenu(so,inputCheck,acct);
							}else searchMenu(so,inputCheck,acct);
					case 4: sortRaceProgram(so,inputCheck,acct);
						break;
					case 5: exitProgram(so);
						break;
					default: System.out.println("Invalid numerical input. Please enter correct format.");
					generateMembersMenu(so,inputCheck,acct);
						break;
				}
						
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Not a number. Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
	}
	
	private void searchMenu(Scanner so,boolean inputCheck,List<Accounts> acct) {
		inputCheck=true;
		System.out.println("What user ID are you searching for?");
		long id=so.nextLong();
		do {
			try {
				if (id<1572201110 || id>1572209990) {
				System.out.println("Invalid input. Please enter "
						+ "an ID number between 1572201110 and 1572209990,");
				System.out.println("What user ID are you searching for?");
				id=so.nextLong();
				so.nextLine();
				}
				else inputCheck=false;
			} catch (Exception e) {
				System.out.println("Please enter correct format.");
				so.nextLine();
			}
		} while (inputCheck);
		
		if (linearSearch(acct,id)==-1)
			System.out.println("User ID not in list.");
		else 
			System.out.print("User Data:\n");
			Accounts result=acct.get(linearSearch(acct,id));
			String[] person=result.toString().split("_");
			for (String s:person)
				System.out.println(s+"\n");
		
		generateMembersMenu(so,inputCheck,acct);
	}
	
	 public int linearSearch(List<Accounts> acct, long keyID) {
		 for (int i = 0; i < acct.size(); i++) {
			 if (keyID == acct.get(i).getPerson().getPersonID())
		        return i;
		 }
		    return -1;
	 }

	private void sortRaceProgram(Scanner so,boolean inputCheck,List<Accounts> acct) {
		inputCheck=true;
		System.out.println("Enter number of persons to generate in list:");
		do {
			try {
				acct=generateMembers(so.nextInt());
				inputCheck=false;
			} catch (Exception e) {
				System.out.println("Not a number. Please enter correct format.");
				so.nextLine();
			} 
		} while (inputCheck);
		
		List<Accounts> acct1=new ArrayList<Accounts>(acct);
		long start=System.currentTimeMillis();
		bubbleSort(acct1,acct1.size());
		long end=System.currentTimeMillis();
		long time1=end-start;
		System.out.println("Bubble sort="+time1);
		String line=String.format("Bubble sort="+time1);
		strFile(line);
		end=0;
		start=0;
		
		List<Accounts> acct2=new ArrayList<Accounts>(acct);
		start=System.currentTimeMillis();
		insertionSort(acct2,acct2.size());
		end=System.currentTimeMillis();
		long time2=end-start;
		System.out.println("Insertion sort="+time2);
		line=String.format("Insertion sort="+time1);
		strFile(line);
		end=0;
		start=0;
		
		List<Accounts> acct3=new ArrayList<Accounts>(acct);
		start=System.currentTimeMillis();
		mergeSort(acct3);
		end=System.currentTimeMillis();
		long time3=end-start;
		System.out.println("Merge sort="+time3);
		line=String.format("Merge sort="+time1);
		strFile(line);
		end=0;
		start=0;
		
		List<Accounts> acct4=new ArrayList<Accounts>(acct);
		start=System.currentTimeMillis();
		quickSort(acct4);
		end=System.currentTimeMillis();
		long time4=end-start;
		System.out.println("Quick sort="+time4);
		line=String.format("Quick sort="+time1);
		strFile(line);
		
		TreeMap<Long, String> t=new TreeMap<Long, String>();
		t.put(time1,"bubble sort");
		t.put(time2, "insertion sort");
		t.put(time3, "merge sort");
		t.put(time4, "quick sort");
		System.out.println("The fastest algorithm is "+t.values().toArray()[0].toString());
		line=String.format("The fastest algorithm is "+t.values().toArray()[0].toString());
		strFile(line);
		generateMembersMenu(so,inputCheck,acct);
	}
	
	public void strFile (String line) {
		File f=new File("porgramData");
		try {
			FileWriter fw=new FileWriter(f,true);
			PrintWriter pw=new PrintWriter(fw);
			pw.println(line);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//displays end of program
	private void exitProgram(Scanner so) {
		System.out.println("Program executed and closing.");
		so.close();
		System.exit(0);
	}

}
