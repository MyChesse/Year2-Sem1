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


@WebServlet("/atcustomer")
public class atcustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public atcustomer() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		customer cus= new customer();
		
		cus.setEmail(request.getParameter("email"));
		cus.setName(request.getParameter("name"));
		cus.setPassword(request.getParameter("password"));
		
		///create variable
		
		customerService service = new customerService();
		
		//get the method
		service.regcoustomer(cus);
		
		
		//create the view
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
		
		dispatcher.forward(request, response);
		
		
		
		doGet(request, response);
	}

}
