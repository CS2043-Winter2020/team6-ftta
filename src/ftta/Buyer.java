package ftta;

public class Buyer{
	
	private String initials;
	private double transactionTotal;

	public Buyer(String initialsIn){
		this.initials = initialsIn;
		transactionTotal = 0;
	}

	public void setInitials(String initialsIn){
		initials = initialsIn;
	}
    
	public String getInitials() {
		return initials;
	}
	
	public void addToTransactionTotal(double amount) {
		transactionTotal += amount;
	}
	
	public double getTransactionTotal() {
		return transactionTotal;
	}
}