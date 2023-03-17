package corsi.architecture.dao;

public interface DAOConstants {

	final String SELECT_COURSE = "Select * from course";
	final String SELECT_STUDENT = "Select * from student";
	final String SELECT_PROFESSOR = "Select * from professor";

	final String SELECT_STUDENT_COUNT = "Select count(*) from student_course where course_code = ?";
	final String SELECT_TOT_STUDENT_COUNT = "Select count(*) from student";
	final String SELECT_COMMENT_COUNT = "Select count(*) from course_comment";
	final String SELECT_MOST_ATTENDED_COURSE = "Select course_name from student_course, course group by course_name having count(*) = ( select max(num) from ( Select count(*) as num from student_course group by course_name order by count(*) desc));";
	final String SELECT_LATEST_DATE = "Select max(start_date) from course";
	final String SELECT_DATE_AVG = "Select avg(end_date - start_date) from course";
	final String SELECT_DATE_DIFF = "Select end_date - start_data from course";
	final String SELECT_MULTI_PROF = "SELECT p.professor_name, p.professor_surname FROM professor p INNER JOIN course c1 ON c1.professor_code = p.professor_code INNER JOIN course c2 ON c2.professor_code = p.professor_code AND c2.course_code != c1.course_code GROUP BY p.professor_code, p.professor_name, p.professor_surname";
	final String SELECT_AVAILABLE_COURSES = "SELECT c.course_name, COUNT(sc.student_code) AS num_students FROM course c LEFT JOIN student_course sc ON c.course_code = sc.course_code WHERE (SELECT COUNT(*) FROM student_course sc2 WHERE sc2.course_code = c.course_code) < 12 GROUP BY c.course_name, c.course_code";
	
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
	final String DELETE_COMMENT_BYCODE = "Delete from course_comment where student_code = ? and course_code = ?";

	final String SELECT_COURSE_BY_CODE = "Select * from course where course_code = ?";
	final String SELECT_STUDENT_BY_CODE = "Select * from student where student_code = ?";
	final String SELECT_PROFESSOR_BY_CODE = "Select * from professor where professor_code = ?";
	final String SELECT_ADMIN_BY_CODE = "Select * from admin where admin_code = ?";
	final String SELECT_ADMIN_BY_USERNAME = "Select * from admin where admin_username = ?";
	final String SELECT_ADMINCODE_BY_USERNAME = "Select admin_code from admin where admin_username = ?";
	final String SELECT_COMMENT_BYCODE = "Select * from course_comment where student_code = ? and course_code = ?";
	final String SELECT_COMMENTS_BYCOURSE = "Select * from course_comment where course_code = ?";
	
	// Sequence
	final String SELECT_STUDENT_SEQ = "select student_seq.nextval from dual";
	final String SELECT_COURSE_SEQ = "select course_seq.nextval from dual";

}
