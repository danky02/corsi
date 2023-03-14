package test.corsi.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import corsi.businesscomponent.idgenerator.CourseIdGenerator;

class CourseIdGeneratorTest {

	@Test
	void testIdGenerator() {
		try {
			long id = CourseIdGenerator.getInstance().getNextId();
			System.out.println(id);
		} catch(Exception e) {
			e.printStackTrace();
			fail("ID Gen failed, cause: " + e.getMessage());
		}
	}

}
