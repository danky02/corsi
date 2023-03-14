package corsi.businesscomponent.model;

import java.io.Serializable;

public class Professor implements Serializable {
	private static final long serialVersionUID = -4303990580010804056L;

	private String nome;
	private String cognome;
	private String cv;
	private Long code;
	
	public Professor() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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
		return "Professor [nome=" + nome + ", cognome=" + cognome + ", cv=" + cv + ", code=" + code + "]";
	}
	
}
