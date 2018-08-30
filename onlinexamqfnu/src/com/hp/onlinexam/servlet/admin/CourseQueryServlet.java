package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
//import com.hp.onlinexam.service.admin.IStuClassService;
//import com.hp.onlinexam.service.admin.ITeacherService;
//import com.hp.onlinexam.service.admin.StuClassService;
//import com.hp.onlinexam.service.admin.TeacherService;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/courseQueryServlet")
public class CourseQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private ICourseService cs = new CourseService();
//    private ITeacherService ts = new TeacherService();
//    private IStuClassService scs = new StuClassService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	List<Course> courseList = cs.findAllCourses();
	request.setAttribute("tcList",courseList);
	request.getRequestDispatcher("manager/coursemanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
