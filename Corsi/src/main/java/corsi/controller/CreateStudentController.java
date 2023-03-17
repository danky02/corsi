package corsi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import corsi.businesscomponent.StudentBC;
import corsi.businesscomponent.model.Student;
import corsi.businesscomponent.utilities.Validator;

@WebServlet("/createStudent")
public class CreateStudentController extends HttpServlet {
	private static final long serialVersionUID = -6998837354289720578L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String strBackground = request.getParameter("background");
			
			if (name == null || surname == null || strBackground == null) {
				throw new ServletException("invalid paramenters");
			}
			
			Student student = new Student();
			
			if (!(strBackground.equals("true") || strBackground.equals("false"))) {
				throw new ServletException("invalid paramenter background");
			}
			student.setBackground(strBackground.equals("true"));
			
			student.setName(name);
			student.setSurname(surname);
			if (!Validator.getInstance().isValidStudent(student)) {
				throw new ServletException("invalid student data");
			}
			
			StudentBC studentBC = new StudentBC();
			studentBC.create(student);
			
			response.sendRedirect("courseAttendance.jsp");
		} catch (Exception redirectException) {
			redirectException.printStackTrace();
			throw new ServletException(redirectException);
		}
	}

}
