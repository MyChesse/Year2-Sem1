package servelt;

import module.Student;
import services.StudentService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();

        student.setName(request.getParameter("name"));
        student.setBirthday(request.getParameter("birthday"));
        student.setEmail(request.getParameter("email"));
        student.setPhone(request.getParameter("phone"));
        student.setPassword(request.getParameter("password"));

        StudentService service = new StudentService();
        int generatedId = service.registerStudent(student); // real DB primary key

        if (generatedId != -1) {
            int sid = generatedId + 1000; // Auto-generated SID
            request.setAttribute("sid", sid);
            request.getRequestDispatcher("sidSuccess.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Registration Failed!");
            request.getRequestDispatcher("Rregister.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Rregister.jsp");
    }
}
