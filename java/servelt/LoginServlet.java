package servelt;

import module.Student;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentService studentService;

    @Override
    public void init() {
        studentService = new StudentService(); // Uses DBConnection inside
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sidStr = request.getParameter("sid");
        String password = request.getParameter("password");

        if (sidStr == null || password == null || sidStr.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("error", "Student ID and Password are required.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        try {
            int sid = Integer.parseInt(sidStr);
            Student student = studentService.login(sid, password);

            if (student != null) {
                HttpSession session = request.getSession();
                session.setAttribute("student", student);
                session.setAttribute("sid", student.getSid()); //help to fill feedbacks by auto filling this
                session.setAttribute("studentId", student.getId());
                session.setAttribute("studentName", student.getName());
                session.setAttribute("studentEmail", student.getEmail());
                session.setAttribute("studentPhone", student.getPhone());
                session.setAttribute("studentDob", student.getBirthday());
                response.sendRedirect("Rprofile.jsp");
            } else {
                request.setAttribute("error", "Invalid Student ID or Password.");
                request.getRequestDispatcher("Rlogin.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Student ID must be a number.");
            request.getRequestDispatcher("Rlogin.jsp").forward(request, response);
        }
    }
}