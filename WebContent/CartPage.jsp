<%@ page import="store.*, java.util.ArrayList, java.util.Set, java.util.Iterator, java.text.DecimalFormat" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
<h1>Shopping Cart</h1>
<ul>
<form action="UpdateCartServlet" method="post">
<%
ProductCatalog catalog = (ProductCatalog) request.getSession().getAttribute("catalog");
ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
Set<String> itemIDs = cart.getItems();
Iterator<String> it = itemIDs.iterator();
DecimalFormat decim = new DecimalFormat("0.00");
double total = 0;
while(it.hasNext()){
	String id = it.next();
	Product p = catalog.getProduct(id);
	total += p.price * cart.getQuantity(id);
	out.println("<li><input type=\"text\" name=\""+id+"quantity\" value=\""+cart.getQuantity(id)+ "\" />" + p.name + ", $"+ decim.format(p.price) +"</li>");
}
String totalStr = decim.format(total);
out.println("Total: $" + totalStr);
%>
<input type="submit" value="Update Cart" />
</form>
</ul>
<a href="Homepage.jsp">Continue Shopping</a>
</body>
</html>