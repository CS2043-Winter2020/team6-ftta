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
		boolean found = false;
		int index = 0;
		for(int i=0; i<tags.size() && !found; i++) {
			if(tags.get(i).equals(tagIn)) {
				found = true;
				index = i;
			}
		}
		if(found)
			tags.remove(index);
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getTags(){
		return tags;
	}
}
