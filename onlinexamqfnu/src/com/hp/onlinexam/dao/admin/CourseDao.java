package com.hp.onlinexam.dao.admin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.vo.TeacherCourseView;

public class CourseDao implements ICourseDao{
	
	private DBUtil db = new DBUtil();

	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		// TODO Auto-generated method stub
		String sql = "select tc.id tcId ,tc.teaId teacherId,tc.courseId courseId,tc.classId stuclassId,t.name teacherName,c.name courseName,sc.name stuclassName\r\n" + 
				"from teachercourse tc,teacher t,course c,stuclass sc\r\n" + 
				"where tc.teaId=t.id and tc.courseId=c.id and tc.classId=sc.id";
		List tcList = new ArrayList();
		try {
			tcList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tcList = new ArrayList();
			e.printStackTrace();
		}
		return tcList;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCourse(String name) {
		// TODO Auto-generated method stub
		String sql = "insert into course(name) values(?)";
		try {
			db.execute(sql,new Object[] {name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		String sql = "Select * from course where id=? ";
		Course c = new Course();
		try {
			c =  (Course) db.getObject(Course.class,sql,new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		String sql = "insert into teachercourse(teaId,courseId,ClassId) values(?,?,?)";
		try {
			db.execute(sql,new Object[] {tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		String sql = "select * from course";
		List courseList = new ArrayList();
		try {
			courseList = db.getQueryList(Course.class,sql,new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			courseList = new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	
		
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTourse(int tcId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		String sql = "select * from course where id in (select DISTINCT courseId from teachercourse where teaId = ?)";
		         

		List courseList = new ArrayList();
		try {
			courseList = db.getQueryList(Course.class,sql,new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}
	
	

}
