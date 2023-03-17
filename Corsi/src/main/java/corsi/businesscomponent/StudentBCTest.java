package corsi.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import corsi.businesscomponent.model.Student;

class StudentBCTest {
	
	private static StudentBC sBC; 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sBC = new StudentBC();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testCreate() {
		Student student = new Student();
		student.setBackground(false);
		student.setName("TestName");
		student.setSurname("TestSurname");
		try {
			sBC.create(student);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
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
	void testGetTotCount() {
		fail("Not yet implemented"); // TODO
	}

}
