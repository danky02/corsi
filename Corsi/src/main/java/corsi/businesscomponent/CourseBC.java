package corsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import corsi.architecture.dao.CourseDAO;
import corsi.architecture.dao.DAOException;
import corsi.architecture.dao.StudentCourseDAO;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Course;
import corsi.businesscomponent.model.Student;
import corsi.businesscomponent.model.StudentCourse;

public class CourseBC {
	private Connection conn;
	private CourseDAO cDAO;
	private StudentCourseDAO scDAO;

	public CourseBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
		cDAO = CourseDAO.getFactory();
		scDAO = StudentCourseDAO.getFactory();
	}
	
	public void create(Course course) throws ClassNotFoundException, DAOException, IOException {
		try {
			cDAO.create(conn, course);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void update(Course course) throws ClassNotFoundException, DAOException, IOException {
		try {
			cDAO.update(conn, course);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void deleteByCode(long code) throws ClassNotFoundException, DAOException, IOException {
		try {
			cDAO.deleteByCode(conn, code);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Course getByCode(long code) throws DAOException {
		Course course = null;
		try {
			course = cDAO.getByCode(conn, code);
		} finally {
			DBAccess.closeConnection();
		}
		return course;
	}

	public List<Course> getAll() throws DAOException {
		List<Course> courseList = null;
		try {
			courseList = cDAO.getAll(conn);
		} finally {
			DBAccess.closeConnection();
		}
		return courseList;
	}
	
	public String getMostPopular() throws DAOException {
		String mostPop = null;
		try {
			mostPop = cDAO.getMostPopular(conn);
		} finally {
			DBAccess.closeConnection();
		}
		return mostPop;
	}
	
	public Date getLatest() throws DAOException {
		Date date;
		try{
			date = cDAO.getLatest(conn);
		} finally {
			DBAccess.closeConnection();
		}
		return date;
	}
	
	public double getAverage() throws DAOException {
		double avg = 0;
		try{
			avg = cDAO.getAverage(conn);
		} finally {
			DBAccess.closeConnection();
		}
		return avg;
	}
	
	public List<Integer> getDiff() throws DAOException {
		List<Integer> result = null;
		try {
			result = cDAO.getDateDiff(conn);
		} finally {
			DBAccess.closeConnection();
		}
		return result;
	}
	
	public List<Course> getFree() throws DAOException {
		List<Course> result = null;
		try {
			result = cDAO.getFree(conn);
		} finally {
			DBAccess.closeConnection();
		}
		return result;
	}
	
	public List<Course> getCoursesByStudent(Student student) throws DAOException { 
		List<Course> courses = new ArrayList<Course>();
		
		try {
			List<StudentCourse> studentCourses = scDAO.getByStudent(conn, student.getCode());
			
			for (StudentCourse studentCourse : studentCourses) {
				Course course = cDAO.getByCode(conn, studentCourse.getCourseCode());
				courses.add(course);
			}			
		} finally {
			DBAccess.closeConnection();
		}
		
		return courses;
	}
}
