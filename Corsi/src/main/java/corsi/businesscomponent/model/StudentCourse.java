package corsi.businesscomponent.model;

import java.io.Serializable;

public class StudentCourse implements Serializable {
	private static final long serialVersionUID = -5191661817751840987L;

	private long courseCode;
	private long studentCode;

	public long getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(long courseCode) {
		this.courseCode = courseCode;
	}

	public long getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(long studentCode) {
		this.studentCode = studentCode;
	}

	@Override
	public String toString() {
		return "StudentCourse [courseCode=" + courseCode + ", studentCode=" + studentCode + "]";
	}

}
