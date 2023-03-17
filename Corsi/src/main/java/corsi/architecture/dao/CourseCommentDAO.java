package corsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import corsi.businesscomponent.model.CourseComment;

public class CourseCommentDAO implements DAOConstants {

	public static CourseCommentDAO getFactory() throws DAOException {
		return new CourseCommentDAO();
	}
	
	public void deleteByCode(Connection conn, long id) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_COMMENT_BYCODE);
			ps.setLong(1, id);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public CourseComment getByCode(Connection conn, long id) throws DAOException {
		CourseComment comment = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_COURSE_BY_CODE);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				comment= new CourseComment();
				comment.setCourseCode(rs.getLong(1));
				comment.setStudentCode(rs.getLong(2));
				comment.setCommentDesc(rs.getString(3));

			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return comment;
	}

	public long getCount(Connection conn) throws SQLException {
		long count = -1;
		Statement stmt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_COMMENT_COUNT);
		if (rs.next()) {
			count = rs.getLong(1);
		}
		rs.close();
		return count;
	}
	
	
}
