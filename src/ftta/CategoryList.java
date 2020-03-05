package ftta;

import java.util.ArrayList;

public class CategoryList {
	private ArrayList<Category> categories = new ArrayList<Category>();
	
	public void addCategory(Category categoryIn) {
		categories.add(categoryIn);
	}

	public void removeCategory(String name) {
		boolean found = false;
		int index=0;
		for(int i=0; i<categories.size() && !found; i++) {
			if(categories.get(i).getName().equals(name)) {
				found = true;
				index = i;
			}
		}
		if(found)
			categories.remove(index);
	}
	
	public Category getCategoryByName(String name) {
		Category cat = new Category("");
		for(int i=0; i<categories.size(); i++) {
			if(categories.get(i).getName().equals(name)) {
				cat = categories.get(i);
			}
		}
		return cat;
	}
	
	public Category getCategoryByIndex(int index) {
		return categories.get(index);
	}
	
	public int size() {
		return categories.size();
	}
}
