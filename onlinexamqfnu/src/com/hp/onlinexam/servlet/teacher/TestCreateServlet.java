package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;

@WebServlet("/testCreateServlet")
public class TestCreateServlet extends HttpServlet {

    private ITestService ts = new TestService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher t = (Teacher) request.getSession().getAttribute("user");
		Test test = (Test) request.getSession().getAttribute("test");
		test.setTeacherId(t.getId());
		ts.createTest(test);
		request.getSession().removeAttribute("test");
		/**
		 * 页面跳转有两种方式
		 * 如果在servlet里有网页面传递的数据，例如request.seAttribute()
		 * 则必须用res.getRequestDispatcher("").forward(request, response);
		 * 如果不需要，用req.sendredirect也行
		 */
		request.getRequestDispatcher("/testQueryServlet").forward(request, response);
	}

}
