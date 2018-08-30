package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.IStudentDao;
import com.hp.onlinexam.dao.admin.StudentDao;
import com.hp.onlinexam.po.Student;

public class StudentService implements IStudentService{

	private IStudentDao sd = new StudentDao();
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		sd.addStudent(s);
		
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
		return sd.findAll();
	}
	

}
