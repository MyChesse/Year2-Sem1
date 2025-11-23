package servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module.customer;
import services.customerService;


@WebServlet("/adminCustomer")
public class adminCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public adminCustomer() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		customerService service = new customerService();
		
		//call the method
		
		ArrayList<customer> customer =  service.getAllcustomer();//get all the values
		request.setAttribute("customer",customer);
		
		
		//redirect
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("admintable.jsp");//file that display
		
		dispatcher.forward(request, response);
	}

}
