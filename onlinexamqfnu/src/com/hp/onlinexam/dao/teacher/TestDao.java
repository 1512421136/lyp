package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.util.ToolUtil;

public class TestDao implements ITestDao{
	private DBUtil db = new DBUtil();


	@Override
	public void createTest(Test t) {
		// TODO Auto-generated method stub
		String sql = "insert into test (name,courseId,endDate,questions,teacherId,classIds,testTime,scores) values (?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql,new Object[] {t.getName(),t.getCourseId(),t.getEndDate(),t.getQuestions(),t.getTeacherId(),t.getClassIds(),t.getTestTime(),t.getScores()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		String sql = "select t.*,c.name courseName,GROUP_CONCAT(sc.name) classNames from test t,course c,stuclass sc where t.courseId=c.id and FIND_IN_SET(sc.id,t.classIds) and t.teacherId = ? and t.endDate>? GROUP BY t.id";
		List<Map<String,Object>> testList = new ArrayList();
	    try {
			testList = db.getQueryList(sql,new Object[]{teaId,ToolUtil.getCurrentTime()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testList;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		String sql = "SELECT t.id, t.name testName,t.courseId,t.endDate,t.questions,t.classIds,t.testTime,t.scores,c.name courseName , sc.name className FROM test t , course c, stuclass sc WHERE t.courseId = c.id and t.id = ? and sc.id = (SELECT classId from student where id = ?)";
		Map<String,Object> testMap = new HashMap();
		try {
			testMap = db.getObject(sql,new Object[] {testid,studentid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		String sql = "SELECT DISTINCT t.id, t.name testName, t.courseId,c.name courseName,t.endDate ,t.classIds from test t,course c,student s WHERE t.courseId = c.id and FIND_IN_SET(s.classId,t.classIds)  and t.id not in (SELECT testId from papers) and s.id = ? and t.endDate >?";

		List<Map<String, Object>> stuRecentTests = new ArrayList();
		try {
			stuRecentTests = db.getQueryList(sql,new Object[] {id,currData});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuRecentTests;
	}

}
