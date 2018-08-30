package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.util.DBUtil;

public class StuClassDao implements IStuClassDao{

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//	}
	
	private DBUtil db = new DBUtil();

	@Override
	public List<StuClass> findAllStuClassInfo() {
		// TODO Auto-generated method stub
		String sql = "select * from stuclass";
		List stuClassList = new ArrayList();
		try {
			stuClassList = db.getQueryList(StuClass.class,sql,new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuClassList = new ArrayList();
			e.printStackTrace();
		}
		return stuClassList;
	}

	@Override
	public Map<String, Object> findStuClassById(int classId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "insert into stuclass values(?,?,?)";
		try {
			db.execute(sql,new Object[] {sc.getId(),sc.getName(),sc.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "update stuclass set id=?, name=?,deptName=? where id=?";
		try {
			db.execute(sql,new Object[] {sc.getId(),sc.getName(),sc.getDeptName(),sc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		String sql = "select name from stuclass where find_in_set(id,?)";
		List nameList = new ArrayList();
		try {
			nameList = db.getQueryList(sql,new Object[] {ids});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nameList;
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		String sql = "select * from stuclass  where  id in (select DISTINCT classId from teachercourse where teaId = ?)";
		List classList = new ArrayList();
		try {
			classList = db.getQueryList(StuClass.class,sql,new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classList;
	}

}
