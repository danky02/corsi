package corsi.architecture.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import corsi.businesscomponent.model.Course;
import corsi.businesscomponent.utilities.Validator;


@WebServlet("/createCourse")
public class CreateCourseControl extends HttpServlet {
	private static final long serialVersionUID = -4936540374949382089L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Course course = new Course();
		
		try {
			course.setCourseCode(Long.parseLong(request.getParameter("coursecode")));
			course.setCourseName(request.getParameter("coursename"));
			course.setStartDate(formato.parse(request.getParameter("startdate")));
			course.setEndDate(formato.parse(request.getParameter("startend")));
			course.setCourseCost(Double.parseDouble(request.getParameter("coursecost")));
			course.setCourseComment(request.getParameter("coursecomment"));
			course.setCourseRoom(request.getParameter("courseroom"));
			course.setProfessorCode(Long.parseLong(request.getParameter("professorcode")));
			
			if(Validator.getInstance().isValidCourse(course)) {
//				AdminFacade.getIstance().create(course);
				response.sendRedirect("home.jsp");
			}else {
				response.sendRedirect("bubbulone.jsp");
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}

	}

}
