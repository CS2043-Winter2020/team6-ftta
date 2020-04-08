package ftta.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ftta.Buyer;
import ftta.BuyerList;

class BuyerListTest {
	BuyerList bList = new BuyerList();
	Buyer buyer1 = new Buyer("OP");
	Buyer buyer2 = new Buyer("CW");
	Buyer buyer3 = new Buyer("JP");
	Buyer buyer4 = new Buyer("GI");
	
	@Test
	void test() {
		bList.addBuyerToList(buyer1);
		bList.addBuyerToList(buyer2);
		bList.addBuyerToList(buyer3);
		bList.addBuyerToList(buyer4);
		
		assertTrue(bList.size()==4);
	}

}
