
package Controller;

import Entities.Fruit;
import Model.FruitModel;
import Model.ModelGroup;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FruitUpdateController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                    
            int id = Integer.parseInt((String) request.getParameter("id"));
            Fruit fruit = ModelGroup.fruitMdl.search(id);
            if (fruit != null) {
                request.setAttribute("title", "Update Fruit");
                request.setAttribute("fruit", fruit);
                request.getRequestDispatcher("/WEB-INF/FruitUpdate.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {
        }
        response.sendRedirect("../fruit/list");
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            Fruit fruit = new Fruit();
            fruit.setId(Integer.parseInt(request.getParameter("id")));
            fruit.setName(request.getParameter("name"));
            fruit.setPrice(Float.parseFloat(request.getParameter("price")));
            boolean status = ModelGroup.fruitMdl.update(fruit);
            
            HttpSession session = request.getSession();
            if (status) {
                response.sendRedirect("../fruit/list");
                return;
            }
        } catch (Exception e) {}
        response.sendRedirect(request.getHeader("referer"));
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
