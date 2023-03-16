package test.corsi.architecture.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import corsi.architecture.dao.CourseDAO;
import corsi.architecture.dao.DAOException;
import corsi.architecture.dao.StudentCourseDAO;
import corsi.architecture.dao.StudentDAO;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Course;
import corsi.businesscomponent.model.Student;
import corsi.businesscomponent.model.StudentCourse;

@TestMethodOrder(OrderAnnotation.class)
class StudentCourseDAOTest {
	private long StudentCode;
	private long CourseCode;
	private static Connection conn;

	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
		Student student = new Student();
		Course course = new Course();
		StudentCourse sc = new StudentCourse();
		

		student = new Student();
		student.setCode(1);
		student.setName("Luca");
		student.setSurname("Rossi");
		student.setBackground(true);

		course = new Course();
		course.setCourseCode(2);
		course.setCourseName("Programmazione");
		course.setStartDate(new GregorianCalendar().getTime());
		course.setEndDate(new GregorianCalendar().getTime());
		course.setCourseCost(200);
		course.setCourseComment("true");
		course.setCourseRoom("20");

		sc = new StudentCourse();
		sc.setStudentCode(1);
		sc.setCourseCode(2);
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			CourseDAO.getFactory().create(conn, new Course());
			StudentDAO.getFactory().create(conn, new Student());
			StudentCourseDAO.getFactory().create(conn, new StudentCourse());
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			fail("getAll fallito: " + e.getMessage());
		}
	}

	@Test
	@Order(2)
	void testDeleteByCode() {
		try {
			StudentCourseDAO.getFactory().deleteByCode(conn , StudentCode, CourseCode);
		} catch (SQLException e) {
			fail("sql exception");
			System.out.println(e.getMessage());
		}

	}

	@AfterEach
	static void tearDown() throws Exception {
		CourseDAO.getFactory().delete(conn, new Course());
		StudentDAO.getFactory().delete(conn, new Student());
		StudentCourseDAO.getFactory().deleteByCode(conn, 1, 1);
	}
}