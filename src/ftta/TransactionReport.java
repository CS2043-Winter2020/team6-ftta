package ftta;

import java.util.ArrayList;

public class TransactionReport {
	private CategoryList cList = new CategoryList();
	private BuyerList bList = new BuyerList();
	private TransactionList tList = new TransactionList();
	private ProcessedTransactionList ptList = new ProcessedTransactionList();
	
//	public void addCategory(Category categoryIn) {
//		cList.addCategory(categoryIn);
//	}
//	
//	public void addBuyer(Category categoryIn) {
//		cList.addCategory(categoryIn);
//	}
	
	public void setTlist(TransactionList tListIn) {
		tList = tListIn;
	}
	
	public CategoryList getClist() {
		return cList;
	}
	
	public BuyerList getBlist() {
		return bList;
	}
	
	public TransactionList getTlist() {
		return tList;
	}
	
	public ProcessedTransactionList getPTList() {
		return ptList;
	}
	
	public void addProcessedTransaction(ProcessedTransaction ptIn) {
		ptList.addProccessedTransaction(ptIn);
	}
	
	public void calculateCategoryListTotals() {
		for(int i = 0; i<cList.size(); i++) {
			calculateCategoryTotal(cList.getCategory(i));
		}
	}

	public double getTotalPointsFromAllCategories() {
		double totalPoints = 0;
		for (int i = 0; i < cList.size(); i++) {
			totalPoints += cList.getCategory(i).getPointsTotal();
		}
		return totalPoints;
	}
	
	private void calculateCategoryTotal(Category catIn) {
		for(int i = 0; i<ptList.size(); i++) {
			if(catIn.isTagInCategory(ptList.get(i).getTag())) {
				catIn.addToTransactionTotal(ptList.get(i).getTransaction().getDebit());
			}
		}
	}
	
	public void calculateBuyerListTotals() {
		for(int i = 0; i<bList.size(); i++) {
			calculateBuyerTotal(bList.getBuyer(i));
		}
	}
	
	private void calculateBuyerTotal(Buyer buyerIn) {
		for(int i=0; i<ptList.size(); i++) {
			if(ptList.get(i).getBuyer().equalsIgnoreCase(buyerIn.getInitials())) {
				Transaction t = ptList.get(i).getTransaction();
				if(t.getCredit()==0)
					buyerIn.addToTransactionTotal(t.getDebit());
				else
					buyerIn.addToTransactionTotal(-t.getCredit());
			}
		}
	}

}
