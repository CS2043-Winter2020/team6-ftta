package ftta.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ftta.Category;
import ftta.CategoryList;

class CategoryListTest {
	Category c1 = new Category("Groceries");
	Category c2 = new Category("Car");
	Category c3 = new Category("Entertainment");
	Category c4 = new Category("Household");
	Category c5 = new Category("Pharmacy");
	
	CategoryList cList = new CategoryList();
	
	@Test
	void testAddCategory() {
		cList.addCategory(c1);
		cList.addCategory(c2);
		cList.addCategory(c3);
		cList.addCategory(c4);
		cList.addCategory(c5);
		
		assertTrue(cList.size()==5);
	}

}
