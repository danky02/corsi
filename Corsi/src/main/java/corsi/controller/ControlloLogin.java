package corsi.businesscomponent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import corsi.businesscomponent.security.Algoritmo;
import corsi.businesscomponent.utilities.Login;

@WebServlet("/controlloLogin")
public class ControlloLogin extends HttpServlet {
	private static final long serialVersionUID = -1797924191507752404L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = Algoritmo.convertiMD5(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		String userpass = null;
		String adminpass = null;
		
		if(username != null && password != null) {
			try {
				Login l = new Login();
				adminpass = l.getAdminPass(username);
				if(adminpass != null) {
					if(adminpass.equals(password)) {
						session.setAttribute("admin", username);
						response.sendRedirect("admin/admin.jsp");
					}
				}else {
					response.sendRedirect(".jsp");
				}
			} catch(Exception e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
		}
	}

}
