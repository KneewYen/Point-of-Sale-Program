
public class PrePaiCard {

	// instance variables
	// represent attributes of the prepaidcard
	

	private int day ;
	
	private int month ;
	
	private String Cardtype;
	private int cardID;


	
	// default constructor
	
	public PrePaiCard() {
		
	}
	// constructor with parameters 
	public PrePaiCard(String Cardtype, int cardID, int day, int month) {
		this.Cardtype = Cardtype; 
		this.cardID = cardID;
		
		// condition if if day is not between 1-31 reset the value to 0
		if ((1 > day) ||(day>31)) 
			this.day=0; //set to 0
		else 
			this.day=day; // set to this new variable
		// condition if is not between 1 to 12
		if ((1>month) || (12<month))
			this.month=0; // set to 0
		else
			this.month = month;// set to this new variable 
		
		
	}
	
// copy constructor with one parameters to duplicate the object
	
	//Creates a new PrePaiCard object by copying values from another object
    
    public PrePaiCard (PrePaiCard other) {
    	this.day = other.getDay();
    	this.month = other.getMonth();
    	this.Cardtype = other.getCardtype();
    	this.cardID =other.getCardID();
    	
    }
    
    // accessor access the value , with a combination with mutator they rechievd values
    public int getDay () {
		return day;
	}
	public int getMonth () {
		return month;
	}
	public String getCardtype () {
		return Cardtype;
	}
    public int getCardID () {
	    return cardID;
    }
    
    //mutator set the new value 
    
    public void setDueDay(int dueDate) {
    	
    	this.day= dueDate;    	
    	
        }
    	// set month
    public void setDueMonth(int dueMonth) {
        
            this.month = dueMonth;
    }
    
    // return the formatted date and month 
    public String toString () {
    	//card.toString()
    	String formattedDueDay;
    	if (day<10) {  // if the day is smaller than 10 it will add 0 as a string
    		formattedDueDay="0"+day;
    		
    		}
    	
    	else
    		formattedDueDay = String.valueOf(day);
    	
    	String formattedDueMonth; // add 0 if under 10 
    	if (month<10)
    		formattedDueMonth="0"+month;
    	else
    		formattedDueMonth = String.valueOf(month);
    		
    	
 // return formatted string
    	return (Cardtype + " - " + cardID + " - " + formattedDueDay + "/" + formattedDueMonth);
    
    	
    }
    // return true if two objects of type are in other 
    public boolean equals(PrePaiCard otherCard) {
		return ((this.day == otherCard.getDay()) && (this.month == otherCard.getMonth()) 
				&& (this.Cardtype == otherCard.getCardtype()) && (this.cardID == otherCard.getCardID()));
	}
    

	
	
}

