package ftta;

import java.util.ArrayList;

public class TransactionReport {
	private ArrayList<ProcessedTransaction> processedTransaction = new ArrayList<ProcessedTransaction>();
	
	public void addToTransactions(ProcessedTransaction pTransaction) {
		processedTransaction.add(pTransaction);
    }
}
