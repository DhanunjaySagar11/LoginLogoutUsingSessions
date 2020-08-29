package org.code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public SiteController() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action= request.getParameter("action");
		//forwarding the page to login.jsp based on the action feild
		switch (action) {
		case "login":
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			break;

		default:
			break;
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action= request.getParameter("action");
	switch (action) {
	//action login submit is from login.jsp
	case "loginSubmit":
		authenticate(request, response);
		
		break;

	default:
		break;
	}
	}
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=	request.getParameter("name");
		String password= request.getParameter("password");
		if(name.equalsIgnoreCase("Dhanunjay")&&password.equalsIgnoreCase("sagar"))
		{
			//invalidating the sessions
			request.getSession().invalidate();
			//getting session
			HttpSession newSession= request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			
			//setting name for the session
			newSession.setAttribute("SessionName", name);
			//if the cookies is disable in browser
			String encode= response.encodeURL(request.getContextPath());
			//request.getRequestDispatcher("output.jsp").forward(request, response);
			
			
			//redirecting memberArea.jsp page using url based on servlet(memberAreaController)
			response.sendRedirect(encode+"/MemberAreaController?action=memberArea");
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/SiteController?action=login");
			
		}
	}
}
