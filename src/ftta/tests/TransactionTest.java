package ftta.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ftta.Transaction;
import ftta.ProcessedTransaction;


class TransactionTest {

	@Test
	void Transaction() {
		Transaction transactionTest = new Transaction("April 04, 2020", "SOBEYS 849       QPS", 0, 42.69);

		String description = transactionTest.getDescription();

		assertEquals("SOBEYS 849       QPS", description);
		
		transactionTest.setDebit(1000);
		
		assertEquals(transactionTest.getDebit(), 1000);
		
		double credit = transactionTest.getCredit();

		assertEquals(42.69, credit);
	}
	
	@Test
	void ProcessedTransaction() {
		Transaction transactionTest = new Transaction("10/23/2019", "RINGO'S BAR & GRILL", 1050, 55.49);

		
		ProcessedTransaction processedTest = new ProcessedTransaction(transactionTest, "OP", "dog food");
		
		String date = processedTest.getTransaction().getDate();	
		
		assertEquals("10/23/2019", date);
		
		String tag = processedTest.getTag();
		
		assertEquals("dog food", tag);

		String buyer = processedTest.getBuyer();
		
		assertEquals("OP", buyer);
		
	}
}
