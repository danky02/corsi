package corsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import corsi.architecture.dao.CourseCommentDAO;
import corsi.architecture.dao.DAOException;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.CourseComment;

public class CourseCommentBC {
	private Connection conn;
	private CourseCommentDAO ccDAO;

	public CourseCommentBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
		ccDAO = CourseCommentDAO.getFactory();
	}

	public void deleteByCode(long code) throws ClassNotFoundException, DAOException, IOException {
		try {
			ccDAO.deleteByCode(conn, code);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public CourseComment getByCode(long code) throws DAOException {
		CourseComment course = null;
		try {
			course = ccDAO.getByCode(conn, code);
		} finally {
			DBAccess.closeConnection();
		}
		return course;
	}

	public int getTotCount() throws SQLException {
		int result = -1;
		try {
			result = CourseCommentDAO.getFactory().getCount(conn);
		} finally {
			DBAccess.closeConnection();
		}
		return result;
	}
}
