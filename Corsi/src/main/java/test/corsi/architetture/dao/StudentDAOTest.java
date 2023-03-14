package test.corsi.architetture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import corsi.architetture.dao.StudentDAO;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Student;

class StudentDAOTest {
	
	static StudentDAO dao;
	static Connection conn;

	
	@BeforeAll
	static void tearDownBeforeClass() throws Exception {
		System.out.println("test avviato");
			
		
		try {
			conn = DBAccess.getConnection();
			dao = StudentDAO.getFactory();
			
			clearDb();
			
			String[] commands = {
					"INSERT INTO STUDENT VALUES('Piero', 'Angela', 1000001, 0)",
					"INSERT INTO STUDENT VALUES('Aldo', 'Rossini', 1000002, 1)",
					"INSERT INTO STUDENT VALUES('Gianni', 'Neri', 1000003, 0)",
			};
			
			for (int ii = 0; ii < commands.length; ii++) {
				String command = commands[ii];
				PreparedStatement stmt = null;
				ResultSet rs = null;
				try {
					// create into db test values
					stmt = conn.prepareStatement(command);
					rs = stmt.executeQuery();
					
					System.out.println("Esecuzione del comando: " + command);
				} catch (SQLException stmtExc){
					System.err.printf(String.format("command %d error\n", ii));
					System.err.println(stmtExc.getMessage());
				} finally {
					if (rs != null) rs.close();
					if (stmt != null) stmt.close();
				}
			}
			
		} catch(Exception genericExc) {
			System.err.println(genericExc.getMessage());
			conn.close();
		}
		
	}
	
	static void clearDb() {
		System.out.println("pulizia del db");
		// delete test values
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("DELETE FROM STUDENT WHERE student_code >= 1000000");
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private static Student createStudentInstance(String name, String surname, long code, boolean background) {
		Student student = new Student();
		student.setName(name);
		student.setSurname(surname);
		student.setCode(code);
		student.setBackground(background);
		return student;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		clearDb();
		conn.close();
		System.out.println("test terminato");
	}
	
	@Order(0)
	@Test
	void testGetByCode() {
		Student expectedStudent = createStudentInstance("Piero", "Angela", 1_000_001L, false);
		Student student = null;
		try {
			student = dao.getByCode(conn, expectedStudent.getCode());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			fail("sql exception");
		}
		
		if (student == null || !expectedStudent.equals(student)) {
			fail("invalid result");
		}
		
		System.out.println("test testGetByCode completato con successo");
	}
	
	@Order(4)
	@Test
	void testCreate() {
		Student createdStudent = createStudentInstance("TestName", "TestSurname", 1_000_000L, false);

		try {
			dao.create(conn, createdStudent);
			Student result = dao.getByCode(conn, createdStudent.getCode());
			
			if (!result.equals(createdStudent)) {
				fail("data mismatch");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			fail("sql exception");
		}
		
		System.out.println("test testCreate completato con successo");
	}

	@Order(5)
	@Test
	void testUpdate() {
		try {
			Student student = dao.getByCode(conn, 1000001L);
			student.setName("Piero2");
			student.setSurname("Angela2");
			student.setBackground(true);
			dao.update(conn, student);
			
			Student result = dao.getByCode(conn, 1000001L);
			
			if (!student.equals(result)) {
				fail("data mismatch");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			fail("sql exception");
		}
		
		System.out.println("test testUpdate completato con successo");
	}

	@Order(3)
	@Test
	void testDelete() {
		try {
			Student student = dao.getByCode(conn, 1_000_000L);
			dao.delete(conn, student);
			Student result = dao.getByCode(conn, student.getCode());
			
			if (result != null) {
				fail("data mismatch");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			fail("sql exception");
		}
		
		System.out.println("test testDelete completato con successo");
	}
	
	@Order(1)
	@Test
	void testGetAll() {
		try {
			List<Student> all = dao.getAll(conn);
			if (all.size() != 3) {
				fail("data mismatch");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			fail("sql exception");
		}
		
		System.out.println("test testGetAll completato con successo");
	}
	
	@Order(2)
	@Test
	void testGetCount() {
		try {
			int count = dao.getCount(conn);
			if (count != 3) {
				fail("data mismatch");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("test testGetCount completato con successo");
	}

}
