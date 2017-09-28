
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

public class FruitCreateController extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Create Fruit");
        request.getRequestDispatcher("/WEB-INF/FruitCreate.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Fruit fruit = new Fruit();
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        fruit.setName(name);
        fruit.setPrice(price);
        ModelGroup.fruitMdl.create(fruit);
        response.sendRedirect("../fruit/list");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
