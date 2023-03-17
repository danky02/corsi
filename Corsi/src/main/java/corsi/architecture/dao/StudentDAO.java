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

import corsi.businesscomponent.model.Student;

public class StudentDAO implements DAOConstants {
	private CachedRowSet rowSet;
	
	public static StudentDAO getFactory() throws SQLException {
		return new StudentDAO();
	}
	
	private StudentDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}
	
	public void create(Connection conn, Student student) throws SQLException {
		rowSet.setCommand(SELECT_STUDENT);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateString(1, student.getName());
		rowSet.updateString(2, student.getSurname());
		rowSet.updateLong(3, student.getCode());
		rowSet.updateInt(4, student.getBackground() ? 1 : 0);
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges(conn);
	}
	
	public void update(Connection conn, Student student) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(UPDATE_STUDENT);
		stmt.setString(1, student.getName());
		stmt.setString(2, student.getSurname());
		stmt.setInt(3, student.getBackground() ? 1 : 0);
		stmt.setLong(4, student.getCode());
		
		stmt.executeUpdate();
	}
	
	public void delete(Connection conn, Student student) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(DELETE_STUDENT);
		stmt.setLong(1, student.getCode());
		
		stmt.executeUpdate();
	}
	
	public Student getByCode(Connection conn, long code) throws SQLException {
		Student result = null;
		PreparedStatement stmt = conn.prepareStatement(SELECT_STUDENT_BY_CODE);
		stmt.setLong(1, code);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			result = new Student();
			result.setName(rs.getString("student_name"));
			result.setSurname(rs.getString("student_surname"));
			result.setCode(rs.getLong("student_code"));
			result.setBackground(rs.getInt("educational_background") == 1);
		}
		rs.close();
		stmt.close();
		return result;
	}
	
	public List<Student> getAll(Connection conn) throws SQLException {
		ArrayList<Student> students = new ArrayList<Student>();
		rowSet.setCommand(SELECT_STUDENT);
		rowSet.execute(conn);
		while(rowSet.next()) {
			Student s = new Student();
			s.setName(			rowSet.getString(1));
			s.setSurname(		rowSet.getString(2));
			s.setCode(			rowSet.getLong(3));
			s.setBackground(	rowSet.getInt(4) != 0);
			students.add(s);
		}
		return students;
	}
	
	public int getTotCount(Connection conn) throws SQLException {
		int count = -1;
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_TOT_STUDENT_COUNT);
		if (rs.next())
			count = rs.getInt(1);
		rs.close();
		stmt.close();
		return count;
	}
}