package corsi.businesscomponent.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import corsi.businesscomponent.model.Professor;

public class Validator {

	private Validator() {
		
	}

	public static Validator getInstance() {
		return new Validator();
	}
	
	public Boolean isValidStudentName(String name) {
		if(name.length() <= 30) {
			char[] charArray = name.toCharArray();
			for(char c : charArray)
				if(Character.isDigit(c))
					return false;
			return true;
		}
		return false;
	}
	
	public Boolean isValidCourseName(String name) {
		if(name.length() <= 30) {
			char[] charArray = name.toCharArray();
			for(char c : charArray)
				if(Character.isDigit(c))
					return false;
			return true;
		}
		return false;
	}
	
	public Boolean isValidDate(String date) {
		String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	
	public Boolean isValidTimeFrame(Date start, Date end) throws ParseException {
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
	
	public Boolean isValidClassroom(String classroom) {
		String regex = "^[a-zA-Z0-9]*$";
		Pattern pattern = Pattern.compile(regex);
		String sDate = classroom.toString();
		Matcher matcher = pattern.matcher(sDate);
		return matcher.matches();
	}
	
//	public Boolean isValidProfessor(long code) {
//		Professor professor = null;
//		try {
//			AdminFacade facade = new AdminFacade();
//			professor = facade.getProfessorByCode(code);
//			if(professor == null)
//				return false;
//			return true;
//		} catch(Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
}
