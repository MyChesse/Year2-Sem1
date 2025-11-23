package servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module.customer;
import services.customerService;


@WebServlet("/updatecustomer")
public class updatecustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updatecustomer() {
        super();
        

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		customer CUS = new customer();
		
		CUS.setEmail(request.getParameter("email"));
		CUS.setName(request.getParameter("name"));
		CUS.setPassword(request.getParameter("password"));
		
		customerService service = new customerService();
		
		service.updateCustomer(CUS);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("KSadmin.jsp");
		
		
		
		
		dispatcher.forward(request, response);
	}

}
