package servelt;

import services.StudentService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import module.Student;
import java.io.IOException;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateStudentServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Get student from session
        Student student = (Student) session.getAttribute("student");

        if (student == null) {
            response.sendRedirect("Rlogin.jsp");
            return;
        }

        // Get form data
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        // If password is not provided, keep the old one
        if (password == null || password.trim().isEmpty()) {
        	password = student.getPassword();
        }

        
        System.out.println("Updating student: " + student.getId() + " | " + student.getName());


        // Update student object
        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);
        student.setPassword(password);

        try {
            // Validate date
            java.sql.Date.valueOf(birthday); // Throws IllegalArgumentException if invalid
            student.setBirthday(birthday);

            StudentService service = new StudentService();
            boolean updated = service.updateStudent(student);

            if (updated) {
                session.setAttribute("student", student);
                session.setAttribute("studentName", name);
                session.setAttribute("studentEmail", email);
                session.setAttribute("studentPhone", phone);
                session.setAttribute("studentDob", birthday);
                response.sendRedirect("profile.jsp");
            } else {
                response.sendRedirect("updateProfile.jsp?error=true");
            }
        } catch (Exception e) {
            // Invalid date format
        	System.out.println(e);
            response.sendRedirect("updateProfile.jsp?error=invalidDate");
        }
    }
}
