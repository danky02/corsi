package corsi.businesscomponent.model;

import java.io.Serializable;

public class Professor implements Serializable {
	private static final long serialVersionUID = -4303990580010804056L;

	private String name;
	private String surname;
	private String cv;
	private Long code;
	
	public Professor() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Professor [name=" + name + ", surname=" + surname + ", cv=" + cv + ", code=" + code + "]";
	}
	
	
	
}

	