package com.hp.onlinexam.util;

public class DBUtilExText {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DBUtil db = new DBUtil();
		String sql = "insert into course (name) value (123)";
		db.execute(sql);		

	}

}
