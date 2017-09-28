
package Controller;

import Entities.Department;
import Entities.Student;
import Model.ModelGroup;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Department> departments = ModelGroup.dptmdl.list();
        request.setAttribute("departments", departments);
        
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = ModelGroup.stdmdl.search(id);
        if (student != null) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("/WEB-INF/Update.jsp").forward(request, response);
        } else {
            response.sendRedirect("list");
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student student = new Student();
        student.setId(Integer.parseInt(request.getParameter("id")));
        student.setName(request.getParameter("name"));
        student.setDob(request.getParameter("dob"));
        student.setGender(Integer.parseInt(request.getParameter("gender")));
        student.setDepartment_id(Integer.parseInt(request.getParameter("department")));
        ModelGroup.stdmdl.update(student);
        response.sendRedirect("list");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
