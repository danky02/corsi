package test.corsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import corsi.architecture.dao.CourseDAO;
import corsi.architecture.dao.DAOException;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Course;

@TestMethodOrder(OrderAnnotation.class)
class CourseTest {
	private static Connection conn;
	private static Course course;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		course = new Course();
		course.setCourseCode(5);
		course.setCourseName("Java");
		course.setStartDate(new GregorianCalendar(2023, 10, 21).getTime());
		course.setEndDate(new GregorianCalendar(2023, 11, 21).getTime());
		course.setCourseCost(2005);
		course.setCourseComment("Ottimo corso voto diesci");
		course.setCourseRoom("A31");
		course.setProfessorCode(1);
	}

	@Test
	@Order(1)
	void testCourse() {
		try {
			CourseDAO.getFactory().create(conn, course);
			System.out.println("creato corso");
			System.out.println(CourseDAO.getFactory().getByCode(conn, 5));
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Crate fallito: " + exc.getMessage());
		}
	}

	@Test
	@Order(2)
	void testUpdate() {
		try {
			System.out.println("inizio Aggiornamente");
			course = new Course();
			course.setCourseCode(5);
			course.setCourseName("HTML 5");
			course.setStartDate(new GregorianCalendar(2023, 9, 20).getTime());
			course.setEndDate(new GregorianCalendar(2023, 9, 20).getTime());
			course.setCourseCost(1900);
			course.setCourseComment("il voto per confermare o ribaltare la situazione");
			course.setCourseRoom("B50");
			course.setProfessorCode(3);
			CourseDAO.getFactory().update(conn, course);
			System.out.println("fine aggiornamento");
			System.out.println(CourseDAO.getFactory().getByCode(conn, 5));
		} catch (Exception exc) {
			exc.printStackTrace();
			fail("Update fallito: " + exc.getMessage());
		}
	}

	@Test
	@Order(3)
	void testGetByCode() {
		try {
			System.out.println("inizio getByCode");
			CourseDAO.getFactory().getByCode(conn, 5);
			System.out.println(CourseDAO.getFactory().getByCode(conn, 5));
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("getByCode fallito: " + exc.getMessage());
		}
	}

	@Test
	@Order(4)
	void testGetAll() {
		try {
			Course[] courses = CourseDAO.getFactory().getAll(conn);
			assertNotNull(courses);
			System.out.println("eseguito il getAll");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("getAll fallito: " + exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CourseDAO.getFactory().delete(conn, course);
			System.out.println("Eliminato articolo");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());

		}
	}

}
