package ftta;

public class Buyer{
	
	private long buyerID;
	private String initials;

	public Buyer(long id, String initialsIn){
		this.buyerID = id;
		this.initials = initialsIn;

	public String getInitials(){
		return initials;
	}

	public long getID(){
		return buyerID;
	}
    
  public void setID(long id){
		buyerID = id;
	}

	public void setInitials(String initialsIn){
		initials = initialsIn;
    
	public String getInitials() {
		return initials;
	}
}