
package Controller;

import Entities.Department;
import Entities.Student;
import Model.ModelGroup;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Department> departments = ModelGroup.dptmdl.list();
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("/WEB-INF/Create.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student std = new Student();
        std.setName(request.getParameter("name"));
        int dptId = Integer.parseInt(request.getParameter("department"));
        std.setDepartment_id(dptId);
        int gender = Integer.parseInt(request.getParameter("gender"));
        std.setGender(gender);
        std.setDob(request.getParameter("dob"));
        if (ModelGroup.stdmdl.create(std))
            response.sendRedirect("../student/list");
        else
            response.sendRedirect("../student/create");
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
