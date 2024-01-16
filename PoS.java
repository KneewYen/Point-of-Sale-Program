// -------------------------------------------------------------
// Assignment 4
// Written by: Nguyen Le 40272922
// For COMP 248 Section H – Fall 2023
// -------------------------------------------------------------
public class PoS {
	//The PoS class manages sales and prepaid card information.
	//It provides methods to compare sales, manage prepaid cards, and update sales data.
	//The PrePaiCard class encapsulates the properties and behaviors of a prepaid card.
	//Access modifiers such as private are used to encapsulate and control access to instance variables.
	
	//public 
	
	
//private variables enhance the security of the code by controlling access to sensitive data. 
	//it prevents unintended 
	//modification of data by external classes or code
	private Sales sales; //represent sales information
	private PrePaiCard[] cardList; //represent an array of card in the PoS
	
	// default constructor 
	public PoS() {
		
	}
	
	//constructor with 2 parameters (avoid risk of any privacy leaks)
	public PoS(Sales sales, PrePaiCard[] cardList) {
		this.sales = sales;
		if (cardList != null) { //prevent privacy leaks by creating a new copy of the prepaid card
			this.cardList = new PrePaiCard[cardList.length];
			
			for (int i = 0; i< cardList.length; i++) {
				this.cardList[i] = new PrePaiCard(cardList[i]); // prevent privacy leaks
			}
		}
		else {
			this.cardList = null;
		}
		
	}
	
	//no copy constructor
	
	// return the total of sales 
	public boolean totalSalesEquals(PoS posToCompare) { 
		return (this.sales.SalesTotal() == posToCompare.sales.SalesTotal());
	}
	
	// category sales are equal 
	public boolean categorySalesEqual(PoS posToCompare) {
		return (this.sales.getJunior() == posToCompare.sales.getJunior()
				&& this.sales.getTeen() == posToCompare.sales.getTeen()
				&& this.sales.getMedium() == posToCompare.sales.getMedium()
				&& this.sales.getBig() == posToCompare.sales.getBig()
				&& this.sales.getFamily() == posToCompare.sales.getFamily());
	}
	
	//return the total $ sales of a PoS.
	public int posSales() {
		return this.sales.SalesTotal();
	}
	
	// return the number of prepaid cards in a PoS.
	public int posPrepaidCards() {
		int listLength;
		if (this.cardList == null) {
			listLength = 0;
		}
		else 
			listLength = this.cardList.length;
		return listLength; 
	}
	// add card into the array list
	public int addCard(PrePaiCard card) { //parameters 
		if (cardList != null) {
			PrePaiCard[] tempValue = new PrePaiCard[this.cardList.length]; //create a tempory value for the card
			for (int x = 0; x < this.cardList.length; x++) {  // copy existing card to a tempory array
				tempValue[x] = new PrePaiCard(cardList[x]);
			}
			int newSize = this.cardList.length + 1; // when card is added it adds the list length in the array
			this.cardList = new PrePaiCard[newSize]; //insert into the array list
			for (int j = 0; j < newSize - 1; j++) { //update listed array copied back of the card
				this.cardList[j] = new PrePaiCard(tempValue[j]);
			}
			this.cardList[newSize - 1]= new PrePaiCard(card); //added to the last position of the array
		}
		else { //if its null the list , array of size 1
			this.cardList = new PrePaiCard[1];
			this.cardList[0] = new PrePaiCard(card);
		}
		return this.cardList.length; //return the length of the list length
	
	}
	// remove card from pOs 
	public void removeCard(int cardIndex) {
		
		// check if its not null
		if (this.cardList != null) {
			if (this.cardList.length == 1) { //list null if theres one card 
				this.cardList = null;
			}
			else {
				PrePaiCard[] tempCardList = new PrePaiCard[this.cardList.length]; //tempory array to store card
				for (int n = 0; n < this.cardList.length; n++) {  //existing cards go into tempory array 
					tempCardList[n] = new PrePaiCard(cardList[n]); 
				}
				int newSize = this.cardList.length - 1; //size of the list after removing the card
				this.cardList = new PrePaiCard[newSize];// Create a new array with the updated size to accommodate the removed card
				for (int k = 0; k < cardIndex; k++) { //cop back the cards to the array
					this.cardList[k] = new PrePaiCard(tempCardList[k]);
				}
				for (int l = cardIndex + 1; l <= newSize; l++) { //continue copying after the removal process 
					this.cardList[l - 1] = new PrePaiCard(tempCardList[l]);
				}
			}
			System.out.println("PrePaiCard was removed successfully\n");//display message 
		}
	} // method will update the expiry day and month of a prepaid card
	public void updateExpiryDate(int position,int newDueDay, int newDueMonth) {
		
		cardList[position].setDueDay(newDueDay); // Set the new due day for the prepaid card at the specified position
		cardList[position].setDueMonth(newDueMonth); // Set the new due month for the prepaid card at the specified position
		
	}
	
	//This method allows for the addition of sales data for different meal categories (junior, teen, medium, big, family) 
	//and returns the updated total sales after making these additions. 
	//The Sales object is responsible for managing and calculating the total sales based on the sales data provided 
	//for each category.
	public int addMeals(int addJunior, int addTeen, int addMedium, int addBig, int addFamily) {
		this.sales.addSales(addJunior, addTeen, addMedium, addBig, addFamily);
		return this.sales.SalesTotal();
	}
	//comparison between two PoS objects, checking both the total sales and sales in each category
	public boolean equals(PoS otherPos) {
		return (this.totalSalesEquals(otherPos) && this.categorySalesEqual(otherPos));
	}
	
	//to see content of one PoS
	public String toString() { //Converts the PoS object to a string representation, including sales details and prepaid cards.
		String cardList_ = this.sales.toString(); //initialization
		if (this.cardList != null) { //check if not null
			for (int m = 0; m < this.cardList.length;m++) { //goes through the list and print content
				cardList_ += this.cardList[m].toString() + "\n";
			}
		}
		else // if null appear message no prepaid
			cardList_ += "\nNo PrePaiCards\n";
		return cardList_;
	}
	//Gets a string representation of the sales breakdown in the PoS.
	public String salesBreakdown() {
		return (sales.toString()); //return object to get sales breakdown
	}
	
	
}
	
	
