package ftta;

public class Buyer{
	
	private static long buyerID = 0;
	private String initials;

	public Buyer(String initialsIn){
		this.buyerID = buyerID++;
		this.initials = initialsIn;
	}

	public long getID(){
		return buyerID;
	}
    
	public void setID(long id){
		buyerID = id;
	}

	public void setInitials(String initialsIn){
		initials = initialsIn;
	}
    
	public String getInitials() {
		return initials;
	}
}