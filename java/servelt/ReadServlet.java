package servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module.Timetable;
import services.TimetableService;


@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TimetableService service = new TimetableService();
        List<Timetable> list = null;
		try {
			list = service.getAllTimetables();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}

        request.setAttribute("timetables", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Rhome.jsp");
        dispatcher.forward(request, response);
    }
}
