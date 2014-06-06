package store;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {

	private Connection con;
	private Statement stmt;
	
	public DBConnection(){
		try {
			con = MyDB.getConnection();
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet retrieveAllItems(){
		try {
			return stmt.executeQuery("SELECT * FROM products");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> retrieveItem(String productID){
		try {
			ArrayList<String> itemArr = new ArrayList<String>();
			ResultSet set = stmt.executeQuery("SELECT * FROM products WHERE productid = \"" + productID + "\"");
			set.beforeFirst();
			while(set.next()){
				itemArr.add(set.getString("productid"));
				itemArr.add(set.getString("name"));
				itemArr.add(set.getString("imagefile"));
				itemArr.add(set.getString("price"));
			}
			return itemArr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
