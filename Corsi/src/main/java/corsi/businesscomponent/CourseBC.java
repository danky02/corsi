package corsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import corsi.architecture.dao.CourseDAO;
import corsi.architecture.dao.DAOException;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Course;

public class CourseBC {
	private Connection conn;
	private CourseDAO cDAO;

	public CourseBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
		cDAO = CourseDAO.getFactory();
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
	
	public int getStudentCount() throws DAOException {
		int count = 0;
		try {
			cDAO.getStudentCount(conn);
		} finally {
			DBAccess.closeConnection();
		}
		return count;
	}
	
	public String getMostPopular() throws DAOException {
		try {
			cDAO.getMostPopular(conn);
		} finally {
			DBAccess.closeConnection();
		}
	}
}
