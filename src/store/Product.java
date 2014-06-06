package store;

public class Product {

	public String productid;
	public String name;
	public String imagefile;
	public double price;
	
	public Product(String productid, String name, String imagefile, double price){
		this.productid = productid;
		this.name = name;
		this.imagefile = imagefile;
		this.price = price;
	}
}
