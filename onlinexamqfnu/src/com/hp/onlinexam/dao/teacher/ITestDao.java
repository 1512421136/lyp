package com.hp.onlinexam.dao.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Test;

public interface ITestDao {

	public void createTest(Test t) ;

	public List<Map<String, Object>> findTestsByTeaId(int teaId);
	
	/**
	 * 添加teaid是为了防止用户查看非权限资源
	 * @param id
	 * @param teaId
	 * @return
	 */
	public Map<String, Object> findTestById(int id, int teaId) ;
	public Map<String, Object> findStudentTestsById(int studentid,int testid);
	public List<Map<String,Object>> getTestByStudent(int id,String currData);
}
