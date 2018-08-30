package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.util.Department;

/**
 * Servlet implementation class StuClassAddServlet
 */
@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuClassAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private IStuClassService scs = new StuClassService();  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("depList", Department.values());
		request.getRequestDispatcher("manager/stuclassadd.jsp").forward(request, response);
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
		
		scs.addStuClass(sc);//调用业务层的方法
		
	    /**
	     * 添加完班级信息后要重新查询
	     * 因为已经做了查询的功能。所以只要跳转到servlet就行
	     */
		request.getRequestDispatcher("/stuClassQueryServlet").forward(request, response);
	}

}








