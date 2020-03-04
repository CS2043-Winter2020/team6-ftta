package ftta;

public class Driver {
	public static void main(String[] args) {
		TransactionList tList = new TransactionList();
		
		System.out.println("Processing Bank Record");
		TransactionScanner tScanner = new TransactionScanner(tList);
		
		
		
	}
}
