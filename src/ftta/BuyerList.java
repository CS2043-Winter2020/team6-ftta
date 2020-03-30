package ftta;

import java.util.ArrayList;

public class BuyerList {
	ArrayList<Buyer> buyers = new ArrayList<Buyer>();

    public void addBuyerToList(Buyer buyer) {
    	boolean buyerExists = false;
    	
        for (int i = 0; i < buyers.size(); i++) {
        	if (buyers.get(i).getID() == buyer.getID()) {
        		buyerExists = true;
        	}
        }
        
        if (!buyerExists) {
    		buyers.add(buyer);
        }
    }
    
    public int getBuyerListLength() {
    	return buyers.size();
    }
    
    public String getBuyerInitials(int index) {
    	return buyers.get(index).getInitials();
    }
}
