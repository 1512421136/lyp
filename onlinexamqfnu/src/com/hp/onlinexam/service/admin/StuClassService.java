package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.StuClassDao;
import com.hp.onlinexam.po.StuClass;

public class StuClassService implements IStuClassService {
	
	/**
	 * 向上转型
	 * 1.声明是借口，等号右侧是实现类
	 * 2.声明是父类，等号右侧是子类
	 */
	private StuClassDao scd = new StuClassDao();

	@Override
	public List<StuClass> findAll() {
		// TODO Auto-generated method stub
		return scd.findAllStuClassInfo();
	}

	@Override
	public void addStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.addStuClassById(sc);
	}

	@Override
	public void updateStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.updateStuClassById(sc);
	}

	@Override
	public Map<String, Object> findStuClassById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		List nameList = scd.findClassNamesByIds(ids);
		//如果字符串多次拼接要使用StringBuffer
		if(nameList == null || nameList.size()<1)
			return "";
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<nameList.size();i++) {
			Map stuMap = (Map)nameList.get(i);
			sb.append(stuMap.get("name")).append(" ");
		}
		return sb.toString();
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		return scd.findStuClassesByTeacherId(teaId);
	}

}
