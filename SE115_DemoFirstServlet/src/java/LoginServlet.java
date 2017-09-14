

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        float a = Float.parseFloat(request.getParameter("A"));
        float b = Float.parseFloat(request.getParameter("B"));
        int o = Integer.parseInt(request.getParameter("O"));
        float r = 0;
        switch (o) {
            case 0:
                r = a + b;
                break;
            case 1:
                r = a - b;
                break;
            case 2:
                r = a * b;
                break;
            case 3:
                r = a / b;
                break;
        }
        writer.write("Result: " + r);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
