
package SessionControl;

import Entities.*;
import Model.DAO;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionController {
    
    public static Customer getUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession ss = request.getSession();
        Customer cs = (Customer) ss.getAttribute("user");
        cs = new Customer();
        cs.setUsername("A");
        return cs;
    }
    
    public static Order getOrder(HttpServletRequest request, HttpServletResponse response, Order ord) {
        HttpSession ss = request.getSession();
        return (Order) ss.getAttribute("order");
    }
    
    public static void setOrder(HttpServletRequest request, HttpServletResponse response, Order ord) {
        HttpSession ss = request.getSession();
        ss.setAttribute("order", ord);
    }
    
    public static void insertCart(HttpServletRequest request, HttpServletResponse response, Product prd, int qty) {
        HttpSession ss = request.getSession();
        Order order = (Order) ss.getAttribute("order");
        
        Customer cs = getUser(request, response);
     
        if (cs == null) return;
        
        if (order == null) {
            order = new Order();
            order.setOrder_no(DAO.ord.count() + 1);
            order.setOrder_date(new Date(new java.util.Date().getTime()));
            order.setUsername(cs.getUsername());
            SessionController.setOrder(request, response, order);
        }
        
        ArrayList<OrderDetail> carts = SessionController.getCart(request, response);
        if (carts == null) carts = new ArrayList<OrderDetail>();
        
        OrderDetail cart = new OrderDetail();
        cart.setOrder_no(order.getOrder_no());
        cart.setProduct_id(prd.getProduct_id());
        cart.setPrd(DAO.prd.search(prd.getProduct_id()));
        cart.setPrice(prd.getPrice());
        cart.setQuantity(qty);
        ss.setAttribute("cart", cart);
        
        carts.add(cart);
        ss.setAttribute("cart", carts);
    }
    
    public static void emptyOrder(HttpServletRequest request, HttpServletResponse response) {
        HttpSession ss = request.getSession();
        ss.removeAttribute("order"); // Order info
        ss.removeAttribute("cart"); // OrderDetail list
    }
    
    public static ArrayList<OrderDetail> getCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession ss = request.getSession();
        ArrayList<OrderDetail> cart = (ArrayList<OrderDetail>) ss.getAttribute("cart");
        return cart;
    }
}
