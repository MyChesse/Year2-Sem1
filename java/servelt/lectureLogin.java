package servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.GKExamservice;
import module.GKLecture;

@WebServlet("/lectureLogin")
public class lectureLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		
		GKLecture lecture = new GKLecture();
		lecture.setUsername(username);
		lecture.setPassword(pass);
		
		GKExamservice service = new GKExamservice();
		boolean valid = service.validate(lecture);
		
		if(valid) {
			HttpSession session = request.getSession();
            session.setAttribute("lectureUser", username);
            response.sendRedirect("GKProfile.jsp");
		}
		else {
            request.setAttribute("errorMessage", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("LectureLogin.jsp");
            dispatcher.forward(request, response);
        }
	}

}
