// -------------------------------------------------------------
// Assignment 4
// Written by: Nguyen Le 40272922
// For COMP 248 Section H – Fall 2023
// -------------------------------------------------------------
import java.util.Scanner;
public class PoSDemo {
	static Scanner in = new Scanner (System.in);
	
	public static void display() { // create method for display	
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	public static void message() { //methods for welcome display
		System.out.println("Welcome to Concordia CostLessBites Catering Sales Counter Application ");
	}
	
	public static void choices() { // methode for options presentations
		System.out.println("| What would you like to do?                                                  |\n"
				+ "| 1 >> See the content of all PoSs                                            |\n"
				+ "| 2 >> See the content of one PoS                                             |\n"
				+ "| 3 >> List PoSs with same $ amount of sales                                  |\n"
				+ "| 4 >> List PoSs with same number of Sales categories                         |\n"
				+ "| 5 >> List PoSs with same $ amount of Sales and same number of prepaid cards |\n"
				+ "| 6 >> Add a PrePaiCard to an existing PoS                                    |\n"
				+ "| 7 >> Remove an existing prepaid card from a PoS                             |\n"
				+ "| 8 >> Update the expiry date of an existing Prepaid card                     |\n"
				+ "| 9 >> Add Sales to a PoS                                                     |\n"
				+ "| 0 >> To quit                                                                |");
		display();
		System.out.println("");
				
		System.out.print("Please enter your choice and press <Enter>:");
		
		
	}
	//static to have access in the main because static can only access with static variables 
	static Sales sales_1 = new Sales(2,1,0,4,1);
	static Sales sales_2 = new Sales(0,1,5,2,0);
	static Sales sales_3 = new Sales(3,2,4,1,2);
	
	
	// card list distributions , calling object card from class PrePaiCard, hardcoding
	static PrePaiCard cardlist_1[] = {new PrePaiCard ("\nVegetarian", 40825164, 25, 12), new PrePaiCard("Carnivore", 21703195, 3,12)};
	static PrePaiCard cardlist_2[] = {new PrePaiCard("\nVigan", 40825164, 7, 12), new PrePaiCard("Vegetarian", 21596387, 24, 8)};
	
	static PrePaiCard cardlist_3[] = {new PrePaiCard("\nPescatarian", 95432806, 1,16), new PrePaiCard("Halal", 42087913,18,12), new PrePaiCard("Kosher", 40735421,5,4)};
	static PrePaiCard cardlist_4[] = null;

	// same categories in sales and same number 
	// calling object in class PoS using parameters from hardcode of the following attributes
	static PoS pos0 = new PoS(sales_1, cardlist_1);
	static PoS pos1 = new PoS(sales_1, cardlist_2);
	
	// same total $ amount of sales of another PoS 
	static PoS pos2 = new PoS (sales_2, cardlist_3);
	
	// The same breakdown of sales but different from the other 3 and both
	//have no prepaid cards.
	
	static PoS pos3 = new PoS(sales_3, cardlist_4);
	static PoS pos4 = new PoS (sales_3, cardlist_4);
	
	static PoS [] posList = {pos0, pos1, pos2, pos3, pos4};
	
	

	// method printing the pos 
	public static void one () {
		System.out.println("Content of each PoS:\n"
				+ "---------------------");
		// loop for going through the list length to display the pos from 0-4
		for (int index = 0; index < posList.length; index++) {
			System.out.println("PoS #"+index+":\n" + posList[index].toString());
		}               	
	}
	
	
	//Ask the user which PoS they wish to see the content of and display the categories of the
		//sales and the prepaid card(s) info for that PoS. 
	
	public static void two () { // choice 2 of user 
		
		    System.out.print("Which PoS do you want to see the content of? (Enter number 0 to 4): ");
		    int objectPoS = in.nextInt(); // choose the one they want to see
		    int index = objectPoS; // becomes the index of the list 
		    
// condition looking for the user input between 1 to 4 to re ask question
		    if (objectPoS < 0 || objectPoS > 4) {
		        System.out.println("Sorry, but there is no PoS number " + index);
		        System.out.print("--> Try again: (Enter number 0 to 4): ");
		        objectPoS = in.nextInt();
		        index = objectPoS; //equality of index to the user input to display the content of 
		        //the object in the list of array
		        System.out.println(posList[index].toString()); 
		    } else {
		        System.out.println(posList[index].toString());//else statement 
		    
		   
		}
		}
	
//choice 3, pairs of PoS instances sharing the same total sales amount are identified and displayed, avoiding repetitive pairs (e.g., if pair 1 and 4 are displayed, pair 4 and 1 is omitted). 
	//choice 4, PoS pairs with identical sales distribution patterns are presented. Again, redundant pairs are avoided in the display. 
	//choice 5, pairs of PoS objects are listed based on their equality as defined in the PoS class, with redundant displays being mitigated. 
	public static void three (int choice) {
		
		// Check the value of the choice parameter to determine the type of comparison
		if (choice == 3) 
    		System.out.println("List of PoSs with same total $ Sales:\n"); 
		if (choice == 4)
    		System.out.println("List of PoSs with same Sales categories:\n");
		if (choice == 5)
    		System.out.println("List of PoSs with same $ amount of sales and same number of PrePaiCards:\n");
		// go through all list pos object
		for (int i = 0; i < posList.length; i++) {
			for (int j = i+1; j < posList.length; j++) { //perform the pos comparison of different types requested
				if (choice == 3 && posList[i].totalSalesEquals(posList[j])) {
					System.out.println("\tPoSs " + i + " and " + j + " both have " + posList[i].posSales());
				}
				if (choice == 4 && posList[i].equals(posList[j])) {
					System.out.println("\tPoSs " + i + " and " + j + " both have " + posList[i].salesBreakdown());
				}
				if (choice == 5 && posList[i].equals(posList[j]) && (posList[i].posPrepaidCards() == posList[j].posPrepaidCards())) {
					System.out.println("\tPoSs " + i + " and " + j);
				}
			}
		}
		System.out.println(); //formatting
	}
	
	public static void six () { // Ask the user which PoS they want to add a prepaid card to, as well as the prepaid card
		//information, create the new prepaid card and add it to the PoS in question. 

		System.out.print("Which PoS to you want to add an PrePaiCard to? (Enter number 0 to 4): ");
		int posAdd = in.nextInt();  //the user enter pos 0 to 4
		System.out.println(" --> Type of PrePaiCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vigan): ");
		String type = in.next(); //type of card
		in.nextLine();
		// infos and attributes of objects
		System.out.print(" --> Id of the prepaid card owner: ");
		int cardId = in.nextInt(); // id number
		in.nextLine();
		System.out.print(" --> Expiry day number and month (seperate by a space): ");
		int day = in.nextInt(); // day input
		int month = in.nextInt(); // month input
		in.nextLine();//attributes added to object and object added to a list at position asked
		posList[posAdd].addCard(new PrePaiCard(type, cardId, day, month));
		System.out.println("You now have " + posList[posAdd].posPrepaidCards() + " PrePaiCard(s)\n");
		
		
	}
	
	public static void seven() { //Ask the user which PoS they want to remove a prepaid card from, as well as the prepaid
		//card index, they want removed, and remove it from the PoS.
		
		System.out.print("Which PoS to you want to remove an PrePaiCard to? (Enter number 0 to 4): ");
		int removeCardlist = in.nextInt(); //user input pos they want to be removed 
		if (posList[removeCardlist].posPrepaidCards() == 0) { // if theres no prepaid
			System.out.println("Sorry that PoS has no PrePaicards");
		}
		else {
			System.out.println("(Enter number 0 to " + (posList[removeCardlist].posPrepaidCards() - 1) + "):"); 
			int cardIndex = in.nextInt();//paramaters of the class 
			in.nextLine();
			while (cardIndex < 0 || cardIndex > (posList[removeCardlist].posPrepaidCards() - 1)) { //prompting the user to re enter
    			System.out.println("Sorry but there is no card " + cardIndex);
    			System.out.println("--> Try again: (Enter number 0 to " + (posList[removeCardlist].posPrepaidCards() - 1) + "):");
    			 removeCardlist= in.nextInt(); //re inputs
    			in.nextLine(); //junk 
    		}
			posList[removeCardlist].removeCard(cardIndex);}// remove object from the list using class Pos method removeCard
		
	}
	
	public static void eight() { //Ask the user which prepaid card from which PoS they want to update. Ask the user for
		//the new expiry date and update the prepaid card. 
		System.out.print("Which PoS do you want to update an PrePaiCard from? (Enter number 0 to 4): ");
		int choice = in.nextInt(); // user input their choice of pos
		if (posList[choice].posPrepaidCards() == 0) { // conditions if list ==0
			System.out.println("Sorry that PoS has no PrePaicards");
		}
		else { //if not 
			System.out.println("Which PrePaiCard do you want to update? (Enter number 0 to " + (posList[choice].posPrepaidCards() - 1) + "):");
			int position = in.nextInt(); // user input the card position in the list 
			in.nextLine();
			in.nextLine();
    		
			System.out.print(" --> Enter new expiry date day number and month (seperate by a space): ");
			int newDueDay = in.nextInt(); // user input new date 
			int newDueMonth = in.nextInt(); // user input new month
			posList[choice].updateExpiryDate(position,newDueDay, newDueMonth); //the attributes updated with method in class Pos
			System.out.println("Expiry Date updated."); 
	    }
		    }
	// Ask the user which PoS’s sales they want to add to and the number of each category sales
	//they want to add. Then add these sales categories to the sales in the PoS
	public static void nine () {
		System.out.print("Which PoS do you want to add Sales to? (Enter number 0 to 4): ");
		int addSales =in.nextInt(); // users choice becomes than index of the list
		System.out.print("How many junior, teen ,medium,big and family meal menu do you want to add?\n"
				+ "Enter 5 numbers seperated by a space): "); // attributes, to an object , to an array
		posList[addSales].addMeals(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()); // user input what they want to add in order of the parameters in constructor
		System.out.println("You now have $" + posList[addSales].posSales()); //Display content
	}
		

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//variable true 
		boolean stay = true;
		
		display();
		
		message();
		
		display();
		
		while (stay) { // while loop until user enters 0 return false 
		     choices();
		     int option = input.nextInt();
		     // if else statements attributing , accessed to the following methods
		     
		    
		     if (option==1)
		    	 one();
		     else if (option ==2)
		    	 two();
		     else if (option ==3)
		    	 three(option);
		     else if (option ==4)
		    	 three(option);
		     else if (option ==5)
		    	 three(option);
		     else if (option ==6)
		    	 six();
		     else if (option ==7)
		    	 seven();
		     else if (option ==8)
		    	 eight();
		     else if (option ==9)
		    	 nine();
		     else if (option ==0) {
		    	System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
		    	stay = false;
		    	
		     }
		     else {
		    	 System.out.println("Sorry that is not a valid choice. Try again.");
		     
		     }
		    
		     
		}
		
		input.close();
		
	}
	
	
}
	

