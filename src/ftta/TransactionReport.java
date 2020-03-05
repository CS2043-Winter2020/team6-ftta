package ftta;

import java.util.ArrayList;

public class TransactionReport {
	private CategoryList cList;
	private BuyerList bList;
	private ProcessedTransactionList ptList;
	
	public TransactionReport(CategoryList cListIn, BuyerList bListIn, ProcessedTransactionList ptListIn) {
		cList = cListIn;
		bList = bListIn;
		ptList = ptListIn;
	}
	
	public void setCategoryList(CategoryList cListIn) {
		cList = cListIn;
	}
	
	public void calculateCategoryListTotals() {
		for(int i = 0; i<cList.size(); i++) {
			calculateCategoryTotal(cList.getCategoryByIndex(i));
		}
	}
	
	private void calculateCategoryTotal(Category catIn) {
		for(int i = 0; i<ptList.size(); i++) {
			if(catIn.isTagInCategory(ptList.get(i).getTag())) {
				catIn.addToTransactionTotal(ptList.get(i).getTransaction().getDebit());
			}
		}
	}
}
