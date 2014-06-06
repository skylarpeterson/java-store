package store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ProductCatalog {

	private DBConnection connection;
	private HashMap<String, Product> catalog;
	
	public ProductCatalog(DBConnection connection){
		this.connection = connection;
		catalog = new HashMap<String, Product>();
		ResultSet items = connection.retrieveAllItems();
		try {
			items.beforeFirst();
			while(items.next()){
				Product newProduct = new Product(items.getString("productid"), items.getString("name"), items.getString("imagefile"), Double.parseDouble(items.getString("price")));
				catalog.put(items.getString("productid"), newProduct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> getCatalog(){
		ArrayList<Product> products = new ArrayList<Product>();
		Set<String> keys = catalog.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			String key = it.next();
			Product p = catalog.get(key);
			products.add(p);
		}
		return products;
	}
	
	public Product getProduct(String id){
		return catalog.get(id);
	}
}
