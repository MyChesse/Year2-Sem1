/*package GKservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GKservices.GKExamservice;
import Gkmodel.GKExam;

@WebServlet("/addExam")
public class addExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public addExam() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GKExam exam = new GKExam();
		
		exam.setQuestionid(request.getParameter("questionid"));
		exam.setQuestion1(request.getParameter("question1"));
		exam.setQuestion2(request.getParameter("question2"));
		exam.setQuestion3(request.getParameter("question3"));
		exam.setQuestion4(request.getParameter("question4"));
		exam.setQuestion5(request.getParameter("question5"));
		
		GKExamservice service = new GKExamservice();
		service.exam(exam);
		
		request.setAttribute("successMessage", "Questions added successfully!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("GKExam.jsp");
		dispatcher.forward(request, response);

		
	}

}*/

package servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.GKExamservice;
import module.GKExam;

@WebServlet("/addExam")
public class addExam extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieve form data
        String questionid = request.getParameter("questionid");
        String question1 = request.getParameter("question1");
        String question2 = request.getParameter("question2");
        String question3 = request.getParameter("question3");
        String question4 = request.getParameter("question4");
        String question5 = request.getParameter("question5");


        // Populate model
        GKExam exam = new GKExam();
        exam.setQuestionid(questionid);
        exam.setQuestion1(question1);
        exam.setQuestion2(question2);
        exam.setQuestion3(question3);
        exam.setQuestion4(question4);
        exam.setQuestion5(question5);

        // Call service to save exam
        GKExamservice service = new GKExamservice();
        service.addExam(exam);

        // Success response
        request.setAttribute("successMessage", "Questions added successfully!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("GKProfile.jsp");
        dispatcher.forward(request, response);
        
    }
}


