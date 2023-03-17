package corsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Course;

class CourseDAOTest {
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		DBAccess.closeConnection();
	}

	@Test
	void testCreate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDelete() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeleteByCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetByCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetMostPopular() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetLatest() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetAverage() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetDateDiff() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetFree() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetListByStudent() {
		try {
			List<Course> courses = CourseDAO.getFactory().getListByStudent(conn, 2002);
			for (Course c : courses) {
				System.out.println(c);
			}
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}

}
