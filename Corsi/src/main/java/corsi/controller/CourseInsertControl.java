package corsi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import corsi.businesscomponent.model.Course;

@WebServlet("/courseInsert")
public class CourseInsertControl extends HttpServlet {
	
	private static final long serialVersionUID = -885812994108878514L;
	
	private List<Course> courses= new ArrayList<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		Double cost = Double.parseDouble(request.getParameter("cost"));
		List<String> comments = new ArrayList<>();
		comments.add(request.getParameter("comment"));
		List<String> rooms = new ArrayList<>();
		rooms.add(request.getParameter("room"));
		
		Course course = new Course(name, start, end, cost, comments, rooms);
		courses.add(course);
		
		response.sendRedirect("courses.jsp");
	}

}
