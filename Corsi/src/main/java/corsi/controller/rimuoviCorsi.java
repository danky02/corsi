package corsi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import corsi.businesscomponent.CourseBC;

@WebServlet("/rimuoviCorsi")
public class rimuoviCorsi extends HttpServlet {
	private static final long serialVersionUID = 5925230769794962012L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			CourseBC cBC = new CourseBC();
		long id = 0;
		id = Long.parseLong(request.getParameter("coursecode"));
			if (id != 0) {
				cBC.deleteByCode(id);
			}
			response.sendRedirect("EliminaCorsi.jsp");
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
