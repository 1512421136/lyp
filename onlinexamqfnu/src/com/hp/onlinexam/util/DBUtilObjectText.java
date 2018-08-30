package com.hp.onlinexam.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.Teacher;

public class DBUtilObjectText {

//	public DBUtilObjectText() {
//		// TODO Auto-generated constructor stub
//	}
	
	
	//前两个返回的是map，第三个返回的是对象
	//getObject有三个重载的方法
	//获取的是查询结果的一条记录

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DBUtil db = new DBUtil();
//		String sql = "select * from teacher where id=1";
//		Map<String,Object> teacherMap = db.getObject(sql);
//		System.out.println(teacherMap);
		
		String sql2 = "select * from teacher where id=?";
		Map<String,Object> teacherMap2 = db.getObject(sql2,new Object[]{1});
//		Iterator<Entry<String,Object>> it = teacherMap2.entrySet().iterator();
//		while(it.hasNext()) {
//			Entry<String,Object> entry = it.next();
//			System.out.println(entry.getKey()+"@@@"+entry.getValue());
		
		//getObject三个参数的方法用法：po里的成员变量要和数据库的字段完全一致
		Teacher t = (Teacher)db.getObject(Teacher.class,sql2,new Object[] {1});
		
		String sql3 = "select * from questions where id=?";
		Question q = (Question) db.getObject(Question.class,sql3,new Object[] {1});
		
		Map<String,Object> questionsMap = db.getObject(sql3,new Object[] {1});
		Iterator<Entry<String,Object>> it2 = questionsMap.entrySet().iterator();
		while(it2.hasNext()) {
			Entry<String,Object> entry = it2.next();
			System.out.println(entry.getKey()+"@@@"+entry.getValue());
		}
			
			
		 		
	}

}
