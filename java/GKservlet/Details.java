/*package GKservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GKservices.GKExamservice;
import Gkmodel.GKExam;

@WebServlet("/Details")
public class Details extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GKExamservice service = new GKExamservice();
        ArrayList<GKExam> listExam = service.getALLExam(); // Fetch all exam details
        request.setAttribute("exam", listExam);

		RequestDispatcher dispatcher = request.getRequestDispatcher("GKDetails.jsp");
		dispatcher.forward(request, response);    
            
    }
}*/

package GKservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GKservices.GKExamservice;
import Gkmodel.GKExam;

@WebServlet("/Details")
public class Details extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Service layer call
        GKExamservice service = new GKExamservice();
        List<GKExam> examList = service.getAllExams();

        // Set exam list as request attribute to be used in JSP
        request.setAttribute("exam", examList);

        // Forward to JSP for display
        RequestDispatcher dispatcher = request.getRequestDispatcher("GKDetails.jsp");
        dispatcher.forward(request, response);
    }
}
