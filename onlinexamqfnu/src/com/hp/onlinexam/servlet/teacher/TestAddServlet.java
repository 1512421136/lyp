package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.util.ToolUtil;

/**
 * Servlet implementation class TestAddServlet
 */
@WebServlet("/testAddServlet")
public class TestAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private ICourseService cs = new CourseService();
    private IStuClassService scs = new StuClassService();
    private IQuestionService qs = new QuestionService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 从session中获取当前用户登录
		 */
		Teacher t = (Teacher) request.getSession().getAttribute("user");
		List<Course> courseList = cs.findCoursesByTeacherId(t.getId());
		request.setAttribute("courseList", courseList);

		List<StuClass> classList = scs.findStuClassesByTeacherId(t.getId());
		request.setAttribute("classesList", classList);
		request.getRequestDispatcher("teacher/testadd.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String courseId = request.getParameter("courseid");
        String testName = request.getParameter("testname");
        String endDate = request.getParameter("enddate");
        String sinScores = request.getParameter("sinscores");
        String sinNums = request.getParameter("sinnum");
        String testTime = request.getParameter("testtime");
        String [] classIds = request.getParameterValues("classCheck");
        //复选框需要用getParamterValues()方法获得，并且返回值是数组
        //有些信息需要信息加工，例如考试科目，班级名称。利用id找到名称
        //选题。根据课程查询所有试题，然后把试题随机
        //把信息封装到对象Test（Test里需要什么就准备什么）    
        
        
        Course c  = cs.findCourseById(Integer.valueOf(courseId));
        String classIdtoString = ToolUtil.arraytoString(classIds);
        String classNames = scs.findClassNamesByIds(classIdtoString);
        //根据id查询课程对象
        //根据班级id的数组查询班级名称
      
        List<Map<String,Object>> questionList = qs.collectQuestions(Integer.valueOf(courseId),Integer.valueOf(sinNums));
        String quesIds = qs.testQuestionIds(questionList);
        //一下信息为封装航对象过程
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//日期转换
        try {
			date = sdf.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Test test = new Test();
        test.setClassIds(classIdtoString);
        test.setCourseId(Integer.valueOf(courseId));
        test.setEndDate(date);
        test.setName(testName);
        test.setQuestions(quesIds);
        test.setScores(sinScores);
        test.setTestTime(Integer.valueOf(testTime));
        /**
         * 把页面上的信息放在request里
         * 随着页面跳转使用这几个数据
         */
        request.setAttribute("c", c);
        request.setAttribute("quesList", questionList);
        request.setAttribute("classNames", classNames);
        
        request.getSession().setAttribute("test", test);
        request.getRequestDispatcher("teacher/test.jsp").forward(request, response);
	}

}
