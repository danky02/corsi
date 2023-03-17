package corsi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import corsi.businesscomponent.StudentBC;


@WebServlet("/deleteStudent")
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = -2220262339123175934L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long studentCode = Long.parseLong(request.getParameter("student"));
		
		StudentBC sBC;
		try {
			sBC = new StudentBC();
			sBC.deleteByCode(studentCode);
		} catch (ClassNotFoundException | SQLException | IOException exc) {
			throw new ServletException(exc);
		}
		
		response.sendRedirect("courseAttendance.jsp");
	}

}
