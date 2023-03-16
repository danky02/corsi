package corsi.businesscomponent.model;

public class CourseComment {

	private long CourseCode;
	private long StudentCode;
	private String CommentDesc;

	public long getCourseCode() {
		return CourseCode;
	}

	public void setCourseCode(long courseCode) {
		CourseCode = courseCode;
	}

	public long getStudentCode() {
		return StudentCode;
	}

	public void setStudentCode(long studentCode) {
		StudentCode = studentCode;
	}

	public String getCommentDesc() {
		return CommentDesc;
	}

	public void setCommentDesc(String commentDesc) {
		CommentDesc = commentDesc;
	}

	@Override
	public String toString() {
		return "CourseComment [CourseCode=" + CourseCode + ", StudentCode=" + StudentCode + ", CommentDesc="
				+ CommentDesc + "]";
	}

}
