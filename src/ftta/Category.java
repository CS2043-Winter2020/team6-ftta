package ftta;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<String> tags;
	private double transactionTotal;
	
	public Category(String nameIn) {
		name = nameIn;
		tags = new ArrayList<String>();
		transactionTotal = 0;
	}
	
	public void addTag(String tagIn) {
		tags.add(tagIn);
	}

	public void removeTag(String tagIn) {
		if(tags.contains(tagIn)) {
			tags.remove(tagIn);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isTagInCategory(String tagIn) {
		return tags.contains(tagIn);
	}
	
	public ArrayList<String> getTagsList(){
		return tags;
	}
	
	public void addToTransactionTotal(double transactionPrice) {
		transactionTotal += transactionPrice;
	}
}
