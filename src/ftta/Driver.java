package ftta;

import java.io.IOException;

public class Driver {
	public static void main(String[] args) {
		TransactionList tList = new TransactionList();
		CategoryList cList = new CategoryList();
		TransactionReport ptList = new TransactionReport();
		System.out.println("Processing Bank Record");
		TransactionScanner tScanner = new TransactionScanner(tList);
		try {
			tList = tScanner.ScanExcelSheet(tList, "/Users/owenpiercey/git/team6-ftta/TestFiles/SampleBankRecord.xls");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Transactions are recorded");
		
		Category c1 = new Category("Groceries");
		Category c2 = new Category("Car");
		Category c3 = new Category("Entertainment");
		Category c4 = new Category("Household");
		Category c5 = new Category("Pharmacy");

		c1.addTag("food");
		c1.addTag("pets");
		c1.addTag("sobeys");

		c2.addTag("Maintnence");
		c2.addTag("Gas");
		c2.addTag("Wash");

		c3.addTag("Movies");
		c3.addTag("KidsBop");
		c3.addTag("Netflix");
		
		c4.addTag("Cleaning");
		c4.addTag("Plumbing");
		c4.addTag("Paint");

		c5.addTag("Prescriptions");
		c5.addTag("OTC");
		c5.addTag("Dental");
		
		cList.addCategory(c1);
		cList.addCategory(c2);
		cList.addCategory(c3);
		cList.addCategory(c4);
		cList.addCategory(c5);

		
		Buyer buyer1 = new Buyer(1, "OP");
		Buyer buyer2 = new Buyer(2, "CW");
		Buyer buyer3 = new Buyer(3, "JP");
		Buyer buyer4 = new Buyer(4, "GI");
		
		ProcessedTransaction pt1 = new ProcessedTransaction(tList.getTransactions().get(0), buyer3.getInitials(), "Prescriptions");
		ProcessedTransaction pt2 = new ProcessedTransaction(tList.getTransactions().get(2), buyer3.getInitials(), "sobeys");
		ProcessedTransaction pt3 = new ProcessedTransaction(tList.getTransactions().get(3), buyer3.getInitials(), "food");
		ProcessedTransaction pt4 = new ProcessedTransaction(tList.getTransactions().get(4), buyer3.getInitials(), "Gas");

		ptList.addToTransactions(pt1);
		ptList.addToTransactions(pt2);
		ptList.addToTransactions(pt3);
		ptList.addToTransactions(pt4);
		

		
		
	}
}
