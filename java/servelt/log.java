package servelt;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import module.customer;
import services.customerService;

@WebServlet("/log")  // Servlet URL pattern
public class log extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get data from form
        customer cus = new customer();
        cus.setEmail(request.getParameter("email"));
        cus.setName(request.getParameter("name"));
        cus.setPassword(request.getParameter("password"));

        // 2. Call service
        customerService service = new customerService();
        customer registered = service.regcoustomer(cus);

        // 3. Send to JSP
        request.setAttribute("regcoustomer", registered);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
}
