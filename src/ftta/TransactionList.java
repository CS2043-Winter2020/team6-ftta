package ftta;

import java.util.ArrayList;

public class TransactionList {
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public void addToTransactions(Transaction transaction) {
        transactions.add(transaction);
    }
    
    public ArrayList<Transaction> getTransactions(){
    	return transactions;
    }
    
    public Transaction getTransaction(int index) {
    	return transactions.get(index);
    }
    
    public int size() {
    	return transactions.size();
    }
}