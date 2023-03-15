package corsi.architecture.dao;

public interface DAOConstants {

	final String SELECT_COURSE = "Select * from course";
	final String SELECT_STUDENT = "Select * from student";
	final String SELECT_PROFESSOR = "Select * from professor";

	final String SELECT_STUDENT_COUNT = "SELECT COUNT(*) FROM STUDENT";
	final String SELECT_MOST_ATTENDED_COURSE = "Select course_name, count(*) as num from student_course group by course_name order by num desc limit 1";

	final String UPDATE_COURSE = "Update course set course_name = ?, start_date = ?, end_date = ?, course_cost = ?, course_comments = ?, course_room = ?, professor_code = ? where course_code = ?";
	final String UPDATE_STUDENT = "Update student set student_name = ?, student_surname = ?, educational_background = ? where student_code = ?";
	final String UPDATE_PROFESSOR = "Update professor set professor_name = ?, professor_surname = ?, professor_cv = ? where professor_code = ?";
	final String UPDATE_ADMIN = "Update admin set admin_name = ?, admin_surname = ?, admin_username = ? where admin_code = ?";

	final String DELETE_COURSE = "Delete from course where course_code = ?";
	final String DELETE_STUDENT = "Delete from student where student_code = ?";
	final String DELETE_PROFESSOR = "Delete from professor where professor_code = ?";
	final String DELETE_ADMIN = "Delete from admin where admin_code = ?";
	final String DELETE_STUDENT_COURSE = "Delete from student_course where student_code = ? and course_code=?";
	final String DELETE_COURSE_BY_CODE = "Delete from course where course_code= ?";

	final String SELECT_COURSE_BY_CODE = "Select * from course where course_code = ?";
	final String SELECT_STUDENT_BY_CODE = "Select * from student where student_code = ?";
	final String SELECT_PROFESSOR_BY_CODE = "Select * from professor where professor_code = ?";
	final String SELECT_ADMIN_BY_CODE = "Select * from admin where admin_code = ?";
	final String SELECT_ADMINCODE_BY_USERNAME = "Select admin_code from admin where admin_username = ?";

	
	// Sequence
	final String SELECT_STUDENT_SEQ = "select student_seq.nextval from dual";
	final String SELECT_COURSE_SEQ = "select course_seq.nextval from dual";

}