package corsi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import corsi.businesscomponent.facade.AdminFacade;
import corsi.businesscomponent.model.Admin;
import corsi.businesscomponent.utilities.Validator;

@WebServlet("/profilo")
public class Profilo extends HttpServlet {
	private static final long serialVersionUID = 4371833762505344764L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Admin admin = new Admin();

		try {
			admin = AdminFacade.getInstance().getAdminByUsername(request.getParameter("username"));
			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("cognome"));
			admin.setAdminName(request.getParameter("nome"));
			admin.setAdminSurname(request.getParameter("cognome"));
			if(Validator.getInstance().isValidAdmin(admin))
				AdminFacade.getInstance().updateAdmin(admin);
			else {
				response.sendRedirect("profilo.jsp");
			}

		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
		response.sendRedirect("courseAttendance.jsp");
	}

}
