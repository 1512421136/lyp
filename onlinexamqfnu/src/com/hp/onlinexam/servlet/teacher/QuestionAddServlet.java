package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;

/**
 * Servlet implementation class QuestionAddServlet
 */
@WebServlet("/questionAddServlet")
public class QuestionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private IQuestionService qs = new QuestionService();
    private ICourseService cs = new CourseService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Course> courseList = cs.findAllCourses();
		
		request.setAttribute("courseList", courseList);
		request.getRequestDispatcher("teacher/quesadd.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courseId = request.getParameter("courseId");
		String queType = request.getParameter("queType");
		String queTitle = request.getParameter("queTitle");
		String choiceA = request.getParameter("choiceA");
		String choiceB = request.getParameter("choiceB");
		String choiceC = request.getParameter("choiceC");
		String choiceD = request.getParameter("choiceD");
		String ans = request.getParameter("ans");
//		String queExist = request.getParameter("queExist");
		
		Question q = new Question();
		q.setCourseId(Integer.valueOf(courseId));
		q.setQueType(Integer.valueOf(queType));
		q.setQueTitle(queTitle);
		q.setChoiceA(choiceA);
		q.setChoiceB(choiceB);
		q.setChoiceC(choiceC);
		q.setChoiceD(choiceD);
		q.setAns(ans);
//		q.setQueExist(Integer.valueOf(queExist));
		
		qs.addQuestion(q);
		request.getRequestDispatcher("/questionQueryServlet").forward(request, response);

	}

}
