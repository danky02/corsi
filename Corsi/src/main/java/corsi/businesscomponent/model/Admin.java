package corsi.businesscomponent.model;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = 2383460512103183454L;

	private String adminName;
	private String adminSurname;
	private String adminUsername;
	private long adminCode;
	
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminSurname() {
		return adminSurname;
	}
	public void setAdminSurname(String adminSurname) {
		this.adminSurname = adminSurname;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public long getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(long adminCode) {
		this.adminCode = adminCode;
	}

	
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminSurname=" + adminSurname + ", adminUsername=" + adminUsername
				+ ", adminCode=" + adminCode + "]";
	}
	
}
