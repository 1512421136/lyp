package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Paper;
import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.teacher.IPaperService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.PaperService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.TestService;

/**
 * Servlet implementation class StudentTest
 */
@WebServlet("/studentTest")
public class StudentTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private ITestService ts = new TestService();
    private IQuestionService qs = new QuestionService();
    private IPaperService ps = new PaperService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String testId = request.getParameter("testId");
		Student s = (Student) request.getSession().getAttribute("user");
		Map<String,Object> testInfo = ts.findStudentTestsById(s.getId(), Integer.valueOf(testId));
		List<Question> queList = qs.findQuestionByIds((String)testInfo.get("questions"));
		
		double scoreperques = Integer.valueOf((String)testInfo.get("scores"))*1.0/queList.size();
		request.setAttribute("scoreperques", scoreperques);

		request.setAttribute("test", testInfo);
		request.getSession().setAttribute("quesList", queList);
		request.getRequestDispatcher("student/exam.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String time = request.getParameter("hidden1");//获取答题时间
		List<Question> queList = (List<Question>) request.getSession().getAttribute("quesList");
		StringBuffer wrongIdsSB = new StringBuffer();
		StringBuffer wrongAnsSB = new StringBuffer();

		int wrongNums = 0;
		for(int i=0;i<queList.size();i++) {
			Question q = queList.get(i);
			String stuAns = request.getParameter("ques_"+q.getId());
			
			//和正确答案比较，如果错误则记录题号和id号
			
			if(!q.getAns().toLowerCase().equals(stuAns)) {
				wrongIdsSB.append(q.getId()).append(",");
				wrongAnsSB.append(stuAns).append(",");
				wrongNums++;
			}
		}//for循环结束，遍历完错题
		String wrongIds = wrongIdsSB.toString();
		String wrongAns = wrongAnsSB.toString();
		if(wrongIds.endsWith(",")){
			wrongIds = wrongIds.substring(0,wrongIds.length()-1);//省略最后的“，”
			wrongAns = wrongAns.substring(0,wrongAns.length()-1);
			
		}
		Map<String,Object> t = (Map<String, Object>) request.getSession().getAttribute("test");
		double scores = 1.0*Integer.valueOf((String) t.get("scores"))/queList.size()*(queList.size()-wrongNums);//算分值
		Student s = (Student) request.getSession().getAttribute("user");
		
		//所有信息准备就绪，封装成paper对象
		Paper p = new Paper();
		p.setCourseId((int)t.get("courseId"));
		p.setScore(scores);
		p.setStudentId(s.getId());
		p.setTestId((int)t.get("id"));
		p.setTime(time);
		p.setWrongAns(wrongAns);
		p.setWrongQueId(wrongIds);
		
		ps.save(p);
		request.getRequestDispatcher("student/index.jsp").forward(request, response);
	}

}
