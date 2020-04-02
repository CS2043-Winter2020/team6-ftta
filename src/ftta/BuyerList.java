package ftta;

import java.util.ArrayList;

public class BuyerList {
	ArrayList<Buyer> buyers = new ArrayList<Buyer>();

    public void addBuyerToList(Buyer buyer) {
    	boolean buyerExists = false;
    	
        for (int i = 0; i < buyers.size(); i++) {
        	if (buyers.get(i).getInitials() == buyer.getInitials()) {
        		buyerExists = true;
        	}
        }
        
        if (!buyerExists) {
    		buyers.add(buyer);
        }
    }
    
    public int size() {
    	return buyers.size();
    }
    
    public Buyer getBuyer(String name) {
    	
    	for (int i = 0; i < buyers.size(); i++) {
    		if (buyers.get(i).getInitials().equals(name)) {
    			return buyers.get(i);
    		}
    	}
    	return null;
    }
    
    public String getBuyerInitials(int index) {
    	return buyers.get(index).getInitials();
    }
}
