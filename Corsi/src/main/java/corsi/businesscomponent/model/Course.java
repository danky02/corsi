package corsi.businesscomponent.model;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {
	private static final long serialVersionUID = 7487137218309013616L;

	private long courseCode;
	private String courseName;
	private Date startDate;
	private Date endDate;
	private double courseCost;
	private String courseComment;
	private String courseRoom;
	private long professorCode;
	private int freeSeats;
	
	public long getProfessorCode() {
		return professorCode;
	}

	public void setProfessorCode(long professorCode) {
		this.professorCode = professorCode;
	}

	public long getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(long courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getCourseCost() {
		return courseCost;
	}

	public void setCourseCost(double courseCost) {
		this.courseCost = courseCost;
	}

	public String getCourseComment() {
		return courseComment;
	}

	public void setCourseComment(String courseComment) {
		this.courseComment = courseComment;
	}

	public String getCourseRoom() {
		return courseRoom;
	}

	public void setCourseRoom(String courseRoom) {
		this.courseRoom = courseRoom;
	}

	public int getFreeSeats() {
		return freeSeats;
	}

	public void setFreeSeats(int freeSeats) {
		this.freeSeats = freeSeats;
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", courseCost=" + courseCost + ", courseComment=" + courseComment
				+ ", courseRoom=" + courseRoom + "]";
	}

}
