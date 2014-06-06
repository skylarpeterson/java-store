package store;

import java.util.HashMap;
import java.util.Set;

public class ShoppingCart {

	private HashMap<String, Integer> cart;
	
	public ShoppingCart(){
		cart = new HashMap<String, Integer>();
	}
	
	public void addItem(String id){
		if(cart.containsKey(id)){
			setQuantity(id, getQuantity(id) + 1);
		} else {
			setQuantity(id, 1);
		}
	}
	
	public void removeItem(String id){
		cart.remove(id);
	}
	
	public int getQuantity(String id){
		return cart.get(id);
	}
	
	public void setQuantity(String id, int quantity){
		cart.put(id, quantity);
	}
	
	public Set<String> getItems(){
		return cart.keySet();
	}

}
