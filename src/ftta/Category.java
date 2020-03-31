package ftta;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<String> tags;
	private double transactionTotal;
	private double pointSchema;
	private double pointsTotal;
	
	public Category(String nameIn) {
		name = nameIn;
		tags = new ArrayList<String>();
		transactionTotal = 0;
		pointsTotal = 0;
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
	
	public String getTag(int index) {
		return tags.get(index);
	}
	
	public int getTagListSize() {
		return tags.size();
	}
	
	public void addToTransactionTotal(double transactionPrice) {
		transactionTotal += transactionPrice;
		if(transactionPrice > 0)
			addToPointsTotal(transactionPrice);
	}

	public void setPointSchema(double pointSchema){
		this.pointSchema = pointSchema;
	}

	public double getPointsTotal(){
		return pointsTotal;
	}

	public void addToPointsTotal(double transactionPrice){
		pointsTotal += transactionPrice*pointSchema; 
	}

	public void removePointsFromTotal(double pointsToRemove){
		if(pointsToRemove>=pointsTotal){
			pointsTotal = 0;
		}else{
			pointsTotal -= pointsToRemove;
		}
	}
}
