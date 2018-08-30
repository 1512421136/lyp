package com.hp.onlinexam.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexam.po.Course;

public class DBUtilQueryListText {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DBUtil db = new DBUtil();
		String sql = "select * from teacher";
		db.getQueryList(sql);
		List<Map<String,Object>> teacherList = db.getQueryList(sql);
		for(int i=0;i<teacherList.size();i++) {
			Map<String,Object> teaMap  = teacherList.get(i);

			Iterator<Entry<String,Object>> it = teaMap.entrySet().iterator();
			while(it.hasNext()){
				Entry<String,Object> entry = it.next();
				System.out.println(entry.getKey()+"@"+entry.getValue());
			}
			System.out.println();
		}
		
	
		
		String sql3 = "select * from teacher where deptName=? ";
		List<Map<String,Object>> teacherList2 = db.getQueryList(sql3,new Object[] {"开发"});
		System.out.println(teacherList2);
		
		System.out.println();

		String sql4 = "select * from course";
		List courseList = db.getQueryList(Course.class,sql3,new Object[] {});
		System.out.println(courseList);
	}

}
