package com.hp.onlinexam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.login.ILoginService;
import com.hp.onlinexam.service.login.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private ILoginService ls = new LoginService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String role = request.getParameter("role");
		
		if("admin".equals(role)) {
			if("admin".equals(username)&&"123".equals(pwd));
			response.sendRedirect("manager/mindex.jsp");
		}
		
		else if("teacher".equals(role)) {
			 Teacher t = new Teacher();
			 t.setName(username);
			 t.setPwd(pwd);
			 t=ls.canLogin(t);
			 if(t!=null) {
				 request.getSession().setAttribute("user",t);
				 response.sendRedirect("teacher/tindex.jsp");
			 }
			  
		}
		else if("student".equals(role)) {
			 Student s = new Student();
			 s.setName(username);
			 s.setPwd(pwd);
			 s=ls.canLogin(s);
			 if(s!=null) {
				 request.getSession().setAttribute("user",s);
				 response.sendRedirect("student/index.jsp");
			 }
			  
		}
		
	}

}
