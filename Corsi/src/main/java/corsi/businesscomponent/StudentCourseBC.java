package corsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import corsi.architecture.dao.DAOException;
import corsi.architecture.dao.StudentCourseDAO;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.StudentCourse;

public class StudentCourseBC {
	private Connection conn;
	private StudentCourseDAO scDAO;
	
	public StudentCourseBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
		scDAO = StudentCourseDAO.getFactory();
	}
	
	public void create (StudentCourse studentCourse) throws DAOException {
		try {
			scDAO.create(conn, studentCourse);			
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void deleteByCode (long studentCode, long courseCode) throws DAOException {
		try {
			scDAO.deleteByCode(conn, studentCode, courseCode);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public int getCountByCourse (long courseCode) throws DAOException {
		int result = -1;
		try {
			result = scDAO.getStudentCount(conn, courseCode);
		} finally {
			DBAccess.closeConnection();
		}
		return result;
	}
}
