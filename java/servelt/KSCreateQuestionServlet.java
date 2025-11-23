package servelt;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import module.marks;
import services.questionService;

@WebServlet("/KSCreateQuestionServlet")
public class KSCreateQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get data from form
        marks mrk = new marks();
        mrk.setQuestionid(request.getParameter("questionid"));
        mrk.setQuestion1(request.getParameter("question1"));
        mrk.setQuestion2(request.getParameter("question2"));
        mrk.setQuestion3(request.getParameter("question3"));
        mrk.setQuestion4(request.getParameter("question4"));
        mrk.setQuestion5(request.getParameter("question5"));
        mrk.setMarks(request.getParameter("marks"));

        // 2. Call service
        questionService service = new questionService();
        marks inserted = service.addQuestion(mrk);

        // 3. Send to JSP
        request.setAttribute("addQuestion", inserted);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RSprofile.jsp"); //add rashmika profile
        dispatcher.forward(request, response);
    }
}

