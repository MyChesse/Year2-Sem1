package servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.TimetableService;


@SuppressWarnings("serial")
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
        int id = Integer.parseInt(request.getParameter("id"));
        @SuppressWarnings("unused")
		String subject = request.getParameter("subject");
        String day = request.getParameter("day");
        String startTime = request.getParameter("start_time");
        String endTime = request.getParameter("end_time");

      
        TimetableService service = new TimetableService();
        try {
			service.updateTimetable(id, day, startTime, endTime);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        response.sendRedirect("ReadServlet");
    }
}

