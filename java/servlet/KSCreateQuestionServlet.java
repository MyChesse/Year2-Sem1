package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import module.marks;
import services.questionService;

@WebServlet("/createQuestion")
public class KSCreateQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get data from form
        marks question = new marks();
        question.setQuestionid(request.getParameter("questionid"));
        question.setQuestion1(request.getParameter("question1"));
        question.setQuestion2(request.getParameter("question2"));
        question.setQuestion3(request.getParameter("question3"));
        question.setQuestion4(request.getParameter("question4"));
        question.setQuestion5(request.getParameter("question5"));
        question.setMarks(request.getParameter("marks"));

        // 2. Call service
        questionService service = new questionService();
        marks inserted = service.addQuestion(question);

        // 3. Send to JSP
        request.setAttribute("addQuestion", inserted);
        RequestDispatcher dispatcher = request.getRequestDispatcher("KSmarks.jsp");
        dispatcher.forward(request, response);
    }
}

