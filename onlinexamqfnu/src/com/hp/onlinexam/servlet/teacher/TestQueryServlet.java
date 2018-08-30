package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;

/**
 * Servlet implementation class TestQueryServlet
 */
@WebServlet("/testQueryServlet")
public class TestQueryServlet extends HttpServlet {

    private ITestService ts = new TestService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher t = (Teacher) request.getSession().getAttribute("user");
	    List<Map<String,Object>> testList = ts.findTestsByTeaId(t.getId());
	    request.setAttribute("testsList", testList);
		
		request.getRequestDispatcher("teacher/tmain.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
