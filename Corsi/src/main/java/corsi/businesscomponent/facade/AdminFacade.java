package eu.tasgroup.businesscomponent.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AdminFacade {
	private static AdminFacade afInstance;
	private CommentBC commBC;
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
	public void deleteCommentByCode(long code) throws ClassNotFoundException, IOException {
		Commento c = new Commento();
		commBC = new CommentBC();
		c = getCommentByCode(code);
		commBC.delete(c);
	}
	
	// Si può rimuovere
	public Commento getCommentByCode(long code) throws ClassNotFoundException, IOException {
		commBC = new CommentBC();
		return commBC.findCommentByCode(code);
	}

	// Inoltre, per quanto riguarda il BC del comment, se la classe venisse inclusa
	// all'interno del course basta cambiare il BC
	public List<Commento> getAllComments() throws ClassNotFoundException, IOException {
		commBC = new CommentBC();
		return commBC.getAll();
	}
	
	public int getCommentCount(long codeCourse) throws ClassNotFoundException, IOException {
		courseBC = new courseBC();
		return courseBC.getCommentsCount();
	}

	public void createCourse(Course course) throws ClassNotFoundException, IOException {
		courseBC = new CourseBC();
		courseBC.create(course);
	}
	
	public void updateCourse(Course course) throws ClassNotFoundException, IOException {
		courseBC = new CourseBC();
		courseBC.update(course);
	}

	public void deleteCourseByCode(long code) throws ClassNotFoundException, IOException {
		Course c = new Course();
		courseBC = new CourseBC();
		c = getCourseByCode(code);
		courseBC.delete(c);
	}
	
	public void createProfessor(Professor professor) throws ClassNotFoundException, IOException {
		pBC = new ProfessorBC();
		pBC.create(professor);
	}
	
	public void updateProfessor(Professor professor) throws ClassNotFoundException, IOException {
		pBC = new ProfessorBC();
		pBC.update(professor);
	}

	public void deleteProfessorByCode(long code) throws ClassNotFoundException, IOException {
		Course c = new Course();
		courseBC = new courseBC();
		c = getCommentByCode(code);
		commBC.delete(c);
	}
	
	public void getProfessorByCode(long code) throws ClassNotFoundException, IOException {
		pBC = new ProfessorBC();
		return pBC.findProfessorByCode(code);
	}
	
	public List<Professor> getAllProfessors() throws ClassNotFoundException, IOException {
		pBC = new ProfessorBC();
		return pBC.getAll();
	}
	
	public void createAdmin(Admin admin) throws ClassNotFoundException, IOException {
		aBC = new AdminBC();
		aBC.create(admin);
	}
	
	public void updateAdmin(Admin admin) throws ClassNotFoundException, IOException {
		aBC = new AdminBC();
		aBC.update(admin);
	}

	public void deleteAdminByCode(Admin admin) throws ClassNotFoundException, IOException {
		Admin a = new Admin();
		aBC = new AdminBC();
		aBC.delete(a);
	}
	
	public void getAdminByCode(long code) throws ClassNotFoundException, IOException {
		aBC = new AdminBC();
		return aBC.findAdminByCode(code);
	}
	
	// Si sta assumendo che questo venga invocato quando uno studente sceglie di partecipare a un
	// corso
	public void createStudentCourse(StudentCourse sc) throws ClassNotFoundException, IOException {
		scBC = new StudentCourseBC();
		scBC.create(sc);
	}
	
	// Sarebbe necessario forse?
//	public void updateStudentCourse(StudentCourse sc) throws ClassNotFoundException, IOException {
//		scBC = new StudentCourseBC();
//		scBC.update(sc);
//	}
	
	// Volendo si può rimuovere
	public StudentCourse getStudentCourseByCode(long code) {
		scBC = new StudentCourse();
		return scBC.findCommentByCode(code);
	}
	
	public void deleteStudentCourseByCode(long code) throws ClassNotFoundException, IOException {
		StudentCourse cs = new StudentCourse();
		scBC = new StudentCourseBC();
		cs = getStudentCourseByCode(code);
		scBC.delete(cs);
	}
	
	public void createStudent(Student student) throws ClassNotFoundException, IOException {
		sBC = new StudentBC();
		sBC.create(student);
	}
	
	public void updateStudent(Student student) throws ClassNotFoundException, IOException {
		sBC = new StudentBC();
		sBC.update(student);
	}

	public void deleteStudentByCode(long code) throws ClassNotFoundException, IOException {
		Student s = new Student();
		sBC = new StudentBC();
		s = getStudentByCode(code);
		sBC.delete(a);
	}
	
	public void getStudentByCode(long code) throws ClassNotFoundException, IOException {
		sBC = new StudentBC();
		return aBC.findStudentByCode(code);
	}

	public List<Student> getAllStudents() throws ClassNotFoundException, IOException {
		sBC = new StudentBC();
		return sBC.getAll();
	}
	
	public int getStudentCount(long courseCode) throws ClassNotFoundException, IOException {
		courseBC = new CourseBC();
		return courseBC.getStudentCount();
	}

}
