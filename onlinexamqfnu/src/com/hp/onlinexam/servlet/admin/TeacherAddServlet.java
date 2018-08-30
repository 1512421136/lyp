package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;

/**
 * Servlet implementation class TeacherAddServlet
 */
@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private ITeacherService ts = new TeacherService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("deptList",Department.values());
		request.getRequestDispatcher("manager/teacheradd.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teaNum = request.getParameter("num");
		String teaName = request.getParameter("username");
		String teaPwd = request.getParameter("password");
		String depInfo = request.getParameter("dep");
		
		Teacher teacher = new Teacher();
		teacher.setId(Integer.valueOf(teaNum));
		teacher.setName(teaName);
		teacher.setPwd(teaPwd);
		teacher.setDeptName(depInfo);
		
		ts.addTeacher(teacher);
		request.getRequestDispatcher("/teacherQueryServlet").forward(request, response);
	}

}
