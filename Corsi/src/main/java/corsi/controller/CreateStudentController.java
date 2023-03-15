package corsi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import corsi.businesscomponent.StudentBC;
import corsi.businesscomponent.model.Student;
import corsi.businesscomponent.utilities.Validator;

@WebServlet("/createStudent")
public class CreateStudentController extends HttpServlet {
	private static final long serialVersionUID = -6998837354289720578L;

	public CreateStudentController() {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String strCode = request.getParameter("code");
			String strBackground = request.getParameter("background");
			
			if (name == null || surname == null || strCode == null || strBackground == null) {
				// non sono stati inseriti tutti i parametri richiesti
			}
			
			Student student = new Student();
			
			if (!(strBackground.equals("true") || strBackground.equals("false"))) {
				// parametro background non inserito correttamente
			}
			student.setBackground(strBackground.equals("true"));
			
			try {
				student.setCode(Long.parseLong(strCode));
			} catch (NumberFormatException exc) {
				// stringa codice invalida
			}
			
			student.setName(name);
			student.setSurname(surname);
			if (!Validator.getInstance().isValidStudent(student)) {
				// student non valido
			}
			
			StudentBC studentBC = new StudentBC();
			studentBC.create(student);
			
		} catch (Exception redirectException) {
			redirectException.printStackTrace();
			throw new ServletException(redirectException.getMessage());
		}
	}

}
