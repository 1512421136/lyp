package com.hp.onlinexam.service.teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.IQuestionDao;
import com.hp.onlinexam.dao.teacher.QuestionDao;
import com.hp.onlinexam.po.Question;

public class QuestionService implements IQuestionService{
	private IQuestionDao qd = new QuestionDao();

	@Override
	public List<Question> findAll(String key, String value) {
		// TODO Auto-generated method stub
		return qd.findAllQuestionInfo(key, value);
	}

	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		qd.addQuestion(q);
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		return qd.findQuestionById(id);
	}

	@Override
	public void updateQuestionInfo(Question q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num) {
		// TODO Auto-generated method stub
		/**
		 * 1.根据课程id查询复合条件的试题集合
		 * 2.试题随机，把试题顺序打乱
		 * 3.如果试题数量足够，取全num道题，如果不够，取出所有试题
		 */
		List<Map<String, Object>> queList = qd.findQuestionsByCourseId(courseId);
		if(null == queList || queList.size()<1) 
			return new ArrayList<Map<String,Object>>();
		
		Collections.shuffle(queList);//打乱试题
		if(queList.size()>=num)
			return queList.subList(0, num);
		else
			return queList;
	}

	@Override
	public String testQuestionIds(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		if (null == list)
			return "";
		/**
		 * 字符串的拼接尽量用StringBuffer
		 * String是不可变的，例如String s = "a"+"b"; s +="c"
		 */
		StringBuffer sb = new StringBuffer();
		for (int i = 0 ; i <list.size();i++){
			Map<String,Object> questionMap = list.get(i);
			sb.append(questionMap.get("id")+",");
		}
		String ids = sb.toString();
		if (list.size()>0)
			ids= ids.substring(0, ids.length()-1);
		return ids;

	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		if (null == ids)
			return new ArrayList<Question>();
		else
			return qd.findQuestionByIds(ids);

	}

}
