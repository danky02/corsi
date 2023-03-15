package corsi.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import corsi.businesscomponent.model.StudentCourse;

public class StudentCourseDAO implements DAOConstants {

	private CachedRowSet rowSet;

	private StudentCourseDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static StudentCourseDAO getFactory() throws DAOException {
		return new StudentCourseDAO();
	}

	
	public void create(Connection conn, StudentCourse entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_STUDENT);
			rowSet.execute(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
