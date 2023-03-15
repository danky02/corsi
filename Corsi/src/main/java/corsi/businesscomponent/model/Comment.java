package corsi.businesscomponent.model;

import java.io.Serializable;

public class Comment implements Serializable {
	private static final long serialVersionUID = 5361600266256026238L;

	private long studentCode;
	private long courseCode;
	private String comment;
	
	
	public long getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(long studentCode) {
		this.studentCode = studentCode;
	}
	public long getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(long courseCode) {
		this.courseCode = courseCode;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [studentCode=" + studentCode + ", courseCode=" + courseCode + ", comment=" + comment + "]";
	}
	
}
