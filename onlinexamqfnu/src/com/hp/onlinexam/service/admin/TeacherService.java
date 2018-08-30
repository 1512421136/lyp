package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.TeacherDao;
import com.hp.onlinexam.po.Teacher;

public class TeacherService implements ITeacherService {
	
	private TeacherDao td = new TeacherDao();

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return td.findAllTeacherInfo();
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		td.addTeacher(teacher);

	}

	@Override
	public void updateTeacher(Teacher teacher, int oldid) {
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
