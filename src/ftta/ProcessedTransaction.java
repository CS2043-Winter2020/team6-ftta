package ftta;

public class ProcessedTransaction extends Transaction{
	private String buyer;
	private String tag;
	
	public ProcessedTransaction(String date, String description, double d, double e, String buyerIn, String tagIn) {
		super(date, description, d, e);
		buyer = buyerIn;
		tag = tagIn;
	}
	
	public void setBuyer(String buyerIn) {
		buyer = buyerIn;
	}
	
	public String getBuyer() {
		return buyer;
	}
	
	public void setCategory(String tagIn) {
		tag = tagIn;
	}
	
	public String getCategory() {
		return tag;
	}
	
}
