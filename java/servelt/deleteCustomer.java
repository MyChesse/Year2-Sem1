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


@WebServlet("/deleteCustomer")
public class deleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public deleteCustomer() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		customer cus =new customer();
		
		cus.setEmail(request.getParameter("email"));//set it in to the object ,pass the unique name
		
		customerService service = new customerService();
		
		service.deleteCustomer(cus);//call the method
		
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("adminCustomer");
		
		
		
		dispatcher.forward(request, response);
	}

}
