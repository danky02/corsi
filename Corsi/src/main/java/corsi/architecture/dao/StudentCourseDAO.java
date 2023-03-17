package corsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			rowSet.setCommand("SELECT * FROM student_course");
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getStudentCode());
			rowSet.updateLong(2, entity.getCourseCode());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges(conn);
			rowSet.execute(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void deleteByCode(Connection conn, long studentCode, long courseCode) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_STUDENT_COURSE);
			ps.setLong(1, studentCode);
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
			count = rs.getInt(1);
			rs.close();
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return count;
	}
	
	// TODO to remove
	public List<StudentCourse> getByStudent(Connection conn, long studentCode) throws DAOException {
		List<StudentCourse> result = new ArrayList<StudentCourse>();
		
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement("SELECT * FROM student_course WHERE student_code = ?"); //SELECT_STUDENT_COURSE_BY_STUDENT);
			
			ps.setLong(1, studentCode);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				StudentCourse studentCourse = new StudentCourse();
				studentCourse.setStudentCode(rs.getLong(1));
				studentCourse.setCourseCode(rs.getLong(2));
				result.add(studentCourse);
			}
			rs.close();
			
		} catch(SQLException exc) {
			throw new DAOException(exc);
		}
		
		return result;
	}
}