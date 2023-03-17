package corsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import corsi.architecture.dao.DAOException;
import corsi.businesscomponent.StudentCourseBC;
import corsi.businesscomponent.model.StudentCourse;

/**
 * Servlet implementation class courseSubscriptionController
 */
@WebServlet("/courseSubscription")
public class courseSubscriptionController extends HttpServlet {
	private static final long serialVersionUID = 8378984683160863646L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("_method").toUpperCase();
		
		StudentCourse sc = new StudentCourse();
		
		sc.setStudentCode(Long.parseLong(request.getParameter("student")));
		sc.setCourseCode(Long.parseLong(request.getParameter("course")));			
		
		StudentCourseBC scBC;
		try {
			scBC = new StudentCourseBC();
		} catch (DAOException | ClassNotFoundException | IOException e1) {
			throw new ServletException(e1);
		}
		
		try {
			if (method.equals("SUBSCRIBE"))  {
				scBC.create(sc);
			} else if (method.equals("UNSUBSCRIBE")) {
				scBC.deleteByCode(sc.getStudentCode(), sc.getCourseCode());
			} else {
				throw new ServletException("invalid _method parameter");
			}
		} catch (DAOException e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect("infoStudente.jsp?code=" + sc.getStudentCode());
	}

}
