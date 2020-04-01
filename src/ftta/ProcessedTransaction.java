package ftta;

public class ProcessedTransaction {
	private String buyer;
	private String tag;
	private Transaction transaction;
	
	public ProcessedTransaction(Transaction transactionIn, String buyerIn, String tagIn) {
		buyer = buyerIn;
		tag = tagIn;
		transaction = transactionIn;
	}
	
	public void setBuyer(String buyerIn) {
		buyer = buyerIn;
	}
	
	public String getBuyer() {
		return buyer;
	}
	
	public void setTag(String tagIn) {
		tag = tagIn;
	}
	
	public String getTag() {
		return tag;
	}
	
	public Transaction getTransaction() {
		return transaction;
	}
	
	public CategoryList setPoints(CategoryList cList) {
		for (int i = 0; i < cList.size(); i++) {
			cList.getCategory(i).addToPointsTotal(transaction.getCredit());
		}

		return cList;
	}
}
