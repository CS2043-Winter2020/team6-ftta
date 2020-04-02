package ftta;

public class Buyer{
	
	private String initials;

	public Buyer(String initialsIn){
		this.initials = initialsIn;
	}

	public void setInitials(String initialsIn){
		initials = initialsIn;
	}
    
	public String getInitials() {
		return initials;
	}
}