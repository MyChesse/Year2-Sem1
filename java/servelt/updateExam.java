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


@WebServlet("/updateExam")
public class updateExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int id = Integer.parseInt(request.getParameter("id"));
    	String questionid = request.getParameter("questionid");
        String question1 = request.getParameter("question1");
        String question2 = request.getParameter("question2");
        String question3 = request.getParameter("question3");
        String question4 = request.getParameter("question4");
        String question5 = request.getParameter("question5");
        
        GKExam exam = new GKExam();
        exam.setId(id);
        exam.setQuestionid(questionid);
        exam.setQuestion1(question1);
        exam.setQuestion2(question2);
        exam.setQuestion3(question3);
        exam.setQuestion4(question4);
        exam.setQuestion5(question5);
    	
        GKExamservice service = new GKExamservice();
        service.updateExam(exam);
        
        request.setAttribute("successMessage", "Questions update successfully!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("GKProfile.jsp");
        dispatcher.forward(request, response);
    }

}
