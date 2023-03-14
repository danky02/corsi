package corsi.businesscomponent.model;

import java.io.Serializable;

public class Student implements Serializable{
private static final long serialVersionUID = 1410261715974377560L;
	
	private String student_name;
	private String student_surname;
	private long student_code;
	private boolean educational_background;
	
	public Student() {
		
	}
	
	public String getName() {
		return this.student_name;
	}
	
	public void setName(String n) {
		this.student_name = n;
	}
	
	public String getSurname() {
		return this.student_surname;
	}
	
	public void setSurname(String s) {
		this.student_surname = s;
	}
	
	public long getCode() {
		return this.student_code;
	}
	
	public void setCode(long code) {
		this.student_code = code;
	}
	
	public boolean getBackground() {
		return this.educational_background;
	}
	public void setBackground(boolean b) {
		this.educational_background = b;
	}
	
	


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) return false;
		Student b = (Student)obj;
		
		if (!(this.student_name.equals(b.getName()))) return false;
		if (!(this.student_surname.equals(b.getSurname()))) return false;
		if (this.student_code != b.getCode()) return false;
		if (this.educational_background != b.getBackground()) return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Studente [student_name=" + student_name + ", student_surname=" + student_surname + ", student_code="
				+ student_code + ", educational_background=" + educational_background + "]";
	}
	
}