package servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.TimetableService;

@SuppressWarnings("serial")
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    
        int id = Integer.parseInt(request.getParameter("id"));

       
        TimetableService service = new TimetableService();
        try {
			service.deleteTimetable(id);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

       
        response.sendRedirect("ReadServlet");
    }
}

