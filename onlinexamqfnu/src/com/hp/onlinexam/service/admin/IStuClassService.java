package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.StuClass;

public interface IStuClassService {	

	public List<StuClass> findAll() ;
	
	public void updateStuClass(StuClass sc);
	public Map<String,Object> findStuClassById(int id);
	
	public String findClassNamesByIds(String ids);

	public void addStuClass(StuClass sc);
	
	public List<StuClass> findStuClassesByTeacherId(int teaId);

}
