package ftta;

public class Buyer{
	
	private long buyerID;
	private String firstName;
	private String lastName;

	public Buyer(long id, String firstName, String lastName){
		this.buyerID = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getName(){
		return firstName + " " + lastName;
	}

	public long getID(){
		return buyerID;
	}

	public void setName(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setID(long id){
		buyerID = id;
	}
}