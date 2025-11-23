package servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.GKExamservice;
import module.GKExam;

@WebServlet("/viewExam")
public class viewExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GKExam exam = new GKExam();
		exam.setQuestion1(request.getParameter("question1"));
		exam.setQuestion2(request.getParameter("question2"));
		exam.setQuestion3(request.getParameter("question3"));
		exam.setQuestion4(request.getParameter("question4"));
		exam.setQuestion5(request.getParameter("question5"));
        
		// Service layer call
        GKExamservice service = new GKExamservice();
        GKExam examList= service.getExams(exam);

        request.setAttribute("exam", examList);

        // Forward to JSP for display
        RequestDispatcher dispatcher = request.getRequestDispatcher("GKViewExam.jsp");
        dispatcher.forward(request, response);
	}

}
