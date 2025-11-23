package servelt;

import services.FeedbackService;
import services.InterfaceFeedbackService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteFeedbackServlet")
public class DeleteFeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteFeedbackServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        InterfaceFeedbackService service = new FeedbackService();  //polymorphism
        boolean success = service.deleteFeedback(id);

        if (success) {
            response.sendRedirect("Rprofile.jsp");
        } else {
            response.getWriter().println("Failed to delete feedback.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

