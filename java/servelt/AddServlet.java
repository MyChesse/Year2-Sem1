package servelt;

import module.Timetable;
import services.TimetableService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/AddServlet")//inheritance
public class AddServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String subject = request.getParameter("subject");
        String day = request.getParameter("day");
        String startTime = request.getParameter("start_time");
        String endTime = request.getParameter("end_time");

        Timetable t = new Timetable( subject, day, startTime, endTime);
        TimetableService service = new TimetableService();

        boolean isInserted = service.insertTimetable(t);

        if (isInserted) {
        	RequestDispatcher time= request.getRequestDispatcher("Dhome.jsp");
        	time.forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
