package servelt;

import module.Feedback;
import services.FeedbackService;
import services.InterfaceFeedbackService; // import the interface

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddFeedbackServlet")
public class AddFeedbackServlet extends HttpServlet { //inheritance
    private static final long serialVersionUID = 1L;

    public AddFeedbackServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession(false); // Don't create new session
            if (session == null || session.getAttribute("sid") == null) {
                response.sendRedirect("Rlogin.jsp");
                return;
            }

            int sid = (Integer) session.getAttribute("sid");
            String type = request.getParameter("type");
            String content = request.getParameter("content");

            if (type == null || content == null || type.trim().isEmpty() || content.trim().isEmpty()) {
                request.setAttribute("error", "Type and Content are required.");
                request.getRequestDispatcher("addFeedback.jsp").forward(request, response);
                return;
            }

            try {
                // Word limit validation
                int wordLimit = 20;
                int wordCount = content.trim().split("\\s+").length;

                if (wordCount > wordLimit) {
                    request.setAttribute("error", "Feedback content exceeds the " + wordLimit + " word limit. It currently has " + wordCount + " words.");
                    request.setAttribute("type", type);
                    request.setAttribute("content", content); // retain user input
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    return;
                }

                Feedback feedback = new Feedback();
                feedback.setStudentId(sid);
                feedback.setType(type);
                feedback.setContent(content);
                feedback.setReviewed(false);

                InterfaceFeedbackService service = new FeedbackService();  //polymorphism

                boolean success = service.addFeedback(feedback);

                if (success) {
                    response.sendRedirect("Rprofile.jsp");
                } else {
                    request.setAttribute("error", "Failed to submit feedback.");
                    request.getRequestDispatcher("addFeedback.jsp").forward(request, response);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                request.setAttribute("error", "An error occurred while processing your feedback: " + ex.getMessage());
                request.setAttribute("type", type);
                request.setAttribute("content", content);
                request.getRequestDispatcher("addFeedback.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Unexpected error: " + e.getMessage());
            request.getRequestDispatcher("addFeedback.jsp").forward(request, response);
        }
    }
}
