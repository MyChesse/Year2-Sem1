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


@WebServlet("/KSupdateMarks")
public class KSupdateMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public KSupdateMarks() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		marks mrk = new marks();
		
		mrk.setQuestionid(request.getParameter("questionid"));
		mrk.setQuestion1(request.getParameter("question1"));
		mrk.setQuestion2(request.getParameter("question2"));
		mrk.setQuestion3(request.getParameter("question3"));
		mrk.setQuestion4(request.getParameter("question4"));
		mrk.setQuestion5(request.getParameter("question5"));
		mrk.setMarks(request.getParameter("marks"));
		
		questionService service = new questionService();
		
		service.updateMarks(mrk);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("KSadmin.jsp");
		
		
		
		
		
		
		dispatcher.forward(request, response);
	}

}
