package corsi.businesscomponent.model;

public class Student {
private static final long serialVersionUID = 1410261715974377560L;
	
	private String student_name;
	private String student_surname;
	private long student_code;
	private boolean educational_background;
	
	public Student() {
	}
	public String getStudent_name() {
		return student_name;
	}
	public String getStudent_surname() {
		return student_surname;
	}
	public long getStudent_code() {
		return student_code;
	}
	public boolean isEducational_background() {
		return educational_background;
	}
	@Override
	public String toString() {
		return "Studente [student_name=" + student_name + ", student_surname=" + student_surname + ", student_code="
				+ student_code + ", educational_background=" + educational_background + "]";
	}
	
}

