package com.hp.onlinexam.po;

/**
 * 老师表
 * @author Administrator
 *
 */
public class Teacher {
	private int id;
	private String name;
	private String pwd;
	private String deptName;
	private int role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getPassword() {
//		return pwd;
//	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
//	public void setPassword(String password) {
//		this.pwd = password;
//	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
