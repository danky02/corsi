package corsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public void deleteByCode(Connection conn, long studentCode, long courseCode) throws DAOException {
		PreparedStatement ps;
		try {
			ps= conn.prepareStatement(DELETE_STUDENT_COURSE);
			ps.setLong(1, studentCode);
			ps.execute();
			conn.commit();
			ps.setLong(2, courseCode);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public int getStudentCount(Connection conn, long courseCode) throws DAOException {
		PreparedStatement ps;
		ResultSet rs;
		int count = -1;
		try {
			ps= conn.prepareStatement(SELECT_STUDENT_COUNT);
			ps.setLong(1, courseCode);
			rs = ps.executeQuery();
			rs.next();
			count = rs.getInt("1");
			rs.close();
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return count;
	}
}