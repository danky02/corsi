package test.corsi.businesscomponent.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import corsi.businesscomponent.utilities.Validator;


class ValidatorTest {

	@Test
	void testStudentName() {
		String studentName = "Luigi";
		assertTrue(Validator.getInstance().isValidStudentName(studentName));
		studentName = "Luigi777";
		assertFalse(Validator.getInstance().isValidStudentName(studentName));
		studentName = "LuigiLuigiLuigiLuigiLuigiLuigiLuigi";
		assertFalse(Validator.getInstance().isValidStudentName(studentName));
	}
	
	@Test
	void testCourseName() {
		String courseName = "Java Course";
		assertTrue(Validator.getInstance().isValidStudentName(courseName));
		courseName = "Java Course 123";
		assertFalse(Validator.getInstance().isValidStudentName(courseName));
		courseName = "JavaCourseJavaCourseJavaCourseJavaCourseJavaCourse";
		assertFalse(Validator.getInstance().isValidStudentName(courseName));
	}
	
	@Test
	void testDate() {
		String date = "02/02/1992";
		assertTrue(Validator.getInstance().isValidDate(date));
		date = "2/2/1992";
		assertTrue(Validator.getInstance().isValidDate(date));
		date = "2/2/92";
		assertTrue(Validator.getInstance().isValidDate(date));
		date = "2222/32/1992";
		assertFalse(Validator.getInstance().isValidDate(date));
		date = "22/3222/1992";
		assertFalse(Validator.getInstance().isValidDate(date));
	}
	
	@Test
	void testTimeFrame() {
		GregorianCalendar c1 = new GregorianCalendar();
		c1.set(Calendar.DAY_OF_MONTH, 2);
		c1.set(Calendar.MONTH, 5);
		c1.set(Calendar.YEAR, 1992);
		Date startDate = new Date();
		startDate.setTime(c1.getTimeInMillis());
		GregorianCalendar c2 = new GregorianCalendar();
		c2.set(Calendar.DAY_OF_MONTH, 3);
		c2.set(Calendar.MONTH, 5);
		c2.set(Calendar.YEAR, 1992);
		Date endDate = new Date();
		endDate.setTime(c2.getTimeInMillis());
		try {
			assertTrue(Validator.getInstance().isValidTimeFrame(startDate, endDate));
			c2.set(Calendar.DAY_OF_MONTH, 2);
			endDate.setTime(c2.getTimeInMillis());
			assertFalse(Validator.getInstance().isValidTimeFrame(startDate, endDate));
		} catch (ParseException e) {
			e.printStackTrace();
			fail("testEndDate failed, cause: " + e.getMessage());
		}
	}
	
	@Test
	void commentTest() {
		String comment = "Comment";
		assertTrue(Validator.getInstance().isValidComment(comment));
		comment = "Comment 123, Test";
		assertTrue(Validator.getInstance().isValidComment(comment));
		comment = "CommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentCommentComment";
		assertFalse(Validator.getInstance().isValidComment(comment));
	}
}
