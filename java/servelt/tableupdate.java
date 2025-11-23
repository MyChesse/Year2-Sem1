package servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module.marks;
import services.questionService;


@WebServlet("/tableupdate")
public class tableupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public tableupdate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		questionService service =new questionService();
		
		ArrayList<marks> marks = service.getAllQuestions();
		request.setAttribute("marks", marks);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("marktable.jsp");	
		dispatcher.forward(request, response);
	}

}
