package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.Department;

/**
 * Servlet implementation class stuClassModifyServlet
 */
@WebServlet("/stuClassModifyServlet")
public class StuClassModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuClassModifyServlet() {
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
		String id = request.getParameter("info");
		StuClass sc =  (StuClass) scs.findStuClassById(Integer.valueOf(id));
		request.setAttribute("stuClassMap", sc);
		request.setAttribute("depList", Department.values());
		request.setAttribute("clanum",sc.getId());
		request.getRequestDispatcher("manager/stuclassmodify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String claNum = request.getParameter("clanum");
		String claName = request.getParameter("claname");
		String depInfo = request.getParameter("depInfo");
		
		StuClass sc = new StuClass();
		
		sc.setId(Integer.valueOf(claNum));
		sc.setName(claName);
		sc.setDeptName(depInfo);
		
		scs.updateStuClass(sc);//调用业务层的方法
		
		request.getRequestDispatcher("/stuClassQueryServlet").forward(request, response);
	}

}
