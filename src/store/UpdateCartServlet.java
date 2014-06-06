package store;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		Set<String> itemIDs = cart.getItems();
		Iterator<String> it = itemIDs.iterator();
		while(it.hasNext()){
			String id = it.next();
			String quantityStr = request.getParameter(id + "quantity");
			if(quantityStr.isEmpty() || Integer.parseInt(quantityStr) == 0) {
				cart.removeItem(id);
			}
			else {
				cart.setQuantity(id, Integer.parseInt(quantityStr));
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("CartPage.jsp");
		dispatcher.forward(request, response);
	}

}
