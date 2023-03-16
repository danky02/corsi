package corsi.businesscomponent.utilities;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import corsi.businesscomponent.facade.AdminFacade;
import corsi.businesscomponent.model.Admin;
import corsi.businesscomponent.model.Course;
import corsi.businesscomponent.model.Professor;
import corsi.businesscomponent.model.Student;

public class Validator {

	private Validator() {
		
	}

	public static Validator getInstance() {
		return new Validator();
	}
	
	public Boolean isValidStudent(Student student) {
		if(isValidStudentName(student.getName()) && isValidStudentName(student.getSurname()))
			return true;
		return false;
	}
	
	public Boolean isValidAdmin(Admin admin) {
		if(isValidStudentName(admin.getAdminName()) && isValidStudentName(admin.getAdminSurname()))
			return true;
		return false;
	}
	
	
	public Boolean isValidCourse(Course course) throws ParseException {
		if(isValidCourseName(course.getCourseName()) && isValidTimeFrame(course.getStartDate(), course.getEndDate()) && isValidClassroom(course.getCourseRoom()) && isValidProfessor(course.getProfessorCode()))
			return true;
		return false;
	}
		
	private Boolean isValidStudentName(String name) {
		if(name.length() <= 30) {
			char[] charArray = name.toCharArray();
			for(char c : charArray)
				if(Character.isDigit(c))
					return false;
			return true;
		}
		return false;
	}
	
	private Boolean isValidCourseName(String name) {
		if(name.length() <= 30) {
			char[] charArray = name.toCharArray();
			for(char c : charArray)
				if(Character.isDigit(c))
					return false;
			return true;
		}
		return false;
	}
	
	private Boolean isValidDate(String date) {
		String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	
	private Boolean isValidTimeFrame(Date start, Date end) throws ParseException {
		GregorianCalendar startDate = new GregorianCalendar();
		GregorianCalendar endDate = new GregorianCalendar();
		startDate.setTime(start);
		endDate.setTime(end);
		startDate.add(Calendar.DAY_OF_MONTH, 1);
//		System.out.println(startDate.get(Calendar.DAY_OF_MONTH));
//		System.out.println(startDate.get(Calendar.MONTH));
//		System.out.println(startDate.get(Calendar.YEAR));
		if(endDate.getTimeInMillis() >= startDate.getTimeInMillis())
			return true;
		return false;
	}
	
	
	public Boolean isValidComment(String comment) {
		if(comment.length() <= 200)
			return true;
		return false;
	}
	
	private Boolean isValidClassroom(String classroom) {
		String regex = "^[a-zA-Z0-9]*$";
		Pattern pattern = Pattern.compile(regex);
		String sDate = classroom.toString();
		Matcher matcher = pattern.matcher(sDate);
		return matcher.matches();
	}
	
	private Boolean isValidProfessor(long code) {
		Professor professor = null;
		try {
			professor = AdminFacade.getInstance().getProfessorByCode(code);
			if(professor == null)
				return false;
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
