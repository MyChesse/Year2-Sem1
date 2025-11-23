package servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module.marks;
import services.questionService;


@WebServlet("/KSincorrect")
public class KSincorrect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public KSincorrect() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
       marks mrk = new marks();
		
		mrk.setQuestionid(request.getParameter("questionid"));
		
		questionService service = new questionService();
		
		service.deleteMarks(mrk);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("KSaddMarks");
		
		dispatcher.forward(request, response);
	}

}
