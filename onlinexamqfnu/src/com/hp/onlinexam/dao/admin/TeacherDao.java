package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.util.DBUtil;

public class TeacherDao implements ITeacherDao{

	private DBUtil db = new DBUtil();

//	@Override
//	public List<Map<String, Object>> findAllTeacherInfo() {
//		// TODO Auto-generated method stub
//		String sql = "select * from teacher";
//		
//		List<Map<String,Object>> teacherList = db.getQueryList(Teacher.class,sql,new Object[] {});
//	}
	
	@Override
	public List<Teacher> findAllTeacherInfo() {
		// TODO Auto-generated method stub
		String sql = "select * from teacher";
		List teacherList = new ArrayList();
		 try {
			teacherList = db.getQueryList(Teacher.class,sql,new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			teacherList = new ArrayList();
			e.printStackTrace();
		}
		 return teacherList;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql = "insert into teacher values(?,?,?,?)";
		try {
			db.execute(sql,new Object[] {teacher.getId(),teacher.getName(),teacher.getPwd(),teacher.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
}
