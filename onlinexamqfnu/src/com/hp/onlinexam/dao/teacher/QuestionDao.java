package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.util.DBUtil;

public class QuestionDao implements IQuestionDao{
	private DBUtil db = new DBUtil();

	@Override
	public List<Question> findAllQuestionInfo(String key, String value) {
		// TODO Auto-generated method stub
		String sql = null;
		List qtList = new ArrayList();
		if(key == null) {
			sql = "SELECT que.id ,c.name, que.courseId,que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id";
		}else {
			sql = "SELECT que.id ,c.name, que.courseId,que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id and " + key + " like '%" + value + "%'";
		}
		
//		if(null!=key && !"".equals(key)) {
//			sql+="and"+key+"like'%"+value+"%'";
//		}
		
		try {
			qtList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qtList;
	}

	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		String sql = "insert into questions(courseId,quetype,queTitle,choiceA,choiceB,choiceC,choiceD,ans) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql,new Object[] {q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		Map<String ,Object> q  = null;
		String sql = "select * from questions where id = ?";
		try {
			q= db.getObject(sql,new Object [] {id});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return q;
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where FIND_IN_SET (id,?)";
		List questionList = new ArrayList();
		try {
			questionList = db.getQueryList(Question.class, sql, new Object[] { ids });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == questionList)
			questionList = new ArrayList();
		return questionList;
	}

	

	@Override
	public void updateQuestionInfo(Question q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where courseId=?";
		List<Map<String, Object>> queList = new ArrayList();
		try {
			queList = db.getQueryList(sql,new Object[] {courseId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		
	}

}
