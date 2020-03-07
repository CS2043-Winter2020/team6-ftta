package ftta;

import java.util.ArrayList;

public class ProcessedTransactionList {
	private ArrayList<ProcessedTransaction> processedTransactions = new ArrayList<ProcessedTransaction>();
	
	public void addProccessedTransaction(ProcessedTransaction ptIn) {
		processedTransactions.add(ptIn);
	}
	
	public void removeProccessedTransaction(ProcessedTransaction ptIn) {
		processedTransactions.remove(ptIn);
	}
	
	public ProcessedTransaction get(int index) {
		return processedTransactions.get(index);
	}
	
	public int size() {
		return processedTransactions.size();
	}
}
