package corsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import corsi.businesscomponent.model.Course;

public class CourseDAO implements DAOConstants {

	private CachedRowSet rowSet;

	private CourseDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static CourseDAO getFactory() throws DAOException {
		return new CourseDAO();
	}

	public void create(Connection conn, Course entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_COURSE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCourseCode());
			rowSet.updateString(2, entity.getCourseName());
			rowSet.updateDate(3, new java.sql.Date(entity.getStartDate().getTime()));
			rowSet.updateDate(4, new java.sql.Date(entity.getEndDate().getTime()));
			rowSet.updateDouble(5, entity.getCourseCost());
			rowSet.updateString(6, entity.getCourseComment());
			rowSet.updateString(7, entity.getCourseRoom());
			rowSet.updateLong(8, entity.getProfessorCode());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(Connection conn, Course entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_COURSE);
			ps.setLong(1, entity.getCourseCode());
			ps.execute();
			conn.commit();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void update(Connection conn, Course entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_COURSE);
			
			ps.setString(1, entity.getCourseName());
			ps.setDate(2, new java.sql.Date(entity.getStartDate().getTime()));
			ps.setDate(3, new java.sql.Date(entity.getEndDate().getTime()));
			ps.setDouble(4, entity.getCourseCost());
			ps.setString(5, entity.getCourseComment());
			ps.setString(6, entity.getCourseRoom());
			ps.setLong(7, entity.getProfessorCode());
			ps.setLong(8, entity.getCourseCode());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void deleteByCode(Connection conn, long id) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_COURSE_BY_CODE);
			ps.setLong(1, id);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Course getByCode(Connection conn, long id) throws DAOException {
		Course course = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_COURSE_BY_CODE);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				course = new Course();
				course.setCourseCode(rs.getLong(1));
				course.setCourseName(rs.getString(2));
				course.setStartDate(rs.getDate(3));
				course.setEndDate(rs.getDate(4));
				course.setCourseCost(rs.getDouble(5));
				course.setCourseComment(rs.getString(6));
				course.setCourseRoom(rs.getString(7));
				course.setProfessorCode(rs.getLong(8));
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return course;
	}

	public List<Course> getAll(Connection conn) throws DAOException {
		List<Course> courses = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_COURSE);
			rs.last();
			courses = new ArrayList<Course>();
			rs.beforeFirst();
			while (rs.next()) {
				Course course = new Course();
				course.setCourseCode(rs.getLong(1));
				course.setCourseName(rs.getString(2));
				course.setStartDate(rs.getDate(3));
				course.setEndDate(rs.getDate(4));
				course.setCourseCost(rs.getDouble(5));
				course.setCourseComment(rs.getString(6));
				course.setCourseRoom(rs.getString(7));
				course.setProfessorCode(rs.getLong(8));
				courses.add(course);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return courses;
	}
	
	public int getStudentCount(Connection conn) throws DAOException {
		int count = 0;
//		try {
//			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//		} catch(SQLException sql) {
//			throw new DAOException(sql);
//		}
		return count;
	}
	
	public String getMostPopular(Connection conn) throws DAOException {
		Course course = null;
		PreparedStatement ps;
		String result;
		try {
			ps = conn.prepareStatement(SELECT_MOST_ATTENDED_COURSE);
			ResultSet rs = ps.executeQuery();
			result = rs.getString("course_name");
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return result;
	}
}
