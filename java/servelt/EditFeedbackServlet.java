package servelt;

import module.Feedback;
import services.FeedbackService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/EditFeedbackServlet")
public class EditFeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public EditFeedbackServlet() {
        super();
    }
    
    private final FeedbackService service = new FeedbackService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer sid = (Integer) session.getAttribute("sid");

        if (sid == null) {
            response.sendRedirect("Rlogin.jsp");
            return;
        }

        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendRedirect("Rprofile.jsp");
            return;
        }

        int id = Integer.parseInt(idParam);
        Feedback feedback = service.getFeedbackById(id);

        // Make sure feedback exists and belongs to the logged-in student
        if (feedback == null || feedback.getStudentId() != sid) {
            response.sendRedirect("profile.jsp");
            return;
        }

        request.setAttribute("feedback", feedback);
        request.getRequestDispatcher("editFeedback.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer sid = (Integer) session.getAttribute("sid");

        if (sid == null) {
            response.sendRedirect("Rlogin.jsp");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        String content = request.getParameter("content");

        Feedback feedback = new Feedback();
        feedback.setId(id);
        feedback.setStudentId(sid); // Needed for ownership check during update
        feedback.setType(type);
        feedback.setContent(content);

        boolean updated = service.updateFeedback(feedback);

        if (updated) {
            response.sendRedirect("Rprofile.jsp");
        } else {
            response.sendRedirect("editFeedback.jsp?id=" + id + "&error=true");
        }
    }
}
