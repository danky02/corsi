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
		
		HttpSession session = request.getSession();
		String adminpass = null;
		
		if(username != null && password != null) {
			try {
				Login l = new Login();
				adminpass = l.getAdminPass(username);
				if(adminpass != null) {
					Cookie[] cookies = request.getCookies();
					Cookie attemptCookie = null;
					Integer attempt = 0;
					for(Cookie c : cookies){
						if(c.getName().equals("attempts")){
							attempt = Integer.parseInt(c.getValue());
							attemptCookie = c;
						}
					}
					if(adminpass.equals(password) && attempt < 4) {
						session.setAttribute("username", username);
						Cookie userCookie = new Cookie("username", username);
						userCookie.setMaxAge(10 * 365 * 24 * 60 * 60);
						if(attemptCookie != null) {
							attemptCookie.setMaxAge(0);
							response.addCookie(attemptCookie);
						}
						response.addCookie(userCookie);
						response.sendRedirect("courseAttendance.jsp");
					} else {
						for(Cookie c : cookies){
							if(c.getName().equals("attempts")){
								System.out.println("Cookie trovato");
								System.err.println("Valore attempts: " + c.getValue());
								attempt = Integer.parseInt(c.getValue());
								if(attempt == 4) {
									System.out.println("Attempts == 4");
									c.setMaxAge(30);
									response.addCookie(c);
									response.sendRedirect("toomanyattempts.jsp");
									return;
								} else {
									System.out.println("Attempts != 4");
									attempt++;
									c.setValue(attempt.toString());
									c.setMaxAge(30);
									response.addCookie(c);
									response.sendRedirect("wronglogin.jsp");
									return;
								}
							}
						}
						System.out.println("Creato cookie attempts");
						Cookie loginAttempts = new Cookie("attempts", "1");
						loginAttempts.setMaxAge(10 * 365 * 24 * 60 * 60);
						response.addCookie(loginAttempts);
						System.out.println("1");
						response.sendRedirect("wronglogin.jsp");
					}
				} else {
					System.out.println("adminpass == null");
					Cookie[] cookies = request.getCookies();
					for(Cookie c : cookies){
						if(c.getName().equals("attempts")){
							System.out.println("Cookie trovato");
							System.err.println("Valore attempts: " + c.getValue());
							Integer attempt = Integer.parseInt(c.getValue());
							if(attempt == 4) {
								System.out.println("Attempts == 4");
								c.setMaxAge(30);
								response.addCookie(c);
								response.sendRedirect("toomanyattempts.jsp");
								return;
							} else {
								System.out.println("Attempts != 4");
								attempt++;
								c.setValue(attempt.toString());
								c.setMaxAge(30);
								response.addCookie(c);
								response.sendRedirect("wronglogin.jsp");
								return;
							}
						}
					}
					System.out.println("Creato cookie attempts");
					Cookie loginAttempts = new Cookie("attempts", "1");
					loginAttempts.setMaxAge(10 * 365 * 24 * 60 * 60);
					response.addCookie(loginAttempts);
					System.out.println("1");
					response.sendRedirect("wronglogin.jsp");
				}
			} catch(Exception e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
		}
	}

}
