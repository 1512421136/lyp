package com.hp.onlinexam.dao.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Question;

public interface IQuestionDao {

	public List<Question> findAllQuestionInfo(String key, String value);
	
	public void addQuestion(Question q);

	public Map<String, Object> findQuestionById(int id);
	
	/**
	 * 在数据库存储的时候，题目集合作为一个字段以逗号分开
	 * @param ids
	 * @return
	 */
	public List<Question> findQuestionByIds(String ids) ;

	public void updateQuestionInfo(Question q);

	/**
	 * 根据课程名称提取试题ID
	 * 
	 * @param courseId
	 * @return
	 */
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId);

	public void deleteQuestion(int id) ;

}
