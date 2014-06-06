<%@ page import="store.*, java.text.DecimalFormat" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ProductCatalog catalog = (ProductCatalog) request.getSession().getAttribute("catalog");
Product p = catalog.getProduct(request.getParameter("id"));
DecimalFormat decim = new DecimalFormat("0.00");
out.println("<h1>" + p.name + "</h1>");
out.println("<img src=\"" + p.imagefile + "\"></img>");
out.println("<form action=\"CartServlet\" method=\"post\"");
out.println("<p>$" + decim.format(p.price) + "<input name =\"productID\" type=\"hidden\" value=\"" + p.productid + "\" /><input type=\"submit\" value=\"Add to Cart\"</p>");
out.println("</form>");
%>
</body>
</html>