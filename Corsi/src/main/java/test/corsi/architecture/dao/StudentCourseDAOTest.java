package test.corsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import corsi.architecture.dao.DAOException;
import corsi.architecture.dao.StudentCourseDAO;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.StudentCourse;

class StudentCourseDAOTest {
	
	private static Connection conn;
	
	private static void executeCommand(String command) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// create into db test values
			stmt = conn.prepareStatement(command);
			rs = stmt.executeQuery();
			
			System.out.println("Esecuzione del comando: " + command);
		} catch (SQLException stmtExc){
			System.err.println(stmtExc.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
		}
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();

		String commands[] = {
				"DELETE student_course",
				"DELETE course",
				"DELETE professor",
				"DELETE student",
				"INSERT INTO professor (professor_name, professor_surname, professor_cv, professor_code) VALUES ('John', 'Smith', 'PhD in Computer Science', 1001)",
				"INSERT INTO professor (professor_name, professor_surname, professor_cv, professor_code) VALUES ('Alice', 'Johnson', 'Master in Data Analytics', 1002)",
				"INSERT INTO professor (professor_name, professor_surname, professor_cv, professor_code) VALUES ('David', 'Lee', 'PhD in Artificial Intelligence', 1003)",
				"INSERT INTO professor (professor_name, professor_surname, professor_cv, professor_code) VALUES ('Emily', 'Davis', 'Master in Database Management', 1004)",
				"INSERT INTO professor (professor_name, professor_surname, professor_cv, professor_code) VALUES ('Michael', 'Wilson', 'PhD in Computer Science', 1005)",
				"INSERT INTO course (course_code, course_name, start_date, end_date, course_cost, course_comments, course_room, professor_code) VALUES (101, 'Intro to Computer Science', TO_DATE('2022-09-05', 'yyyy-mm-dd'), TO_DATE('2022-12-15', 'yyyy-mm-dd'), 2000.00, NULL, 'Room A', 1001)",
				"INSERT INTO course (course_code, course_name, start_date, end_date, course_cost, course_comments, course_room, professor_code) VALUES (102, 'Data Structures and Algorithms', TO_DATE('2023-01-09', 'yyyy-mm-dd'), TO_DATE('2023-04-21', 'yyyy-mm-dd'), 2500.00, 'This course requires knowledge of programming basics.', 'Room B', 1002)",
				"INSERT INTO course (course_code, course_name, start_date, end_date, course_cost, course_comments, course_room, professor_code) VALUES (103, 'Introduction to AI', TO_DATE('2023-09-04', 'yyyy-mm-dd'), TO_DATE('2023-12-14', 'yyyy-mm-dd'), 3000.00, NULL, 'Room C', 1003)",
				"INSERT INTO course (course_code, course_name, start_date, end_date, course_cost, course_comments, course_room, professor_code) VALUES (104, 'Database Management Systems', TO_DATE('2024-01-08', 'yyyy-mm-dd'), TO_DATE('2024-04-19', 'yyyy-mm-dd'), 2200.00, 'This course covers SQL and NoSQL databases.', 'Room D', 1004)",
				"INSERT INTO course (course_code, course_name, start_date, end_date, course_cost, course_comments, course_room, professor_code) VALUES (105, 'Web Development', TO_DATE('2024-09-02', 'yyyy-mm-dd'), TO_DATE('2024-12-12', 'yyyy-mm-dd'), 2800.00, NULL, 'Room E', 1005)",
				"INSERT INTO student (student_name, student_surname, student_code, educational_background) VALUES ('Sarah', 'Johnson', 2001, 1)",
				"INSERT INTO student (student_name, student_surname, student_code, educational_background) VALUES ('Ryan', 'Lee', 2002, 0)",
				"INSERT INTO student (student_name, student_surname, student_code, educational_background) VALUES ('Emma', 'Smith', 2003, 1)",
				"INSERT INTO student (student_name, student_surname, student_code, educational_background) VALUES ('Oliver', 'Davis', 2004, 0)",
				"INSERT INTO student (student_name, student_surname, student_code, educational_background) VALUES ('Sophia', 'Brown', 2005, 0)",
				"INSERT INTO student_course (student_code, course_code) VALUES (2001, 101)",
				"INSERT INTO student_course (student_code, course_code) VALUES (2002, 101)",
				"INSERT INTO student_course (student_code, course_code) VALUES (2002, 102)",
				"INSERT INTO student_course (student_code, course_code) VALUES (2003, 102)",
				"INSERT INTO student_course (student_code, course_code) VALUES (2004, 103)",
				"INSERT INTO student_course (student_code, course_code) VALUES (2005, 103)",
		};
		
		for (String command: commands) executeCommand(command);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		String commands[] = {
				"DELETE student_course",
				"DELETE course",
				"DELETE professor",
				"DELETE student",
		};
		//for (String command: commands) executeCommand(command);
		
		conn.close();
	}

	@Order(1)
	@Test
	void testCreate() {
		StudentCourse sc = new StudentCourse();
		sc.setCourseCode(101);
		sc.setStudentCode(2001);
		try {
			StudentCourseDAO.getFactory().create(conn, sc);
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	@Order(2)
	@Test
	void testDeleteByCode() {
		try {
			executeCommand("INSERT INTO student_course VALUES(2003, 102)");
		} catch (SQLException e1) {
			fail("fail pre text");
		}
		
		StudentCourse sc = new StudentCourse();
		sc.setCourseCode(102);
		sc.setStudentCode(2003);
		try {
			StudentCourseDAO.getFactory().deleteByCode(conn, sc.getStudentCode(), sc.getCourseCode());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	@Order(3)
	@Test
	void testGetStudentCount() {
		try {
			int count = StudentCourseDAO.getFactory().getStudentCount(conn, 103);
			if (count != 2) {
				fail("mismatch, receaved:" + count);
			}
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	@Order(4)
	void testGetByStudent() {
		try {
			List<StudentCourse> result = StudentCourseDAO.getFactory().getByStudent(conn, 2002);
				
			if (result.size() != 2) {
				fail("data mismatch");
			}
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}

}
