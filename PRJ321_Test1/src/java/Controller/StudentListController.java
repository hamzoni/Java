
package Controller;

import Entities.Student;
import Model.ModelGroup;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Student> students = ModelGroup.stdmdl.list();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/WEB-INF/List.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
