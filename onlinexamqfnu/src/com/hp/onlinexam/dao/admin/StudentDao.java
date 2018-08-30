package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.util.DBUtil;

public class StudentDao implements IStudentDao{
	
	private DBUtil db = new DBUtil();
	

	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "insert into student values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql,new Object[] {s.getId(),s.getName(),s.getPwd(),s.getSchool(),s.getSex(),s.getBorn(),s.getDeptName(),s.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		String sql = "select s.id,s.name,s.pwd,s.school,s.sex,s.born,s.classId,sc.name className from student s,stuclass sc where s.classId = sc.id";
		List<Map<String, Object>> stuList = new ArrayList<Map<String, Object>>();
		try {
			stuList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuList;
	}

}
