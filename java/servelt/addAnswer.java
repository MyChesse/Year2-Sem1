package servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.GKExamservice;
import module.GKAnswer;

/*@WebServlet("/addAnswer")
public class addAnswer extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GKAnswer answer = new GKAnswer.Builder()
            .setSid(request.getParameter("sid"))
            .setAnswer1(request.getParameter("answer1"))
            .setAnswer2(request.getParameter("answer2"))
            .setAnswer3(request.getParameter("answer3"))
            .setAnswer4(request.getParameter("answer4"))
            .setAnswer5(request.getParameter("answer5"))
            .build();

        GKExamservice service = new GKExamservice();
        try {
			service.addAnswers(answer);
		} catch (Exception e) {
			e.printStackTrace();
		}

        request.setAttribute("successMessage", "Answers submitted successfully!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
        dispatcher.forward(request, response); // form JSP
    }
}*/


@WebServlet("/addAnswer")
public class addAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve form data
        String sid = request.getParameter("sid");
        String answer1 = request.getParameter("answer1");
        String answer2 = request.getParameter("answer2");
        String answer3 = request.getParameter("answer3");
        String answer4 = request.getParameter("answer4");
        String answer5 = request.getParameter("answer5");
        
        // Populate model
        GKAnswer answer = new GKAnswer();
        answer.setSid(sid);
        answer.setAnswer1(answer1);
        answer.setAnswer2(answer2);
        answer.setAnswer3(answer3);
        answer.setAnswer4(answer4);
        answer.setAnswer5(answer5);

        // Call service to save exam
        GKExamservice service = new GKExamservice();
        service.addAnswers(answer);

        // Success response
        request.setAttribute("successMessage", "Answers successfully saved!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("About.jsp");
        dispatcher.forward(request, response);
	}

}

