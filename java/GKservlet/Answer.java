package GKservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GKservices.GKExamservice;
import Gkmodel.GKAnswer;
import Gkmodel.GKExam;

@WebServlet("/Answer")
public class Answer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Service layer call
        GKExamservice service = new GKExamservice();
        ArrayList<GKAnswer> answerList = null;
		
		answerList = service.getAllAnswers();
		
        // Set answer list as request attribute to be used in JSP
        request.setAttribute("answer", answerList);

        // Forward to JSP for display
        RequestDispatcher dispatcher = request.getRequestDispatcher("GKAnswers.jsp");
        dispatcher.forward(request, response);
	}

}
