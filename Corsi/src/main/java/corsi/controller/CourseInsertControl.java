package corsi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import corsi.architecture.dao.DAOException;
import corsi.businesscomponent.facade.AdminFacade;
import corsi.businesscomponent.model.Course;
import corsi.businesscomponent.utilities.Validator;

@WebServlet("/courseInsert")
public class CourseInsertControl extends HttpServlet {

	private static final long serialVersionUID = -885812994108878514L;

	private List<Course> courses = new ArrayList<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
		
		
		String name = request.getParameter("course_name");
		String start = request.getParameter("startdate");
		String end = request.getParameter("enddate");
		Double cost = Double.parseDouble(request.getParameter("cost"));
		String classroom = request.getParameter("classroom");
		List<String> comments = new ArrayList<>();
		comments.add(request.getParameter("comment"));
		List<String> rooms = new ArrayList<>();
		rooms.add(request.getParameter("room"));
		Date startDate=new Date();
		Date endDate=new Date();
		
		try {
			startDate = formatter.parse(start);
			endDate = formatter.parse(end);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		Course course= new Course();
		course.setCourseName(name);
		course.setStartDate(startDate);
		course.setEndDate(endDate);
		course.setCourseCost(cost);
		course.setCourseRoom(classroom);
		
		try {
			if (Validator.getInstance().isValidCourse(course)) {
				AdminFacade.getInstance().createCourse(course);
				response.sendRedirect("courseInsert.jsp");
}else {
	System.out.println("Validazione non è andata a buon fine");
}
		} catch (ParseException | ClassNotFoundException | DAOException e) {
			e.printStackTrace();
		}

}
}