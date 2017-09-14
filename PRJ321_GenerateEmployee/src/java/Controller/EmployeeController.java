
package Controller;

import Entities.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeController extends HttpServlet {
    String[] names = {"A", "B", "C", "D", "E"};
    String[] skills = {"C#", "C++", "Java", "SQL", "English", "Japanese", "LoL"};
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int n = Integer.parseInt(request.getParameter("no"));
        ArrayList<Employee> emps = new ArrayList<Employee>();
        for (int i = 0; i < n; i++) {
            Employee emp = new Employee();
            emp.id = (int) Math.floor(Math.random() * 9999);
            emp.name = names[(int) Math.floor(Math.random() * names.length)];
            emp.dob = randDOB();
            emp.skill = randSkill();
            emps.add(emp);
        }
        
        request.setAttribute("emps", emps);
        request.getRequestDispatcher("../View/Employee").forward(request, response);
    }
    
    private ArrayList<String> randSkill() {
        ArrayList<String> mskills = new ArrayList<String>();
        int rs = (int) Math.floor(Math.random() * skills.length);
        for (int i = 0; i < rs; i++) {
            mskills.add(skills[i]);
        }
        return mskills;
    }
    
    private String randDOB() {
        int days[] = {1, 31};
        int months[] = {1, 12};
        int years[] = {1900, 2000};
        
        return (int) Math.floor(days[0] + Math.random() * days[1]) + "/"
                + (int) Math.floor(months[0] + Math.random() * months[1]) + "/"
                + (int) Math.floor(years[0] + Math.random() * (years[1] - years[0]));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
