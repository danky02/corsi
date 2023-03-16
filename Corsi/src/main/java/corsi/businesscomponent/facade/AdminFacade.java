package corsi.businesscomponent.facade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import corsi.architecture.dao.DAOException;
import corsi.businesscomponent.AdminBC;
import corsi.businesscomponent.CourseBC;
import corsi.businesscomponent.ProfessorBC;
import corsi.businesscomponent.StudentBC;
import corsi.businesscomponent.StudentCourseBC;
import corsi.businesscomponent.model.Admin;
import corsi.businesscomponent.model.Course;
import corsi.businesscomponent.model.Professor;
import corsi.businesscomponent.model.Student;
import corsi.businesscomponent.model.StudentCourse;

public class AdminFacade {
	private static AdminFacade afInstance;
	private CourseBC courseBC;
	private AdminBC aBC;
	private StudentCourseBC scBC;
	private ProfessorBC pBC;
	private StudentBC sBC;
	
	
	// Disclaimer: nelle chiamate di delete ho preferito usare il metodo get della facade.
	// A livello di programmazione è più alto, però ne soffre la performance. Modificare
	// se ritenuto necessario con i metodi find del BC
	
	private AdminFacade() {
	}

	public static AdminFacade getInstance() {
		if (afInstance == null)
			afInstance = new AdminFacade();
		return afInstance;
	}
	
	// Per come è stato implementato, se si vorrebbe rimuovere getComment basta rimpiazzarlo
	// con findComment del BC corrispettivo
//	public void deleteCommentByCode(long code) throws ClassNotFoundException, IOException {
//		Comment c = new Comment();
//		commBC = new CommentBC();
//		c = getCommentByCode(code);
//		commBC.delete(c);
//	}
	
	// Si può rimuovere
//	public Comment getCommentByCode(long code) throws ClassNotFoundException, IOException {
//		commBC = new CommentBC();
//		return commBC.findCommentByCode(code);
//	}

	// Inoltre, per quanto riguarda il BC del comment, se la classe venisse inclusa
	// all'interno del course basta cambiare il BC
//	public List<Comment> getAllComments() throws ClassNotFoundException, IOException {
//		commBC = new CommentBC();
//		return commBC.getAll();
//	}
	
//	public int getCommentCount(long codeCourse) throws ClassNotFoundException, IOException {
//		courseBC = new courseBC();
//		return courseBC.getCommentsCount();
//	}

	public void createCourse(Course course) throws ClassNotFoundException, IOException, DAOException {
		courseBC = new CourseBC();
		courseBC.create(course);
	}
	
	public void updateCourse(Course course) throws ClassNotFoundException, IOException, DAOException {
		courseBC = new CourseBC();
		courseBC.update(course);
	}

	public void deleteCourseByCode(long code) throws ClassNotFoundException, IOException, DAOException {
		courseBC = new CourseBC();
		courseBC.deleteByCode(code);
	}
	
	public void createProfessor(Professor professor) throws ClassNotFoundException, IOException, DAOException {
		pBC = new ProfessorBC();
		pBC.create(professor);
	}
	
	public void updateProfessor(Professor professor) throws ClassNotFoundException, IOException, DAOException {
		pBC = new ProfessorBC();
		pBC.update(professor);
	}

	public void deleteProfessorByCode(long code) throws ClassNotFoundException, IOException, DAOException {
		pBC = new ProfessorBC();
		pBC.deleteByCode(code);
	}
	
	public Professor getProfessorByCode(long code) throws ClassNotFoundException, IOException, DAOException {
		pBC = new ProfessorBC();
		return pBC.getByCode(code);
	}
	
	public List<Professor> getAllProfessors() throws ClassNotFoundException, IOException, DAOException {
		pBC = new ProfessorBC();
		return pBC.getAll();
	}
	
	public void updateAdmin(Admin admin) throws ClassNotFoundException, IOException, DAOException {
		aBC = new AdminBC();
		aBC.update(admin);
	}

	public void deleteAdminByCode(long code) throws ClassNotFoundException, IOException, DAOException {
		aBC = new AdminBC();
		aBC.deleteByCode(code);
	}
	
	public Admin getAdminByCode(long code) throws ClassNotFoundException, IOException, DAOException {
		aBC = new AdminBC();
		return aBC.getByCode(code);
	}
	
	// Si sta assumendo che questo venga invocato quando uno studente sceglie di partecipare a un
	// corso
	public void createStudentCourse(StudentCourse sc) throws ClassNotFoundException, IOException, DAOException {
		scBC = new StudentCourseBC();
		scBC.create(sc);
	}
	
	// Sarebbe necessario forse?
//	public void updateStudentCourse(StudentCourse sc) throws ClassNotFoundException, IOException {
//		scBC = new StudentCourseBC();
//		scBC.update(sc);
//	}
	
	// Volendo si può rimuovere
//	public StudentCourse getStudentCourseByCode(long code) {
//		scBC = new StudentCourseBC();
//		return scBC.get(code);
//	}
	
	public void deleteStudentCourseByCode(long studentCode, long courseCode) throws ClassNotFoundException, IOException, DAOException {
		scBC = new StudentCourseBC();
		scBC.deleteByCode(studentCode, courseCode);
	}
	
	public void createStudent(Student student) throws ClassNotFoundException, IOException, SQLException {
		sBC = new StudentBC();
		sBC.create(student);
	}
	
	public void updateStudent(Student student) throws ClassNotFoundException, IOException, SQLException {
		sBC = new StudentBC();
		sBC.update(student);
	}

	public void deleteStudentByCode(long code) throws ClassNotFoundException, IOException, SQLException {
		sBC = new StudentBC();
		sBC.deleteByCode(code);
	}
	
	public Student getStudentByCode(long code) throws ClassNotFoundException, IOException, SQLException {
		sBC = new StudentBC();
		return sBC.getByCode(code);
	}

	public List<Student> getAllStudents() throws ClassNotFoundException, IOException, SQLException {
		sBC = new StudentBC();
		return sBC.getAll();
	}
	
	public int getStudentCount(long courseCode) throws ClassNotFoundException, IOException, SQLException {
		sBC = new StudentBC();
		return sBC.getCount();
	}
	
	public String getPopularCourse() throws ClassNotFoundException, IOException, SQLException {
		courseBC = new CourseBC();
		return courseBC.getMostPopular();
	}
	
	public Date getLatestCourseDate() throws ClassNotFoundException, IOException, SQLException {
		courseBC = new CourseBC();
		return courseBC.getLatest();
	}
	
	public int getAverageDuration() throws ClassNotFoundException, IOException, SQLException {
		courseBC = new CourseBC();
		return courseBC.getAverage();
	}
}
