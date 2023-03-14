package corsi.architetture.dao;

public interface DAOConstants {
	
	String SELECT_COURSE = "Select * from course";
	String SELECT_STUDENT = "Select * from student";
	String SELECT_PROFESSOR = "Select * from professor";
	
	String UPDATE_COURSE = "Update course set course_name = ?, course_surname = ?, start_date = ?, end_date = ?, course_cost = ?, course_comment = ?, course_room = ? where course_code = ?";
	String UPDATE_STUDENT = "Update student set student_name = ?, student_surname = ?, educational_background = ? where student_code = ?";
	String UPDATE_PROFESSOR = "Update professor set professor_name = ?, professor_surname = ?, professor_cv = ? where professor_code = ?";
	String UPDATE_ADMIN = "Update admin set admin_name = ?, admin_surname = ? where admin_code = ?";
	
	String DELETE_COURSE = "Delete from course where course_code = ?";
	String DELETE_STUDENT = "Delete from student where student_code = ?";
	String DELETE_PROFESSOR = "Delete from professor where professor_code = ?";
	String DELETE_ADMIN = "Delete from admin where admin_code = ?";
	String DELETE_STUDENT_COURSE = "Delete from student_course where student_course_code = ?";
	
	String SELECT_COURSE_BY_CODE = "Select * from course where course_code = ?";
	String SELECT_STUDENT_BY_CODE = "Select * from student where student_code = ?";
	String SELECT_PROFESSOR_BY_CODE = "Select * from professor where professor_code = ?";
	String SELECT_ADMIN_BY_CODE = "Select * from admin where admin_code = ?";
	
}