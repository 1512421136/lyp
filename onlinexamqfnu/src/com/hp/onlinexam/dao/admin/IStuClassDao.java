package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.util.DBUtil;

public interface IStuClassDao {

	public List<StuClass> findAllStuClassInfo();

	public Map<String, Object> findStuClassById(int classId) ;

	public void addStuClassById(StuClass sc) ;

	public void updateStuClassById(StuClass sc) ;
	
	public List findClassNamesByIds(String ids);
	
	public List<StuClass> findStuClassesByTeacherId(int teaId);

}
