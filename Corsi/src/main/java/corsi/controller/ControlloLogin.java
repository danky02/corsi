package corsi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import corsi.businesscomponent.utilities.Login;

@WebServlet("/loginControl")
public class ControlloLogin extends HttpServlet {
	private static final long serialVersionUID = -1797924191507752404L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("admincode");
//		String password = Algoritmo.convertiMD5(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		String adminpass = null;
		
		if(username != null && password != null) {
			try {
				Login l = new Login();
				adminpass = l.getAdminPass(username);
				if(adminpass != null) {
					if(adminpass.equals(password)) {
						session.setAttribute("username", username);
						Cookie userCookie = new Cookie("username", username);
						userCookie.setMaxAge(10 * 365 * 24 * 60 * 60);
						response.addCookie(userCookie);
						response.sendRedirect("courseAttendance.jsp");
					} else {
						response.sendRedirect("nopermission.jsp");
					}
				} else {
					response.sendRedirect("nopermission.jsp");
				}
			} catch(Exception e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
		}
	}

}
