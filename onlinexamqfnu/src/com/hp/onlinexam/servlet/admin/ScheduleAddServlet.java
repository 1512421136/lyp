package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;

/**
 * Servlet implementation class ScheduleAddServlet
 */
@WebServlet("/scheduleAddServlet")
public class ScheduleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private ICourseService cs = new CourseService();
    private ITeacherService ts = new TeacherService();
    private IStuClassService scs = new StuClassService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Course> courseList = cs.findAllCourses();
		request.setAttribute("courseList", courseList);
		
		List<Teacher> teaList = ts.findAll();
		request.setAttribute("teaList", teaList);
		
		List<StuClass> stuclList = scs.findAll();
		request.setAttribute("stuclList", stuclList);

		request.getRequestDispatcher("manager/scheduleadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course = request.getParameter("course");
		String teacher = request.getParameter("teacher");
		String stuclass = request.getParameter("stuclass");
		
		TeacherCourse tc = new TeacherCourse();
		tc.setClassId(Integer.valueOf(stuclass));
	    tc.setCourseId(Integer.valueOf(course));
		tc.setTeaId(Integer.valueOf(teacher));
		
		cs.addSchedule(tc);
		request.getRequestDispatcher("/scheduleQueryServlet").forward(request, response);
	}

}
