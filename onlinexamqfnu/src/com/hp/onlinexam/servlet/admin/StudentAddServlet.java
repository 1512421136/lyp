package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.Department;

/**
 * Servlet implementation class StudentAddServlet
 */
@WebServlet("/studentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private IStuClassService scs = new StuClassService();
    private IStudentService ss = new StudentService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<StuClass> scList = scs.findAll();
		request.setAttribute("classList", scList);
		
		request.setAttribute("deptList", Department.values());
		request.getRequestDispatcher("manager/studentadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String stuId = request.getParameter("id");
		String stuName = request.getParameter("name");
		String stuPwd = request.getParameter("pwd");
		String stuSex =request.getParameter("sex");
		String stuBorn = request.getParameter("born");
		String stuSchool = request.getParameter("school");
		String deptName = request.getParameter("deptName");
		String classId = request.getParameter("classId");
		
		Student s = new Student();
		s.setId(Integer.valueOf(stuId));
		s.setName(stuName);
		s.setPwd(stuPwd);
		s.setSchool(stuSchool);
		s.setSex(stuSex);
		s.setBorn(stuBorn);
		s.setDeptName(deptName);
		s.setClassId(Integer.valueOf(classId));
		
		ss.addStudent(s);
		request.getRequestDispatcher("/studentQueryServlet").forward(request,response);
		
	
	}

}
