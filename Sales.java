// -------------------------------------------------------------
// Assignment 4
// Written by: Nguyen Le 40272922
// For COMP 248 Section H – Fall 2023
// -------------------------------------------------------------
public class Sales {
	
	//The overall purpose of the program is to manage sales of different meal 
	//categories, allowing for modifications, computations, and comparisons.
	
	
	
	//declare instance variables for prices
	
	// declare constant price 
	private final int JUNIOR_PRICE =5;
	private final int TEEN_PRICE =10;
	private final int MEDIUM_PRICE=12;
	private final int BIG_PRICE=15;
	private final int FAMILY_PRICE=20;
	
	// declare count
	private int juniorCount;
	private int teenCount;
	private int mediumCount;
	private int bigCount;
	private int familyCount;
	
	// default constructor
	
	public Sales(){
		
	}

	
	// constructor with parameters of meals count to get called when the object is 
	// declared 
	public Sales (int juniorCount,int teenCount,int mediumCount,int bigCount ,int familyCount ) {
		this.juniorCount = juniorCount;
		this.teenCount = teenCount;
		this.mediumCount = mediumCount;
		this.bigCount = bigCount;
		this.familyCount = familyCount;
	}
    // copy constructor with one parameters to duplicate the object 
	//The copy constructor is a good addition for creating a new Sales object based on an existing one.
    
    public Sales (Sales amount) {
    	this.juniorCount = amount.getJunior();
        this.teenCount = amount.getTeen();
        this.mediumCount = amount.getMedium();
        this.bigCount = amount.getBig();
        this.familyCount = amount.getFamily();
    }
    
    
	
	// accessor access the value count to returns the value of the data 
	
	public int getJunior () {
		return juniorCount;
	}
	public int getTeen () {
		return teenCount;
	}
	public int getMedium () {
		return mediumCount;
	}
    public int getBig () {
	    return bigCount;
}
    public int getFamily () {
		return familyCount;
	}
    
    // mutator set a value to make sure it stays in the coherent state
    
    public void setJunior(int juniorCount) {
    	this.juniorCount = juniorCount;
    }
    public void setTeen(int teenCount) {
    	this.teenCount = teenCount;
    }
    public void setMedium(int mediumCount) {
    	this.mediumCount = mediumCount;
    }
    public void setBig(int bigCount) {
    	this.bigCount = bigCount;
    }
    public void setFamily(int familyCount) {
    	this.familyCount = familyCount;
    }
    
    // add sales method allow to increase the number of each meall category by the indicated number
    public void addSales (int junior, int big, int teen, int medium, int family) {
    	
		juniorCount += junior ;
		teenCount += teen;
		mediumCount += medium;
		bigCount +=big;
		familyCount += family;
    	
    }
    // return total sales
    public int SalesTotal() {
    	
    	int total = juniorCount*JUNIOR_PRICE+teenCount*TEEN_PRICE+mediumCount*MEDIUM_PRICE+
    			bigCount*BIG_PRICE+familyCount*FAMILY_PRICE;
    	return total;
    }
    // return value of an object and printed 
    //The toString method provides a clear representation of the sales details in a readable format
    public String toString () {
    	return (juniorCount + " x $5 + " + teenCount + " x $10 + " + mediumCount + " x $12 + " + bigCount + " x $15 + " 
				+ familyCount + " x $20"); // printing the count of each meals with the price of each
    	
    	
    	    } // compare object for same meal category
    public boolean equals(Sales obj) {
    	return ((this.juniorCount == obj.getJunior()) //compare of the value and the object accessor
				&& (this.teenCount == obj.getTeen())
				&& (this.mediumCount == obj.getMedium()) 
				&& (this.bigCount == obj.getBig()) 
				&& (this.familyCount == obj.getFamily()));
 	

    }
    	
    
 







	}
