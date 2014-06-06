<%@ page import="store.*, java.util.ArrayList" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Store</title>
</head>
<body>
<h1>Student Store</h1>
<p>Items available:</p>
<ul>
<%
ProductCatalog catalog = (ProductCatalog) request.getSession().getAttribute("catalog");
ArrayList<Product> products = catalog.getCatalog();
for(int i = 0; i < products.size(); i++){
	Product currProduct = products.get(i);
	out.println("<li><a href=\"ProductPage.jsp?id=" + currProduct.productid + "\">" + currProduct.name + "</a></li>");
}
%>
</ul>
</body>
</html>