package store;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ConnectionListener
 *
 */
@WebListener
public class ConnectionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ConnectionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
        DBConnection connection = new DBConnection();
        ShoppingCart cart = new ShoppingCart();
        ProductCatalog catalog = new ProductCatalog(connection);
        HttpSession session = arg0.getSession();
        session.setAttribute("cart", cart);
        session.setAttribute("catalog", catalog);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
