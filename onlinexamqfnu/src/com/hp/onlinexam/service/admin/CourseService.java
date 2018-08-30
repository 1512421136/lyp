package com.hp.onlinexam.service.admin;

import java.util.List;

import com.hp.onlinexam.dao.admin.CourseDao;
import com.hp.onlinexam.dao.admin.ICourseDao;
import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.vo.TeacherCourseView;

public class CourseService implements ICourseService{
	private ICourseDao cd = new CourseDao();
	

	@Override
	public List<TeacherCourseView> findAll() {
		// TODO Auto-generated method stub
		return cd.findAllTeaCourInfo();
	}

	@Override
	public TeacherCourseView findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		return cd.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return cd.findAllCourses();
	}

	@Override
	public List<Course> findAllCourses(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTeacherCourse(int tcId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse(String courseName) {
		// TODO Auto-generated method stub
		cd.addCourse(courseName);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		// TODO Auto-generated method stub
		cd.addTeacherCourse(tc);
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		return cd.findCoursesByTeacherId(teaId);
	}

}
