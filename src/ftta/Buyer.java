package ftta;

public class Buyer{
	
	private long buyerID;
	private String initials;
	private String firstName;
	private String lastName;

	public Buyer(long id, String initials, String firstName, String lastName){
		this.buyerID = id;
		this.initials = initials;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getName(){
		return firstName + " " + lastName;
	}

	public long getID(){
		return buyerID;
	}

	public String getInitials() {
		return initials;
	}
	
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public void setName(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setID(long id){
		buyerID = id;
	}
}