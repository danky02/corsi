package corsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import corsi.architetture.dao.StudentDAO;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Student;


public class StudentBC {
	private Connection conn;
	
	public StudentBC() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}
	

	// create (student: Student) void
	public void create(Student student) throws SQLException {
		try {
			StudentDAO.getFactory().create(conn, student);
		}finally {
			DBAccess.closeConnection();
		}
	}
	

	// update (student: Student) void
	public void update(Student student) throws SQLException {
		try {
			StudentDAO.getFactory().update(conn, student);
		}finally {
			DBAccess.closeConnection();
		}
	}
	
	// deleteByCode(code: long) void
	public void deleteByCode(long code) throws SQLException {
		try {
			StudentDAO dao = StudentDAO.getFactory();
			Student student = dao.getByCode(conn, code);
			dao.delete(conn, student);
			
		}finally {
			DBAccess.closeConnection();
		}
	}
	
	// getByCode(code: long) Student
	public Student getByCode(long code) throws SQLException {
		try {
			return StudentDAO.getFactory().getByCode(conn, code);
		}finally {
			DBAccess.closeConnection();
		}
	}
	
	// getAll() list<Student>
	public void getAll(Student student) throws SQLException {
		try {
			StudentDAO.getFactory().getAll(conn);
		}finally {
			DBAccess.closeConnection();
		}
	}
	
	// getCount() int
	public int getCount() throws SQLException {
		try {
			return StudentDAO.getFactory().getCount(conn);
		}finally {
			DBAccess.closeConnection();
		}
	}
}