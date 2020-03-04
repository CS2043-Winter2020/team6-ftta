package ftta;

import java.util.ArrayList;

public class TransactionList {
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public void addToTransactions(Transaction transaction) {
        transactions.add(transaction);
    }
}