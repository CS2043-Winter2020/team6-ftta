package ftta;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<String> tags;
	
	public Category(String nameIn) {
		name = nameIn;
		tags = new ArrayList<String>();
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
	
	public ArrayList<String> getTagsList(){
		return tags;
	}
}
